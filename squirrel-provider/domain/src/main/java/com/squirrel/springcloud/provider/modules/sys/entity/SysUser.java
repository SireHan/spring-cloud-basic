/**
 *  该类有generator 自动生成
 * Copyright &copy; 2017-2018 All rights reserved.
 */
package com.squirrel.springcloud.provider.modules.sys.entity;


import com.squirrel.springcloud.provider.common.base.BaseEntity;

import java.util.Date;

/**
 * 系统登录用户Entity
 * @author JoinHan
 * @version 2017-09-06
 */
public class SysUser extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long id;		// 登录者系统唯一标识符
	private Long areaId;		// 地区id
	private Long officeId;		// 机构id
	private Long departId;		// 部门id
	private String lnm;		// 登录名
	private String pw;		// 登录密码
	private String nm;		// 真实姓名
	private String sex;     //性别
	private Integer status;		// 状态
	private String tel;		// 电话
	private Long noId;		// 员工id
	private Integer type;		// 登录类型
	private String photoHead;		// 登录者头像
	private String loginIp;		// 最后登录ip
	private Date loginDate;		// 最后登录时间
	private String job;		// 职务

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", officeId=" + officeId
				+ ", departId=" + departId + ", lnm=" + lnm
				+ ", pw=" + pw + ", nm=" + nm + ", status=" + status + ", tel="
				+ tel + ", noId=" + noId + ", type=" + type + ", photoHead="
				+ photoHead + ", loginIp=" + loginIp + ", loginDate="
				+ loginDate + "]";
	}


	public SysUser() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	public Long getDepartId() {
		return departId;
	}

	public void setDepartId(Long departId) {
		this.departId = departId;
	}

	public String getLnm() {
		return lnm;
	}

	public void setLnm(String lnm) {
		this.lnm = lnm;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getNoId() {
		return noId;
	}

	public void setNoId(Long noId) {
		this.noId = noId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPhotoHead() {
		return photoHead;
	}

	public void setPhotoHead(String photoHead) {
		this.photoHead = photoHead;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}