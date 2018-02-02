/**
 *  该类有generator 自动生成
 * Copyright &copy; 2017-2018 All rights reserved.
 */
package com.squirrel.springcloud.squirrel.gen.web.entity;

import com.squirrel.springcloud.squirrel.common.base.BaseEntity;

/**
 * 代码生成genTable表Entity
 * @author JoinHan
 * @version 2017-09-05
 */
public class GenTable extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Long id;		// 唯一标识符
	private String name;		// 表名
	private String comments;		// 描述
	private String className;		// 实体类名
	private Long parentTable;		// 关联父表
	private Long parentTableFk;		// 关联父表字段

	public GenTable() {
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Long getParentTable() {
		return parentTable;
	}

	public void setParentTable(Long parentTable) {
		this.parentTable = parentTable;
	}

	public Long getParentTableFk() {
		return parentTableFk;
	}

	public void setParentTableFk(Long parentTableFk) {
		this.parentTableFk = parentTableFk;
	}

}