package com.squirrel.springcloud.squirrel.gen.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Xml 最基本元素
 * Created by JoinHan on 2017/7/13.
 */
@XmlRootElement(name="field")
public class Field {
    private String value;//类型值
    private String label;//类型中文名称
    private String description;//类型描述

    @XmlElement(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlElement(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
