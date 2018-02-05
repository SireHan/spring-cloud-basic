package com.squirrel.springcloud.provider.gen.config;

import com.squirrel.springcloud.provider.gen.entity.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 从dictionary.xml 读出基本的数据
 * @Author: JoinHan
 * @Date: Created in 20:46 2018/1/31
 * @Modified By：
 */
@XmlRootElement(name="config")
public class GenDictionary {

    private Categories categories;//生成分类

    private DbFieldType dbFieldType;//数据库字段类型

    private JavaFieldType javaFieldType;//java 字段类型

    private SelectType selectType;//查询方式

    private ShowTypeStyle showTypeStyle;//页面展示方式

    private ShowType showType;//展示类型

    @XmlElement(name = "dbFieldType")
    public DbFieldType getDbFieldType() {
        return dbFieldType;
    }

    public void setDbFieldType(DbFieldType dbFieldType) {
        this.dbFieldType = dbFieldType;
    }

    @XmlElement(name = "javaFieldType")
    public JavaFieldType getJavaFieldType() {
        return javaFieldType;
    }

    public void setJavaFieldType(JavaFieldType javaFieldType) {
        this.javaFieldType = javaFieldType;
    }

    @XmlElement(name = "selectType")
    public SelectType getSelectType() {
        return selectType;
    }

    public void setSelectType(SelectType selectType) {
        this.selectType = selectType;
    }

    @XmlElement(name = "showTypeStyle")
    public ShowTypeStyle getShowTypeStyle() {
        return showTypeStyle;
    }

    public void setShowTypeStyle(ShowTypeStyle showTypeStyle) {
        this.showTypeStyle = showTypeStyle;
    }

    @XmlElement(name = "showType")
    public ShowType getShowType() {
        return showType;
    }

    public void setShowType(ShowType showType) {
        this.showType = showType;
    }

    @XmlElement(name = "categories")
    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
