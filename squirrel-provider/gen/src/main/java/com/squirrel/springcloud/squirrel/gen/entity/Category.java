package com.squirrel.springcloud.squirrel.gen.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by JoinHan on 2017/7/13.
 */
@XmlRootElement(name="category")
public class Category extends Field {
    private List<String> templateList;//模板列表

    @XmlElement(name = "template")
    public List<String> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<String> templateList) {
        this.templateList = templateList;
    }
}