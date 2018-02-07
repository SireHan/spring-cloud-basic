package com.squirrel.springcloud.provider.gen.config;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.druid.pool.DruidPooledPreparedStatement;
import com.alibaba.druid.pool.DruidPooledStatement;
import com.squirrel.springcloud.provider.common.util.ObjectUtils;
import com.squirrel.springcloud.provider.common.util.ParseUtil;
import com.squirrel.springcloud.provider.common.util.StringUtils;
import com.squirrel.springcloud.provider.common.util.XmlUtil;
import com.squirrel.springcloud.provider.gen.entity.TableColumn;
import com.squirrel.springcloud.provider.gen.entity.xml.Category;
import com.squirrel.springcloud.provider.gen.entity.xml.Template;
import com.squirrel.springcloud.provider.gen.status.GenTypeEnum;
import com.squirrel.springcloud.provider.gen.util.TemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
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
        tableDataModal.setCategory("curd");
        tableDataModal.getTable().setTableName("sys_user");
        tableDataModal.setClassName("SysUser");

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
            //读取模板配置
            for(TableDataModal tdm:tableDataModalList){
                List<Category> categories = genConfig.getDictionary().getCategories().getCategoryList();
                for(Category category:categories){
                    if(category.getValue().equals(tdm.getCategory())){//配置的分类在系统字典中
                        for(String template:category.getTemplateList()){
                                //读取模板
                                Template tpl = (Template) XmlUtil.xmlToObject(template, Template.class);
                                try {
                                    Map<String,Object> modal = new HashMap<>();
                                    //对象转成mapper
                                    ObjectUtils.objectToMap(tdm,true,modal);
                                    TemplateUtil.generateToFile(tpl,modal,true);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                        }
                    }
                }
            }
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

                //自定义 属性
                //必填
                tableDataModal.setCategory(tbname.getCategory());
                tableDataModal.setClassName(tbname.getClassName());
                //非必填
                tableDataModal.setFunctionName(tbname.getFunctionName());

                //配置优先
                tableDataModal.setAuthor(tbname.getAuthor()==null?genConfig.getAuthor():tbname.getAuthor());
                tableDataModal.setTime(tbname.getTime()==null? ParseUtil.parseDate(new Date(),"yyyy-MM-dd"):tbname.getTime());
                tableDataModal.setVersion(tbname.getVersion()==null?genConfig.getVersion():tbname.getVersion());
                //默认文件位置
                tableDataModal.setMapperLocation(tbname.getMapperLocation()==null?genConfig.getLocation()
                                + StringUtils.replaceEach("/dao/src/main/resources/mappings/",new String[]{"//", "/", "."}, new String[]{File.separator, File.separator, File.separator})
                                + genConfig.getModuleName():tbname.getMapperLocation());

                tableDataModal.setDaoLocation(tbname.getDaoLocation()==null?genConfig.getLocation()
                        + StringUtils.replaceEach("/dao/src/main/java"+genConfig.getBasicPackage().replace(".",File.separator)+File.separator
                            +genConfig.getModuleName()+"/dao",new String[]{"//", "/", "."}, new String[]{File.separator, File.separator, File.separator}):tbname.getDaoLocation());
                tableDataModal.setDaoPackage(tbname.getDaoPackage()==null?genConfig.getBasicPackage()+"."+genConfig.getModuleName()+".dao":tbname.getDaoPackage());

                tableDataModal.setEntityLocation(tbname.getEntityLocation()==null?genConfig.getLocation()
                        + StringUtils.replaceEach("/dao/src/main/java"+genConfig.getBasicPackage().replace(".",File.separator)+File.separator
                        +genConfig.getModuleName()+"/entity",new String[]{"//", "/", "."}, new String[]{File.separator, File.separator, File.separator}):tbname.getEntityLocation());
                tableDataModal.setEntityPackage(tbname.getEntityPackage()==null?genConfig.getBasicPackage()+"."+genConfig.getModuleName()+".entity":tbname.getEntityPackage());




                param.put("tableName",tbname.getTable().getTableName());
                String sql = SqlManger.replaceVar(sqlManger.ALL_COULMN_INFO_SQL,param);//读取sql
                DruidPooledPreparedStatement ps = (DruidPooledPreparedStatement)connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    List<TableColumn> tableColumnList = tableDataModal.getTable().getTableColumnList();
                    if(tableColumnList==null){
                        tableColumnList = new ArrayList<>();
                        tableDataModal.getTable().setTableName(rs.getString("tableName"));
                        tableDataModal.getTable().setSchemaName(rs.getString("schemaName"));
                    }
                    TableColumn tableColumn = new TableColumn();
                    tableColumn.setColumnComment(rs.getString("columnComment"));
                    tableColumn.setColumnName(rs.getString("columnName"));
                    tableColumn.setDataType(rs.getString("dataType"));
                    tableColumn.setTableName(rs.getString("tableName"));
                    tableColumn.setSchemaName(rs.getString("schemaName"));
                    exchangeProperty(tableColumn,dbManger, genConfig);
                    tableColumnList.add(tableColumn);
                    tableDataModal.getTable().setTableColumnList(tableColumnList);
                 }
                tableDataModals.add(tableDataModal);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tableDataModals;
    }

    /**
     * 对数据库查询出来的字段信息进行处理
     * @param tableColumn
     * @param dbManger
     * @param genConfig
     */
    private void exchangeProperty(TableColumn tableColumn, DbManger dbManger, GenConfig genConfig) {
        //TODO mybatis 对应的字段类型       java 对应的字段类型   java 属性名称
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