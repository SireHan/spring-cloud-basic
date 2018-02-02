package com.squirrel.springcloud.squirrel.gen.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by JoinHan on 2017/7/13.
 */
@XmlRootElement(name="categories")
public class Categories {
    private List<Category> categoryList;

    @XmlElement(name = "category")
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
