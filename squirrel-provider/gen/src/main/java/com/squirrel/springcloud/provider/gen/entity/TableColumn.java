package com.squirrel.springcloud.provider.gen.entity;

/**
 * 表字段描述类
 * @Author: JoinHan
 * @Date: Created in 17:46 2018/2/6
 * @Modified By：
 */
public class TableColumn {

    //----------------------------- 数据库 属性-----------------------------
    private String columnName;//字段名
    private String schemaName;//所属数据库名称
    private String tableName;//所属表名称
    private String dataType; //数据库类型
    private String columnComment;//字段备注

    private String mybatisType;//mybatis 对应的字段类型
    private String javaType;//java 对应的字段类型
    private String javaColumnName;//java 属性名称

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getMybatisType() {
        return mybatisType;
    }

    public void setMybatisType(String mybatisType) {
        this.mybatisType = mybatisType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJavaColumnName() {
        return javaColumnName;
    }

    public void setJavaColumnName(String javaColumnName) {
        this.javaColumnName = javaColumnName;
    }
}
