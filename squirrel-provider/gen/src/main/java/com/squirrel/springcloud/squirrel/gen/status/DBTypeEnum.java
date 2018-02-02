package com.squirrel.springcloud.squirrel.gen.status;

/**
 * @Author: JoinHan
 * @Date: Created in 17:49 2018/2/2
 * @Modified By：
 */
public enum DBTypeEnum {

    MysqlDB(1,"mysql"),
    OracleDB(2,"oracle");

    private Integer dbTypeId;
    private String dbTypeDescription;

    DBTypeEnum(Integer dbTypeId, String dbTypeDescription) {
        this.dbTypeId = dbTypeId;
        this.dbTypeDescription = dbTypeDescription;
    }

    public Integer getDbTypeId() {
        return dbTypeId;
    }

    public void setDbTypeId(Integer dbTypeId) {
        this.dbTypeId = dbTypeId;
    }

    public String getDbTypeDescription() {
        return dbTypeDescription;
    }

    public void setDbTypeDescription(String dbTypeDescription) {
        this.dbTypeDescription = dbTypeDescription;
    }
}
