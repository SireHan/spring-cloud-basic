package com.squirrel.springcloud.consumer.modules.sys.controller;

import com.squirrel.springcloud.consumer.modules.sys.remote.SysUserRemote;
import com.squirrel.springcloud.provider.common.base.BaseOpMsg;
import com.squirrel.springcloud.provider.modules.sys.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: JoinHan
 * @Date: Created in 10:34 2018/2/5
 * @Modified By：
 */
@Controller
@RequestMapping(value = "/sys/sysUser")
public class SysUserController {
    @Autowired
    private SysUserRemote sysUserRemote;

    @RequestMapping("/list")
    @ResponseBody
    public BaseOpMsg<SysUser> list() {
        return sysUserRemote.list();
    }
}
