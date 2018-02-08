package com.squirrel.springcloud.provider.gen.entity;

import java.util.List;

/**
 * @Author: JoinHan
 * @Date: Created in 16:20 2018/2/2
 * @Modified By：
 */
public class Table {

    //----------------------------- 数据库 属性-----------------------------
    private String tableName;//表名
    private String schemaName;//所属数据库名称

    private List<TableColumn> tableColumnList;//表字段

    private String allField;//基本查询所有字段
    private String insertField;//插入的所有字段
    private List<TableColumn> insertFieldList;//插入的表字段 由插入字段得来
    private List<TableColumn> updateFieldList;//更新的表字段 默认等于插入表字段

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public List<TableColumn> getTableColumnList() {
        return tableColumnList;
    }

    public void setTableColumnList(List<TableColumn> tableColumnList) {
        this.tableColumnList = tableColumnList;
    }

    public String getAllField() {
        return allField;
    }

    public void setAllField(String allField) {
        this.allField = allField;
    }

    public String getInsertField() {
        return insertField;
    }

    public void setInsertField(String insertField) {
        this.insertField = insertField;
    }

    public List<TableColumn> getInsertFieldList() {
        return insertFieldList;
    }

    public void setInsertFieldList(List<TableColumn> insertFieldList) {
        this.insertFieldList = insertFieldList;
    }

    public List<TableColumn> getUpdateFieldList() {
        return updateFieldList;
    }

    public void setUpdateFieldList(List<TableColumn> updateFieldList) {
        this.updateFieldList = updateFieldList;
    }
}
