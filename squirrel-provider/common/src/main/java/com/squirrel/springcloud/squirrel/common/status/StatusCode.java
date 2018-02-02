package com.squirrel.springcloud.squirrel.common.status;
/**
 * 统一返回状态码
 * Created by JoinHan on 2017/4/22.
 */
public class StatusCode {
	
	//CURD--数据库数据增删改查类型 1  ADD--操作方式新增  01 SUCCESS--处理结果成功 01
	public static final int CURD_ADD_SUCCESS = 10101;
	//CURD--数据库数据增删改查类型 1  ADD--操作方式新增  01 FAILURE--处理结果失败 02
	public static final int CURD_ADD_FAILURE = 10102;

	//CURD--数据库数据增删改查类型 1 SELECT--操作方式查询  02 SUCCESS--处理结果成功 01
	public static final int CURD_SELECT_SUCCESS = 10201;
	//CURD--数据库数据增删改查类型 1 SELECT--操作方式查询  02 FAILURE--处理结果失败 02
	public static final int CURD_SELECT_FAILURE = 10202;

	//CURD--数据库数据增删改查类型 1 DELETE--操作方式查询  03 SUCCESS--处理结果成功 01
	public static final int CURD_DELETE_SUCCESS = 10301;
	//CURD--数据库数据增删改查类型 1 DELETE--操作方式查询  03 FAILURE--处理结果失败 02
	public static final int CURD_DELETE_FAILURE = 10302;

	//CURD--数据库数据增删改查类型 1 UPDATE--操作方式修改  04 SUCCESS--处理结果成功 01
	public static final int CURD_UPDATE_SUCCESS = 10401;
	//CURD--数据库数据增删改查类型 1 UPDATE--操作方式修改  04 FAILURE--处理结果失败 02
	public static final int CURD_UPDATE_FAILURE = 10402;
	
	//树查询成功返回状态码  TREE--树操作类型 2 MENU--树类型 01 SUCCESS--处理结果成功 01
	public static final int TREE_SUCCESS = 20101;
	//树查询失败返回状态码  TREE--树操作类型 2 MENU--树类型 01 FAILURE--处理结果失败 02
	public static final int TREE_FAILURE = 20102;
	
	//文件上传成功返回状态码  UPLOAD--上传操作类型 3 FILE--文件类型 01 SUCCESS--处理结果成功 01
	public static final int UPLOAD_FILE_SUCCESS = 30101;
	//文件上传失败返回状态码  upload--上传操作类型 3 file--文件类型 01 FAILURE--处理结果失败 02
	public static final int UPLOAD_FILE_FAILURE = 30102;

}
