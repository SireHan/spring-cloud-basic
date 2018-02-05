/**
 *  该类有generator 自动生成
 * Copyright &copy; 2017-2018 All rights reserved.
 */
package com.squirrel.springcloud.provider.gen.web.service.impl;

import com.squirrel.springcloud.provider.gen.web.webconfig.base.ServiceImplExtend;
import com.squirrel.springcloud.provider.gen.web.dao.GenTableMapper;
import com.squirrel.springcloud.provider.gen.web.entity.GenTable;
import com.squirrel.springcloud.provider.gen.web.entity.GenTableExample;
import com.squirrel.springcloud.provider.gen.web.service.GenTableService;
import org.springframework.stereotype.Service;

/**
 * 代码生成genTable表ServiceImpl
 * @author JoinHan
 * @version 2017-09-05
 */
 @Service(value = "genTableService" )
public class GenTableServiceImpl extends ServiceImplExtend<GenTableMapper,GenTable,GenTableExample> implements GenTableService {

	@Override
	public GenTableExample getExampleFromEntity(GenTable genTable) {
		GenTableExample example = new GenTableExample();
		GenTableExample.Criteria ca = example.or();
		if(genTable.getId()!=null){
			ca.andIdEqualTo(genTable.getId());
		}
		if(genTable.getName()!=null
				&&!"".equals(genTable.getName())){
			ca.andNameLike("%"+genTable.getName()+"%");
		}
		if(genTable.getComments()!=null
				&&!"".equals(genTable.getComments())){
			ca.andCommentsLike("%"+genTable.getComments()+"%");
		}
		if(genTable.getClassName()!=null
				&&!"".equals(genTable.getClassName())){
			ca.andClassNameLike("%"+genTable.getClassName()+"%");
		}
		if(genTable.getParentTable()!=null){
			ca.andParentTableEqualTo(genTable.getParentTable());
		}
		if(genTable.getParentTableFk()!=null){
			ca.andParentTableFkEqualTo(genTable.getParentTableFk());
		}
		if(genTable.getCreateBy()!=null){
			ca.andCreateByEqualTo(genTable.getCreateBy());
		}
		if(genTable.getCreateDate()!=null){
			ca.andCreateDateBetween(genTable.getBeginCreateDate(),genTable.getEndCreateDate());
		}
		if(genTable.getUpdateBy()!=null){
			ca.andUpdateByEqualTo(genTable.getUpdateBy());
		}
		if(genTable.getUpdateDate()!=null){
			ca.andUpdateDateBetween(genTable.getBeginUpdateDate(),genTable.getEndUpdateDate());
		}
		if(genTable.getRemarks()!=null
				&&!"".equals(genTable.getRemarks())){
			ca.andRemarksLike("%"+genTable.getRemarks()+"%");
		}
		if(genTable.getDelFlag()!=null
				&&!"".equals(genTable.getDelFlag())){
			ca.andDelFlagEqualTo(genTable.getDelFlag());
		}
		return example;	}
}