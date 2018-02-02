package com.squirrel.springcloud.squirrel.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 控制器支持类
 * Created by JoinHan on 2018/01/11.
 */
public abstract class BaseController {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * dataTable对象
	 */
	protected BaseTableData baseTableData = new BaseTableData();
	

}
