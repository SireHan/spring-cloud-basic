package com.squirrel.springcloud.provider.gen.config;

import com.squirrel.springcloud.provider.gen.entity.Table;

/**
 * 数据modal
 * @Author: JoinHan
 * @Date: Created in 12:38 2018/2/2
 * @Modified By：
 */
public class TableDataModal {
    //----------------------------- 代码生成 属性 --------------------------
    private String functionName;// 功能名
    private String author; //作者
    private String time; //时间
    private String version;// 版本
    private String className;//类名

    //----------------------------- 代码生成 位置属性 --------------------------
    private String mapperLocation;//mapper 位置
    private String daoLocation;//dao 位置
    private String daoPackage;//dao 包位置
    private String entityLocation;//entity 位置
    private String entityPackage;//entity 包位置

    //代码生成分类 增删改查（单表）或 仅持久层
    private String category;

    private Table table = new Table();//表信息

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMapperLocation() {
        return mapperLocation;
    }

    public void setMapperLocation(String mapperLocation) {
        this.mapperLocation = mapperLocation;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDaoLocation() {
        return daoLocation;
    }

    public void setDaoLocation(String daoLocation) {
        this.daoLocation = daoLocation;
    }

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getEntityLocation() {
        return entityLocation;
    }

    public void setEntityLocation(String entityLocation) {
        this.entityLocation = entityLocation;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }
}
