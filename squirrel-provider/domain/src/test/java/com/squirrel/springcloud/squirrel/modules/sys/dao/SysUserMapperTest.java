package com.squirrel.springcloud.squirrel.modules.sys.dao;

import com.squirrel.springcloud.squirrel.modules.sys.entity.SysUser;
import com.squirrel.springcloud.squirrel.modules.sys.entity.SysUserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: JoinHan
 * @Date: Created in 14:35 2018/1/29
 * @Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserMapperTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    @Transactional
    public void curd(){
        //新增一条数据
        SysUser sysUser = new SysUser();
        sysUser.setAreaId(1L);
        sysUser.setOfficeId(1L);
        sysUser.setDepartId(2L);
        sysUser.setLnm("测试数据名称");
        sysUser.setPw("123");
        sysUser.setCreateBy(1L);
        sysUser.setCreateDate(new Date());
        int res = sysUserMapper.insert(sysUser);
        if(res>0){
            logger.info("数据插入测试成功 ：insert Object.");
        }
        //查询一条数据
        SysUserExample example = new SysUserExample();
        example.or().andAreaIdEqualTo(1L);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            logger.info("数据查询测试成功 ：select example.");
            SysUser one = list.get(0);
            //修改测试
            one.setAreaId(2L);
            int uprest = sysUserMapper.updateByPrimaryKey(one);
            if(uprest>0){
                logger.info("数据 根据主键修改测试成功 ：update key.");
            }
            //删除测试
            int delrest = sysUserMapper.deleteByPrimaryKey(one.getId());
            if(delrest>0){
                logger.info("数据 物理删除测试成功 ：delete key.");
            }
        }
    }

}