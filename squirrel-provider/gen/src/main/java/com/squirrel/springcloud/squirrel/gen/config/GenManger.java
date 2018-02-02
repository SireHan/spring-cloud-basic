package com.squirrel.springcloud.squirrel.gen.config;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.druid.pool.DruidPooledPreparedStatement;
import com.alibaba.druid.pool.DruidPooledResultSet;
import com.alibaba.druid.pool.DruidPooledStatement;
import com.squirrel.springcloud.squirrel.gen.status.DBTypeEnum;
import com.squirrel.springcloud.squirrel.gen.status.GenTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * 代码生成Manager
 * @author JoinHan
 * @version 2017-09-06
 */
public class GenManger{

    private static Logger logger = LoggerFactory.getLogger(GenManger.class);

    private GenConfig genConfig = null;
    private DbManger dbManger = null;//数据库连接管理
    private List<TableDataModal> tableDataModalList = null;//代码生成的数据来源

    public GenManger(GenConfig genConfig) {
        if(genConfig == null){
            //初始化基础配置
            this.genConfig = new GenConfig();
        }else{
            this.genConfig  = genConfig;
        }
        //根据配置数据连接
        this.dbManger = DbManger.initDb(this.genConfig.getProperties());
    }

    public static void main(String[] args) {
        //第一种支持 mysql数据库
        GenConfig genConfig = new GenConfig();
        genConfig.addTable("sys_user");
        GenManger genManger = new GenManger(null);
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
            //获取数据库连接 查询表信息
            try(DruidPooledConnection connection = dbManger.getConnection()){
                DruidPooledStatement stmtNew = (DruidPooledStatement) connection.createStatement();
                String sql = selectTableInfosByDBType(dbManger.dbTypeEnum);
                DruidPooledPreparedStatement ps = (DruidPooledPreparedStatement)connection.prepareStatement(sql);
                ps.setString(1,"gg");
                DruidPooledResultSet rs = null;
                int j = ps.executeUpdate();
                while(j > 0){
                    System.out.println("bb");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据不同的数据库 查询数据库中表信息
     * @param dbTypeEnum
     * @return
     */
    private String selectTableInfosByDBType(DBTypeEnum dbTypeEnum) {
        if(dbTypeEnum==DBTypeEnum.MysqlDB){

        }
        return null;
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