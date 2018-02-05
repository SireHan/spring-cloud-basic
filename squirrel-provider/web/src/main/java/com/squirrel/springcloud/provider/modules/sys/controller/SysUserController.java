/**
 *  该类有generator 自动生成
 * Copyright &copy; 2017-2018 All rights reserved.
 */
package com.squirrel.springcloud.provider.modules.sys.controller;

import com.squirrel.springcloud.provider.common.base.BaseController;
import com.squirrel.springcloud.provider.common.base.BaseOpMsg;
import com.squirrel.springcloud.provider.common.status.StatusCode;
import com.squirrel.springcloud.provider.modules.sys.entity.SysUser;
import com.squirrel.springcloud.provider.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 系统登录用户Controller
 * @author JoinHan
 * @version 2017-09-06
 */
@Controller
@RequestMapping(value = "/sys/sysUser")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService sysUserService;
	
	@ResponseBody
	@RequestMapping(value = "/list")
	public BaseOpMsg<SysUser> list() {
		BaseOpMsg<SysUser> resultMap = new BaseOpMsg<SysUser>();
		SysUser u = new SysUser();
		List<SysUser> userList = sysUserService.findListByRecord(null);
		resultMap.setCode(StatusCode.CURD_SELECT_SUCCESS);
		resultMap.setMsg("success");
		resultMap.setList(userList);
		return resultMap;
	}
}