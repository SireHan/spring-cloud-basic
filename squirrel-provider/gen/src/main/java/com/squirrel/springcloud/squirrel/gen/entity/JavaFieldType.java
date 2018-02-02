package com.squirrel.springcloud.squirrel.gen.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @Author: JoinHan
 * @Date: Created in 17:38 2018/2/1
 * @Modified By：
 */
@XmlRootElement(name="javaFieldType")
public class JavaFieldType {
    private List<Field> fieldList;

    @XmlElement(name = "field")
    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }
}
