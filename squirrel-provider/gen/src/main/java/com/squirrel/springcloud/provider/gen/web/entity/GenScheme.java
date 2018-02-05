/**
 *  该类有generator 自动生成
 * Copyright &copy; 2017-2018 All rights reserved.
 */
package com.squirrel.springcloud.provider.gen.web.entity;

import com.squirrel.springcloud.provider.common.base.BaseEntity;

/**
 * 代码生成方案表Entity
 * @author JoinHan
 * @version 2017-09-06
 */
public class GenScheme extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Long id;		// 唯一标识符
	private String name;		// 名称
	private String category;		// 分类
	private String packageName;		// 生成包路径
	private String moduleName;		// 生成模块名
	private String subModuleName;		// 生成子模块名
	private String functionName;		// 生成功能名
	private String functionNameSimple;		// 生成功能名（简写）
	private String functionAuthor;		// 生成功能作者
	private String functionVersion;		// 生成功能版本
	private Long genTableId;		// 方案所属表
	private String pageTitle;		// 页面标题
	private String pageTitle2;		// 页面小标题
	private String path;		// 页面路径
	private String listName;		// 列表名称

	public GenScheme() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionNameSimple() {
		return functionNameSimple;
	}

	public void setFunctionNameSimple(String functionNameSimple) {
		this.functionNameSimple = functionNameSimple;
	}

	public String getFunctionAuthor() {
		return functionAuthor;
	}

	public void setFunctionAuthor(String functionAuthor) {
		this.functionAuthor = functionAuthor;
	}

	public String getFunctionVersion() {
		return functionVersion;
	}

	public void setFunctionVersion(String functionVersion) {
		this.functionVersion = functionVersion;
	}

	public Long getGenTableId() {
		return genTableId;
	}

	public void setGenTableId(Long genTableId) {
		this.genTableId = genTableId;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageTitle2() {
		return pageTitle2;
	}

	public void setPageTitle2(String pageTitle2) {
		this.pageTitle2 = pageTitle2;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

}