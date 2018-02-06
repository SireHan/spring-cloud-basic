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
}
