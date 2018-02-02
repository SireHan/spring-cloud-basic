package com.squirrel.springcloud.squirrel.gen.status;

/**
 * @Author: JoinHan
 * @Date: Created in 17:49 2018/2/2
 * @Modified By：
 */
public enum GenTypeEnum {

    DBTableAssign(1,"指定数据库中的表"),
    WebConfigAssign(2,"从web配置中生成");

    private Integer genTypeId;
    private String genTypeDescription;

    GenTypeEnum(Integer genTypeId, String genTypeDescription) {
        this.genTypeId = genTypeId;
        this.genTypeDescription = genTypeDescription;
    }

    public Integer getGenTypeId() {
        return genTypeId;
    }

    public void setGenTypeId(Integer genTypeId) {
        this.genTypeId = genTypeId;
    }

    public String getGenTypeDescription() {
        return genTypeDescription;
    }

    public void setGenTypeDescription(String genTypeDescription) {
        this.genTypeDescription = genTypeDescription;
    }
}
