/**
 *  该类有generator 自动生成
 * Copyright &copy; 2017-2018 All rights reserved.
 */
package com.squirrel.springcloud.squirrel.modules.sys.service.impl;

import com.squirrel.springcloud.squirrel.common.annotation.BaseService;
import com.squirrel.springcloud.squirrel.common.base.ServiceImplExtend;
import com.squirrel.springcloud.squirrel.modules.sys.dao.SysUserMapper;
import com.squirrel.springcloud.squirrel.modules.sys.entity.SysUser;
import com.squirrel.springcloud.squirrel.modules.sys.entity.SysUserExample;
import com.squirrel.springcloud.squirrel.modules.sys.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统登录用户ServiceImpl
 * @author JoinHan
 * @version 2017-09-06
 */
@Service
@Transactional
@BaseService
public class SysUserServiceImpl extends ServiceImplExtend<SysUserMapper, SysUser, SysUserExample> implements SysUserService {

 	@Override
	public SysUserExample getExampleFromEntity(SysUser sysUser){
		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria ca = example.or();
		if(sysUser==null){
			return example;
		}
		if(sysUser.getId()!=null){
			ca.andIdEqualTo(sysUser.getId());
		}
		if(sysUser.getAreaId()!=null){
			ca.andAreaIdEqualTo(sysUser.getAreaId());
		}
		if(sysUser.getOfficeId()!=null){
			ca.andOfficeIdEqualTo(sysUser.getOfficeId());
		}
		if(sysUser.getDepartId()!=null){
			ca.andDepartIdEqualTo(sysUser.getDepartId());
		}
		if(StringUtils.isNotBlank(sysUser.getLnm())){
			ca.andLnmLike("%"+sysUser.getLnm()+"%");
		}
		if(StringUtils.isNotBlank(sysUser.getPw())){
			ca.andPwEqualTo(sysUser.getPw());
		}
		if(StringUtils.isNotBlank(sysUser.getNm())){
			ca.andNmLike("%"+sysUser.getNm()+"%");
		}
		if(StringUtils.isNotBlank(sysUser.getSex())){
			ca.andSexEqualTo(sysUser.getSex());
		}
		if(sysUser.getStatus()!=null){
			ca.andStatusEqualTo(sysUser.getStatus());
		}
		if(StringUtils.isNotBlank(sysUser.getTel())){
			ca.andTelLike("%"+sysUser.getTel()+"%");
		}
		if(sysUser.getNoId()!=null){
			ca.andNoIdEqualTo(sysUser.getNoId());
		}
		if(sysUser.getType()!=null){
			ca.andTypeEqualTo(sysUser.getType());
		}
		if(StringUtils.isNotBlank(sysUser.getPhotoHead())){
			ca.andPhotoHeadEqualTo(sysUser.getPhotoHead());
		}
		if(StringUtils.isNotBlank(sysUser.getLoginIp())){
			ca.andLoginIpEqualTo(sysUser.getLoginIp());
		}
		if(sysUser.getLoginDate()!=null){
			ca.andLoginDateEqualTo(sysUser.getLoginDate());
		}
		if(StringUtils.isNotBlank(sysUser.getJob())){
			ca.andJobEqualTo(sysUser.getJob());
		}
		if(sysUser.getCreateBy()!=null){
			ca.andCreateByEqualTo(sysUser.getCreateBy());
		}
		if(sysUser.getCreateDate()!=null){
			ca.andCreateDateEqualTo(sysUser.getCreateDate());
		}
		if(sysUser.getUpdateBy()!=null){
			ca.andUpdateByEqualTo(sysUser.getUpdateBy());
		}
		if(sysUser.getUpdateDate()!=null){
			ca.andUpdateDateBetween(sysUser.getBeginUpdateDate(),sysUser.getEndUpdateDate());
		}
		if(sysUser.getRemarks()!=null
				&&!"".equals(sysUser.getRemarks())){
			ca.andRemarksLike("%"+sysUser.getRemarks()+"%");
		}
		if(sysUser.getDelFlag()!=null
				&&!"".equals(sysUser.getDelFlag())){
			ca.andDelFlagEqualTo(sysUser.getDelFlag());
		}
		return example;
	}
}