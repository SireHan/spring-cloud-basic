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
}
