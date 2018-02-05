package com.squirrel.springcloud.consumer.modules.sys.remote;

import com.squirrel.springcloud.provider.common.base.BaseOpMsg;
import com.squirrel.springcloud.provider.modules.sys.entity.SysUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: JoinHan
 * @Date: Created in 9:58 2018/2/5
 * @Modified By：
 */
@FeignClient(name= "spring-cloud-producer")
public interface SysUserRemote {

    @RequestMapping(value = "/sys/sysUser/list")
    public BaseOpMsg<SysUser> list();
}
