/**
 * Copyright &copy; 2017-2018 All rights reserved.
 */
package com.squirrel.springcloud.squirrel.modules.sys.dao;

import com.squirrel.springcloud.squirrel.common.base.BaseMapper;
import com.squirrel.springcloud.squirrel.modules.sys.entity.SysUser;
import com.squirrel.springcloud.squirrel.modules.sys.entity.SysUserExample;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统登录用户Mapper接口
 * @author JoinHan
 * @version 2017-09-06
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser,SysUserExample> {
    int updateByPrimaryKeyWithBLOBs(SysUser record);
}