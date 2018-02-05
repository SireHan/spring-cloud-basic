/**
 *  该类有generator 自动生成
 * Copyright &copy; 2017-2018 All rights reserved.
 */
package com.squirrel.springcloud.provider.gen.web.entity;


import com.squirrel.springcloud.provider.common.base.BaseEntity;

/**
 * 代码生成table column 表Entity
 * @author JoinHan
 * @version 2017-09-06
 */
public class GenTableColumn extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Long id;		// 唯一标识符
	private Long genTableId;		// table id
	private String name;		// 名称
	private String comments;		// 描述
	private String jdbcType;		// 数据库类型
	private String javaType;		// Java 类型
	private String javaField;		// Java字段名
	private Integer feildLength;		// 字段长度
	private String isPk;		// 是否是主键
	private String isNull;		// 是否为空
	private String isInsert;		// 是否为新增字段
	private String isEdit;		// 是否为编辑字段
	private String isList;		// 是否列表字段
	private String isQuery;		// 是否查询字段
	private String isExport;		// 是否导出字段
	private String isImport;		// 是否导入字段
	private String exportTitle;		// 导出标题
	private String exportSort;		// 导出排序
	private String queryType;		// 查询方式
	private String showType;		// 展示方式
	private String validators;		// 验证方式
	private String dictType;		// 数据字典类型
	private Long associationTableId;		// 关联表id
	private Long associationFieldId;		// 关联字段id
	private String foreignTableField;		// 外键
	private Integer sort;		// 字段排序

	public GenTableColumn() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGenTableId() {
		return genTableId;
	}

	public void setGenTableId(Long genTableId) {
		this.genTableId = genTableId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaField() {
		return javaField;
	}

	public void setJavaField(String javaField) {
		this.javaField = javaField;
	}

	public Integer getFeildLength() {
		return feildLength;
	}

	public void setFeildLength(Integer feildLength) {
		this.feildLength = feildLength;
	}

	public String getIsPk() {
		return isPk;
	}

	public void setIsPk(String isPk) {
		this.isPk = isPk;
	}

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public String getIsInsert() {
		return isInsert;
	}

	public void setIsInsert(String isInsert) {
		this.isInsert = isInsert;
	}

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public String getIsList() {
		return isList;
	}

	public void setIsList(String isList) {
		this.isList = isList;
	}

	public String getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}

	public String getIsExport() {
		return isExport;
	}

	public void setIsExport(String isExport) {
		this.isExport = isExport;
	}

	public String getIsImport() {
		return isImport;
	}

	public void setIsImport(String isImport) {
		this.isImport = isImport;
	}

	public String getExportTitle() {
		return exportTitle;
	}

	public void setExportTitle(String exportTitle) {
		this.exportTitle = exportTitle;
	}

	public String getExportSort() {
		return exportSort;
	}

	public void setExportSort(String exportSort) {
		this.exportSort = exportSort;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getValidators() {
		return validators;
	}

	public void setValidators(String validators) {
		this.validators = validators;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public Long getAssociationTableId() {
		return associationTableId;
	}

	public void setAssociationTableId(Long associationTableId) {
		this.associationTableId = associationTableId;
	}

	public Long getAssociationFieldId() {
		return associationFieldId;
	}

	public void setAssociationFieldId(Long associationFieldId) {
		this.associationFieldId = associationFieldId;
	}

	public String getForeignTableField() {
		return foreignTableField;
	}

	public void setForeignTableField(String foreignTableField) {
		this.foreignTableField = foreignTableField;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}