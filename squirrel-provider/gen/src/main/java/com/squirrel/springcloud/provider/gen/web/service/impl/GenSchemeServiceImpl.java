/**
 *  该类有generator 自动生成
 * Copyright &copy; 2017-2018 All rights reserved.
 */
package com.squirrel.springcloud.provider.gen.web.service.impl;

import com.squirrel.springcloud.provider.gen.web.webconfig.base.ServiceImplExtend;
import com.squirrel.springcloud.provider.gen.web.dao.GenSchemeMapper;
import com.squirrel.springcloud.provider.gen.web.entity.GenScheme;
import com.squirrel.springcloud.provider.gen.web.entity.GenSchemeExample;
import com.squirrel.springcloud.provider.gen.web.service.GenSchemeService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 代码生成方案表ServiceImpl
 * @author JoinHan
 * @version 2017-09-06
 */
 @Service(value = "genSchemeService" )
public class GenSchemeServiceImpl extends ServiceImplExtend<GenSchemeMapper, GenScheme, GenSchemeExample> implements GenSchemeService {

	@Override
	public boolean codeMake(Long id) {

		/*try{
			//读取xml 模板配置
			Config config = XmlUtil.fileToObject("config.xml", Config.class);

			Map<String, Object> model = getTableData(id,null);
			if(model!=null){
				//遍历模板分类
				for(Category category:config.getCategories().getCategoryList()){
					if(model.get("category").equals(category.getValue())){
						if("curd_many".equals(model.get("category"))){//主子表
							//如果是一对多表 字表同样生成entity entityExample mapper mapper.xml
							boolean isChild = true;
							for(int i=0;i<2;i++){
								if(i==1){
									Map<String, Object> newModel = getTableData(null, ParseUtil.getLong(model.get("parentTableId")+""));
									//把子表数据添加到主表中
									newModel.put("childModel",model);
									model =  newModel;
									isChild=false;
								}
								for(String template:category.getTemplateList()){
									if(!isChild||(template.contains("mapper.xml")||template.contains("entity.xml")||template.contains("entityExample.xml")||template.contains("dao.xml"))){
										//读取模板
										Template tpl = XmlUtil.fileToObject(template, Template.class);
										try {
											XmlUtil.generateToFile(tpl,model,true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}
							}
						}else if("treeTableAndList".equals(model.get("category"))){//左树右表
							//先树 后表 树同样生成entity entityExample mapper mapper.xml
							boolean isTree = true;
							for(int i=0;i<2;i++){
								if(i==1){
									Map<String, Object> newModel = getTableData(null, ParseUtil.getLong(model.get("parentTableId")+""));
									//把子表数据添加到主表中
									newModel.put("treeModel",model);
									newModel.put("subModuleName",model.get("subModuleName"));
									newModel.put("category",model.get("category"));
									newModel.put("packageName",model.get("packageName"));
									newModel.put("moduleName",model.get("moduleName"));
									newModel.put("subModuleName",model.get("subModuleName"));

									newModel.put("functionName",model.get("functionName"));
									newModel.put("functionAuthor",model.get("functionAuthor"));
									newModel.put("functionVersion",model.get("functionVersion"));
									newModel.put("pageTitle",model.get("pageTitle"));
									newModel.put("pageTitle2",model.get("pageTitle2"));
									newModel.put("pathList",model.get("pathList"));
									newModel.put("listName",model.get("listName"));

									model =  newModel;
									isTree=false;
								}
								for(String template:category.getTemplateList()){
									if(!isTree||(template.contains("mapper.xml")||template.contains("entity.xml")||template.contains("entityExample.xml")||template.contains("dao.xml"))){
										//读取模板
										Template tpl = XmlUtil.fileToObject(template, Template.class);
										try {
											XmlUtil.generateToFile(tpl,model,true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}
							}
						}else{
							for(String template:category.getTemplateList()){
								//读取模板
								Template tpl = XmlUtil.fileToObject(template, Template.class);
								try {
									XmlUtil.generateToFile(tpl,model,true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}*/

		return true;
	}

	public Map<String,Object> getTableData(Long genSchemeId,Long tableId){
		/*Map map = null;
		try {
			// 要执行的SQL语句
			StringBuffer sql = new StringBuffer("select gt.id tableid," +
					"gt.name tablename," +
					"gt.comments tablecomments," +
					"gt.class_name tableclassname," +
					"gtt.name parenttablename," +
					"gt.parent_table parenttableid," +
					"gt.parent_table_fk parenttablefk," +
					"gtc.id cid," +
					"gtc.name cname," +
					"gtc.comments ccomments," +
					"gtc.java_field cjavafiled," +
					"gtc.java_type cjavatype," +
					"gtc.jdbc_type cjdbctype," +
					"gtc.is_insert cinsert," +
					"gtc.is_export cexport," +
					"gtc.is_import cimport," +
					"gtc.is_query cisquery," +
					"gtc.is_list cislist," +
					"gtc.query_type cquery," +
					"gtc.show_type cshowtype," +
					"gtc.dict_type cdicttype," +
					"gtc.export_title ctitle,"+
					"gtc.validators cvalidators,"+
					"gtc.export_sort csort,"+
					"gtc.sort sort,"+
					"gtc.association_table_id ctableid,"+
					"gtc.association_field_id cfieldid,"+
					"gtc.foreign_table_field cforeigntablefield,"+
					"gs.category scategory,"+
					"gs.package_name sname,"+
					"gs.module_name smname,"+
					"gs.sub_module_name ssname,"+
					"gs.function_author sfauthor,"+
					"gs.function_name sfname,"+
					"gs.page_title stitle,"+
					"gs.page_title_2 stitle2,"+
					"gs.path spath,"+
					"gs.list_name slname,"+
					"gs.function_version sfversion"+
					" from gen_table gt " +
					" left join gen_table_column gtc on gt.id = gtc.gen_table_id" +
					" left join gen_scheme gs on gs.gen_table_id = gt.id" +
					" left join gen_table gtt on gtt.id = gt.parent_table");
					if(genSchemeId!=null){
						sql.append(" where gs.id = " +genSchemeId);
					}else{
						sql.append(" where gt.id = " +tableId);
					}
					sql.append(" order by gt.id asc, gtc.sort");

			// 结果集
			List<Map> rsList = sqlMapper.superManagerSelect(sql.toString());
			Map rs =null;
			Table table = null;
			List<TableColumn> tableColumns = new ArrayList<>();
			List<TableColumn> insertFieldList = new ArrayList<>();
			StringBuffer columnField = new StringBuffer();
			StringBuffer insertField = new StringBuffer();
			int listNum = 1;
			for(int i=0;i<rsList.size();i++){
				rs = rsList.get(i);
				// table
				if(table==null){
					table = new Table();
					table.setId(ParseUtil.getLong(rs.get("tableid").toString()));
					table.setName((String)rs.get("tablename"));
					table.setComments((String)rs.get("tablecomments"));
					table.setClassName((String)rs.get("tableclassname"));
					table.setParentTable((String)rs.get("parenttablename"));
					table.setParentTableId(ParseUtil.getLong((String)rs.get("parenttableid")));
					table.setParentTableFk((String)rs.get("parenttablefk"));
				}
				TableColumn tc = new TableColumn();
				tc.setId(ParseUtil.getLong(rs.get("cid").toString()));
				tc.setName((String)rs.get("cname"));
				tc.setComments((String)rs.get("ccomments"));
				tc.setJavaField((String)rs.get("cjavafiled"));
				tc.setJavaType((String)rs.get("cjavatype"));
				tc.setJdbcType((String)rs.get("cjdbctype"));
				tc.setForeignTableField((String)rs.get("cforeigntablefield"));
				columnField.append(tc.getName()+",");
				tc.setIsExport((String)rs.get("cexport"));
				tc.setIsImport((String)rs.get("cimport"));
				tc.setIsQuery((String)rs.get("cisquery"));
				tc.setIsList((String)rs.get("cislist"));
				if("1".equals(tc.getIsList())){
					listNum++;
				}
				tc.setTable(table);
				tc.setExportTitle((String)rs.get("ctitle"));
				tc.setShowType((String)rs.get("cshowtype"));
				tc.setDictType((String)rs.get("cdicttype"));
				tc.setExportSort((String)rs.get("csort"));
				tc.setQueryType((String)rs.get("cquery"));
				tc.setSort(ParseUtil.getInt(rs.get("sort").toString()));
				tc.setAssociationFieldId(ParseUtil.getLong(rs.get("cfieldid")+""));
				tc.setAssociationTableId(ParseUtil.getLong(rs.get("ctableid")+""));
				tableColumns.add(tc);
				String isInsert = (String)rs.get("cinsert");
				if("1".equals(isInsert)){//是新增字段
					tc.setIsInsert(isInsert);
				}

				String validators = (String)rs.get("cvalidators");
				if(validators!=null && !"".equals(validators)){
					tc.setValidators(Arrays.asList(validators.split(",")));
				}else{
					tc.setValidators(new ArrayList<>());
				}
				insertFieldList.add(tc);
				if(!"id".equals(tc.getName())){//去掉插入id
					insertField.append(tc.getName()+",");
				}
				if(map == null){
					map = new HashMap();
					map.put("category", rs.get("scategory"));
					map.put("packageName", rs.get("sname"));
					map.put("moduleName", rs.get("smname"));
					map.put("table",table);
					map.put("subModuleName", rs.get("ssname") ==null?"":(String)rs.get("ssname"));
					map.put("exportName",table.getComments());
					map.put("functionName", rs.get("sfname"));
					map.put("functionAuthor", rs.get("sfauthor"));
					map.put("functionVersion", rs.get("sfversion"));

					map.put("parentTableId",table.getParentTableId());
					//list 页面特殊设置
					//标题  二级标题  路径List<String> 列表名称
					map.put("pageTitle", rs.get("stitle"));
					map.put("pageTitle2", rs.get("stitle2"));
					map.put("pathList",Arrays.asList((String)rs.get("spath")));
					map.put("listName", rs.get("slname"));
				}
			}
			if(map !=null){
				//共有字段
				TableColumn tc = new TableColumn();
				tc = new TableColumn();
				tc.setName("create_by");tc.setComments("创建者");tc.setJavaField("createBy");tc.setJavaType("Long");tc.setJdbcType("INTEGER");tc.setSort(994);
				insertFieldList.add(tc);tc.setQueryType("=");
				tc = new TableColumn();
				tc.setName("create_date");tc.setComments("创建时间");tc.setJavaField("createDate");tc.setJavaType("Date");tc.setJdbcType("TIMESTAMP");tc.setSort(995);
				insertFieldList.add(tc);tc.setQueryType("between");
				tc = new TableColumn();
				tc.setName("update_by");tc.setComments("修改者");tc.setJavaField("updateBy");tc.setJavaType("Long");tc.setJdbcType("INTEGER");tc.setSort(996);
				insertFieldList.add(tc);tc.setQueryType("=");
				tc = new TableColumn();
				tc.setName("update_date");tc.setComments("修改时间");tc.setJavaField("updateDate");tc.setJavaType("Date");tc.setJdbcType("TIMESTAMP");tc.setSort(997);
				insertFieldList.add(tc);tc.setQueryType("between");
				tc = new TableColumn();
				tc.setName("remarks");tc.setComments("备注信息");tc.setJavaField("remarks");tc.setJavaType("String");tc.setJdbcType("VARCHAR");tc.setSort(998);
				insertFieldList.add(tc);tc.setQueryType("like");
				tc = new TableColumn();
				tc.setName("del_flag");tc.setComments("删除标记");tc.setJavaField("delFlag");tc.setJavaType("String");tc.setJdbcType("CHAR");tc.setSort(999);
				insertFieldList.add(tc);tc.setQueryType("=");
				table.setTableColumns(tableColumns);
				table.setAllTableColumns(insertFieldList);

				map.put("columnField",columnField.toString()+"create_by,create_date,update_by,update_date,remarks,del_flag");
				map.put("insertFieldList",insertFieldList);
				map.put("insertField",insertField+"create_by,create_date,update_by,update_date,remarks,del_flag");

				//list 页面特殊设置
				map.put("listNum",listNum++);
			}
			return map;
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		return null;
	}

	@Override
	public GenSchemeExample getExampleFromEntity(GenScheme genScheme) {
		GenSchemeExample example = new GenSchemeExample();
		GenSchemeExample.Criteria ca = example.or();
		if(genScheme==null){
			return example;
		}

		if(genScheme.getId()!=null){
			ca.andIdEqualTo(genScheme.getId());
		}
		if(genScheme.getName()!=null
				&&!"".equals(genScheme.getName())){
			ca.andNameLike("%"+genScheme.getName()+"%");
		}
		if(genScheme.getCategory()!=null
				&&!"".equals(genScheme.getCategory())){
			ca.andCategoryEqualTo(genScheme.getCategory());
		}
		if(genScheme.getPackageName()!=null
				&&!"".equals(genScheme.getPackageName())){
			ca.andPackageNameLike("%"+genScheme.getPackageName()+"%");
		}
		if(genScheme.getModuleName()!=null
				&&!"".equals(genScheme.getModuleName())){
			ca.andModuleNameLike("%"+genScheme.getModuleName()+"%");
		}
		if(genScheme.getSubModuleName()!=null
				&&!"".equals(genScheme.getSubModuleName())){
			ca.andSubModuleNameLike("%"+genScheme.getSubModuleName()+"%");
		}
		if(genScheme.getFunctionName()!=null
				&&!"".equals(genScheme.getFunctionName())){
			ca.andFunctionNameLike("%"+genScheme.getFunctionName()+"%");
		}
		if(genScheme.getFunctionNameSimple()!=null
				&&!"".equals(genScheme.getFunctionNameSimple())){
			ca.andFunctionNameSimpleLike("%"+genScheme.getFunctionNameSimple()+"%");
		}
		if(genScheme.getFunctionAuthor()!=null
				&&!"".equals(genScheme.getFunctionAuthor())){
			ca.andFunctionAuthorLike("%"+genScheme.getFunctionAuthor()+"%");
		}
		if(genScheme.getFunctionVersion()!=null
				&&!"".equals(genScheme.getFunctionVersion())){
			ca.andFunctionVersionLike("%"+genScheme.getFunctionVersion()+"%");
		}
		if(genScheme.getGenTableId()!=null){
			ca.andGenTableIdEqualTo(genScheme.getGenTableId());
		}
		if(genScheme.getPageTitle()!=null
				&&!"".equals(genScheme.getPageTitle())){
			ca.andPageTitleLike("%"+genScheme.getPageTitle()+"%");
		}
		if(genScheme.getPageTitle2()!=null
				&&!"".equals(genScheme.getPageTitle2())){
			ca.andPageTitle2Like("%"+genScheme.getPageTitle2()+"%");
		}
		if(genScheme.getPath()!=null
				&&!"".equals(genScheme.getPath())){
			ca.andPathLike("%"+genScheme.getPath()+"%");
		}
		if(genScheme.getListName()!=null
				&&!"".equals(genScheme.getListName())){
			ca.andListNameLike("%"+genScheme.getListName()+"%");
		}
		if(genScheme.getCreateBy()!=null){
			ca.andCreateByEqualTo(genScheme.getCreateBy());
		}
		if(genScheme.getCreateDate()!=null){
			ca.andCreateDateBetween(genScheme.getBeginCreateDate(),genScheme.getEndCreateDate());
		}
		if(genScheme.getUpdateBy()!=null){
			ca.andUpdateByEqualTo(genScheme.getUpdateBy());
		}
		if(genScheme.getUpdateDate()!=null){
			ca.andUpdateDateBetween(genScheme.getBeginUpdateDate(),genScheme.getEndUpdateDate());
		}
		if(genScheme.getRemarks()!=null
				&&!"".equals(genScheme.getRemarks())){
			ca.andRemarksLike("%"+genScheme.getRemarks()+"%");
		}
		if(genScheme.getDelFlag()!=null
				&&!"".equals(genScheme.getDelFlag())){
			ca.andDelFlagEqualTo(genScheme.getDelFlag());
		}
		return example;
	}
}