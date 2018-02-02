package com.squirrel.springcloud.squirrel.common.base;

import java.io.Serializable;
import java.util.Date;


/**
 * Entity支持类
 * Created by JoinHan on 2017/4/17.
 */
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 删除标记（0：正常；1：删除；2：审核；）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";
	
	public static final Boolean  YES = true;
	public static final Boolean  NO = false;

	protected String remarks; // 备注
    protected Long createBy; // 创建者
    protected Date createDate;// 创建日期
    protected Long updateBy; // 更新者
    protected Date updateDate;// 更新日期
    protected String delFlag; // 删除标记

    protected Date beginCreateDate;
    protected Date endCreateDate;
    protected Date beginUpdateDate;
    protected Date endUpdateDate;

    public BaseEntity() {
        super();
        this.delFlag = DEL_FLAG_NORMAL;
    }
    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public Date getBeginCreateDate() {
        return beginCreateDate;
    }

    public void setBeginCreateDate(Date beginCreateDate) {
        this.beginCreateDate = beginCreateDate;
    }

    public Date getEndCreateDate() {
        return endCreateDate;
    }

    public void setEndCreateDate(Date endCreateDate) {
        this.endCreateDate = endCreateDate;
    }

    public Date getBeginUpdateDate() {
        return beginUpdateDate;
    }

    public void setBeginUpdateDate(Date beginUpdateDate) {
        this.beginUpdateDate = beginUpdateDate;
    }

    public Date getEndUpdateDate() {
        return endUpdateDate;
    }

    public void setEndUpdateDate(Date endUpdateDate) {
        this.endUpdateDate = endUpdateDate;
    }
}
