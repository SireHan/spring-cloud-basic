package com.squirrel.springcloud.provider.gen.config;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.druid.pool.DruidPooledPreparedStatement;
import com.alibaba.druid.pool.DruidPooledResultSet;
import com.alibaba.druid.pool.DruidPooledStatement;
import com.squirrel.springcloud.provider.common.util.ParseUtil;
import com.squirrel.springcloud.provider.gen.status.DBTypeEnum;
import com.squirrel.springcloud.provider.gen.status.GenTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 代码生成Manager
 * @author JoinHan
 * @version 2017-09-06
 */
public class GenManger{

    private static Logger logger = LoggerFactory.getLogger(GenManger.class);

    private GenConfig genConfig = null;
    private DbManger dbManger = null;//数据库连接管理
    private SqlManger sqlManger = null;
    private List<TableDataModal> tableDataModalList = null;//代码生成的数据来源

    public GenManger(GenConfig genConfig) {
        if(genConfig == null){
            //初始化基础配置
            this.genConfig = new GenConfig();
        }else{
            this.genConfig  = genConfig;
        }
        //根据配置数据连接
        this.dbManger = DbManger.initDb(this.genConfig.getDBProperties());
        //根据数据库配置 形成所需使用的sql
        this.sqlManger = SqlManger.initSql(this.genConfig,this.dbManger);
    }

    public static void main(String[] args) {
        //目前仅支持 mysql数据库
        GenConfig genConfig = new GenConfig();

        //指定表信息 作者 版本 时间 如果没有配置取properties文件 配置文件没有则为空
        TableDataModal tableDataModal = new TableDataModal();
        tableDataModal.setFunctionName("系统用户表");
        tableDataModal.getTable().setTableName("sys_user");

        genConfig.addTable(tableDataModal);//可以添加多个表配置

        GenManger genManger = new GenManger(genConfig);
        //第一种方式 指定数据库中某一张表 根据表的结构生成文件
        genManger.generator();

        //根据配置 数据查询 初始化 tableDataModalList
        //获取模板 替换数据 输出文件
    }

    /**
     * 代码生成的入口
     */
    public void generator() {
        if(genConfig.getGenTypeEnum() == GenTypeEnum.DBTableAssign){
            //根据指定的表生成TableDataModal 数据列表
            tableDataModalList = makeModal(dbManger,genConfig,sqlManger);
        }
    }

    private List<TableDataModal> makeModal(DbManger dbManger, GenConfig genConfig, SqlManger sqlManger) {

        List<TableDataModal> tableDataModals = new ArrayList<>();
        //获取数据库连接 查询表信息
        try(DruidPooledConnection connection = dbManger.getConnection()){
            DruidPooledStatement stmtNew = (DruidPooledStatement) connection.createStatement();

            Map<String,String> param = new HashMap<>();
            for(TableDataModal tbname:genConfig.getTableNames()){
                TableDataModal tableDataModal = new TableDataModal();

                tableDataModal.setFunctionName(tbname.getFunctionName());
                tableDataModal.setAuthor(tbname.getAuthor()==null?genConfig.getAuthor():tbname.getAuthor());//配置优先
                tableDataModal.setTime(tbname.getTime()==null? ParseUtil.parseDate(new Date(),"yyyy-MM-dd"):tbname.getTime());
                tableDataModal.setVersion(tbname.getVersion()==null?genConfig.getVersion():tbname.getVersion());

                param.put("tableName",tbname.getTable().getTableName());
                String sql = SqlManger.replaceVar(sqlManger.ALL_COULMN_INFO_SQL,param);//读取sql
                DruidPooledPreparedStatement ps = (DruidPooledPreparedStatement)connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String tableName=rs.getString("tableName");
                    String columnName=rs.getString("columnName");
                    String dataType=rs.getString("dataType");
                    String columnComment=rs.getString("columnComment");
                    String schemaName=rs.getString("schemaName");
                    System.out.println(tableName+"-"+columnName+"-"+dataType+"-"+columnComment+"-"+schemaName);
                 }
                tableDataModals.add(tableDataModal);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tableDataModals;
    }

    public GenConfig getGenConfig() {
        return genConfig;
    }

    public void setGenConfig(GenConfig genConfig) {
        this.genConfig = genConfig;
    }

    public DbManger getDbManger() {
        return dbManger;
    }

    public void setDbManger(DbManger dbManger) {
        this.dbManger = dbManger;
    }

    public List<TableDataModal> getTableDataModalList() {
        return tableDataModalList;
    }

    public void setTableDataModalList(List<TableDataModal> tableDataModalList) {
        this.tableDataModalList = tableDataModalList;
    }
}