package com.squirrel.springcloud.provider.gen.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @Author: JoinHan
 * @Date: Created in 18:01 2018/2/1
 * @Modified By：
 */
@XmlRootElement(name="showType")
public class ShowType {
    private List<Field> fieldList;

    @XmlElement(name = "field")
    public List<Field> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }
}
