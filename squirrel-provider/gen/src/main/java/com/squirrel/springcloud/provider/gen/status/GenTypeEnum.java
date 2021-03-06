package com.squirrel.springcloud.provider.gen.status;

/**
 * @Author: JoinHan
 * @Date: Created in 17:49 2018/2/2
 * @Modified By：
 */
public enum GenTypeEnum {

    DBTableAssign(1,"指定数据库中的表"),//默认值
    DBTableAll(2,"指定数据库中所有表"),
    WebConfigAssign(3,"从web配置中生成");

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
