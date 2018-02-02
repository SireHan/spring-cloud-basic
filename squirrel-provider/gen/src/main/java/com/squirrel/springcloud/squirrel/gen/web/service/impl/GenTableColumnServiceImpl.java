/**
 *  该类有generator 自动生成
 * Copyright &copy; 2017-2018 All rights reserved.
 */
package com.squirrel.springcloud.squirrel.gen.web.service.impl;

import com.squirrel.springcloud.squirrel.gen.web.webconfig.base.ServiceImplExtend;
import com.squirrel.springcloud.squirrel.gen.web.dao.GenTableColumnMapper;
import com.squirrel.springcloud.squirrel.gen.web.entity.GenTableColumn;
import com.squirrel.springcloud.squirrel.gen.web.entity.GenTableColumnExample;
import com.squirrel.springcloud.squirrel.gen.web.service.GenTableColumnService;
import org.springframework.stereotype.Service;

/**
 * 代码生成table column 表ServiceImpl
 * @author JoinHan
 * @version 2017-09-06
 */
 @Service(value = "genTableColumnService" )
public class GenTableColumnServiceImpl extends ServiceImplExtend<GenTableColumnMapper,GenTableColumn,GenTableColumnExample> implements GenTableColumnService {

	@Override
	public GenTableColumnExample getExampleFromEntity(GenTableColumn genTableColumn) {
		GenTableColumnExample example = new GenTableColumnExample();
		GenTableColumnExample.Criteria ca = example.or();

		if(genTableColumn.getId()!=null){
			ca.andIdEqualTo(genTableColumn.getId());
		}
		if(genTableColumn.getGenTableId()!=null){
			ca.andGenTableIdEqualTo(genTableColumn.getGenTableId());
		}
		if(genTableColumn.getName()!=null
				&&!"".equals(genTableColumn.getName())){
			ca.andNameLike("%"+genTableColumn.getName()+"%");
		}
		if(genTableColumn.getComments()!=null
				&&!"".equals(genTableColumn.getComments())){
			ca.andCommentsLike("%"+genTableColumn.getComments()+"%");
		}
		if(genTableColumn.getJdbcType()!=null
				&&!"".equals(genTableColumn.getJdbcType())){
			ca.andJdbcTypeEqualTo(genTableColumn.getJdbcType());
		}
		if(genTableColumn.getJavaType()!=null
				&&!"".equals(genTableColumn.getJavaType())){
			ca.andJavaTypeEqualTo(genTableColumn.getJavaType());
		}
		if(genTableColumn.getJavaField()!=null
				&&!"".equals(genTableColumn.getJavaField())){
			ca.andJavaFieldLike("%"+genTableColumn.getJavaField()+"%");
		}
		if(genTableColumn.getFeildLength()!=null){
			ca.andFeildLengthEqualTo(genTableColumn.getFeildLength());
		}
		if(genTableColumn.getIsPk()!=null
				&&!"".equals(genTableColumn.getIsPk())){
			ca.andIsPkEqualTo(genTableColumn.getIsPk());
		}
		if(genTableColumn.getIsNull()!=null
				&&!"".equals(genTableColumn.getIsNull())){
			ca.andIsNullEqualTo(genTableColumn.getIsNull());
		}
		if(genTableColumn.getIsInsert()!=null
				&&!"".equals(genTableColumn.getIsInsert())){
			ca.andIsInsertEqualTo(genTableColumn.getIsInsert());
		}
		if(genTableColumn.getIsEdit()!=null
				&&!"".equals(genTableColumn.getIsEdit())){
			ca.andIsEditEqualTo(genTableColumn.getIsEdit());
		}
		if(genTableColumn.getIsList()!=null
				&&!"".equals(genTableColumn.getIsList())){
			ca.andIsListEqualTo(genTableColumn.getIsList());
		}
		if(genTableColumn.getIsQuery()!=null
				&&!"".equals(genTableColumn.getIsQuery())){
			ca.andIsQueryEqualTo(genTableColumn.getIsQuery());
		}
		if(genTableColumn.getIsExport()!=null
				&&!"".equals(genTableColumn.getIsExport())){
			ca.andIsExportEqualTo(genTableColumn.getIsExport());
		}
		if(genTableColumn.getIsImport()!=null
				&&!"".equals(genTableColumn.getIsImport())){
			ca.andIsImportEqualTo(genTableColumn.getIsImport());
		}
		if(genTableColumn.getExportTitle()!=null
				&&!"".equals(genTableColumn.getExportTitle())){
			ca.andExportTitleLike("%"+genTableColumn.getExportTitle()+"%");
		}
		if(genTableColumn.getExportSort()!=null
				&&!"".equals(genTableColumn.getExportSort())){
			ca.andExportSortEqualTo(genTableColumn.getExportSort());
		}
		if(genTableColumn.getQueryType()!=null
				&&!"".equals(genTableColumn.getQueryType())){
			ca.andQueryTypeEqualTo(genTableColumn.getQueryType());
		}
		if(genTableColumn.getShowType()!=null
				&&!"".equals(genTableColumn.getShowType())){
			ca.andShowTypeEqualTo(genTableColumn.getShowType());
		}
		if(genTableColumn.getValidators()!=null
				&&!"".equals(genTableColumn.getValidators())){
			ca.andValidatorsLike("%"+genTableColumn.getValidators()+"%");
		}
		if(genTableColumn.getDictType()!=null
				&&!"".equals(genTableColumn.getDictType())){
			ca.andDictTypeEqualTo(genTableColumn.getDictType());
		}
		if(genTableColumn.getAssociationTableId()!=null){
			ca.andAssociationTableIdEqualTo(genTableColumn.getAssociationTableId());
		}
		if(genTableColumn.getAssociationFieldId()!=null){
			ca.andAssociationFieldIdEqualTo(genTableColumn.getAssociationFieldId());
		}
		if(genTableColumn.getForeignTableField()!=null
				&&!"".equals(genTableColumn.getForeignTableField())){
			ca.andForeignTableFieldLike("%"+genTableColumn.getForeignTableField()+"%");
		}
		if(genTableColumn.getSort()!=null){
			ca.andSortEqualTo(genTableColumn.getSort());
		}
		if(genTableColumn.getCreateBy()!=null){
			ca.andCreateByEqualTo(genTableColumn.getCreateBy());
		}
		if(genTableColumn.getCreateDate()!=null){
			ca.andCreateDateBetween(genTableColumn.getBeginCreateDate(),genTableColumn.getEndCreateDate());
		}
		if(genTableColumn.getUpdateBy()!=null){
			ca.andUpdateByEqualTo(genTableColumn.getUpdateBy());
		}
		if(genTableColumn.getUpdateDate()!=null){
			ca.andUpdateDateBetween(genTableColumn.getBeginUpdateDate(),genTableColumn.getEndUpdateDate());
		}
		if(genTableColumn.getRemarks()!=null
				&&!"".equals(genTableColumn.getRemarks())){
			ca.andRemarksLike("%"+genTableColumn.getRemarks()+"%");
		}
		if(genTableColumn.getDelFlag()!=null
				&&!"".equals(genTableColumn.getDelFlag())){
			ca.andDelFlagEqualTo(genTableColumn.getDelFlag());
		}
		return example;
	}

}