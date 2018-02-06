package com.squirrel.springcloud.provider.gen.entity.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @Author: JoinHan
 * @Date: Created in 17:30 2018/2/1
 * @Modified By：
 */
@XmlRootElement(name="dbFieldType")
public class DbFieldType {
    private List<DbType> dbTypeList;

    @XmlElement(name = "dbType")
    public List<DbType> getDbTypeList() {
        return dbTypeList;
    }

    public void setDbTypeList(List<DbType> dbTypeList) {
        this.dbTypeList = dbTypeList;
    }
}
