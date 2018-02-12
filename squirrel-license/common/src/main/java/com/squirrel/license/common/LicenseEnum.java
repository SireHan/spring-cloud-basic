package com.squirrel.license.common;

/**
 * @Author: JoinHan
 * @Date: Created in 12:56 2018/2/12
 * @Modified By：
 */
public enum LicenseEnum {

    StandAlone(1,"单机版授权");

    LicenseEnum(Integer id,String description) {
        this.description = description;
        this.id = id;
    }

    private String description;
    private Integer id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
