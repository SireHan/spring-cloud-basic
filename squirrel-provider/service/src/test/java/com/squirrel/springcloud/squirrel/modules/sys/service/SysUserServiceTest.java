package com.squirrel.springcloud.squirrel.modules.sys.service;

import com.squirrel.springcloud.squirrel.modules.sys.entity.SysUser;
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
 * @Date: Created in 12:26 2018/1/30
 * @Modified By：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.squirrel.springcloud.squirrel.SquirrelServiceApplication.class)
public class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *  在数据库没有数据的情况下 测试增删改查数据
     */
    @Test
    @Transactional
    public void curdTest(){
        //新增一条数据
        SysUser sysUser = new SysUser();
        sysUser.setAreaId(1L);
        sysUser.setOfficeId(1L);
        sysUser.setDepartId(2L);
        sysUser.setLnm("测试数据名称");
        sysUser.setPw("123");
        sysUser.setCreateBy(1L);
        sysUser.setCreateDate(new Date());
        int res = sysUserService.insertRecord(sysUser);
        if(res>0){
            logger.info("数据插入测试成功 ：insert Object.");
        }
        //查询一条数据
        sysUser.setCreateDate(null);
        SysUser one = sysUserService.selectByRecord(sysUser);
        if(one!=null&& one.getAreaId().equals(sysUser.getAreaId())){
            logger.info("数据单条查询测试成功 ：select Object.");
        }
        //根据主键查询
        SysUser two = sysUserService.selectByPrimaryKey(one.getId());
        if(two.getId().equals(one.getId())){
            logger.info("数据主键查询测试成功 ：select key.");
        }
        List<SysUser> list = sysUserService.findListByRecord(sysUser);
        if(list!=null&&list.size()>0){
            SysUser find = list.get(0);
            if(find.getAreaId().equals(sysUser.getAreaId())){
                logger.info("数据查询测试成功 ：findList Object & findList Example.");
                //分页测试查询 先插入2条数据 分页查询第2页数据
                sysUser.setCreateDate(new Date());
                sysUserService.insertRecord(sysUser);
                sysUserService.insertRecord(sysUser);
                sysUser.setCreateDate(null);
                List<SysUser> pageList = sysUserService.findListByRecordForPage(sysUser,1,2);
                if(pageList!=null){
                    if(pageList.size()==1&&pageList.get(0).getId().equals(one.getId()+2)){
                        logger.info("数据分页查询测试成功 ：findListPage Object & findListPage Example.");
                    }
                }

                //总条数
                sysUser.setId(null);
                int count = sysUserService.countByRecord(sysUser);
                if(count==3){
                    logger.info("数据 总条数测试成功 ：count Object & count Example.");
                }

                //修改测试
                one.setAreaId(2L);
                int uprest = sysUserService.updateByPrimaryKey(one);
                if(uprest>0){
                    logger.info("数据 根据主键修改测试成功 ：update key.");
                }
                //删除测试
                int delrest = sysUserService.deleteByPrimaryKey(pageList.get(0).getId());
                if(delrest>0){
                    logger.info("数据 物理删除测试成功 ：delete key.");
                }
                delrest = sysUserService.deleteVirtualByPrimaryKey(one.getId());
                if(delrest>0){
                    logger.info("数据 虚拟删除测试成功 ：delete virtual key.");
                }
            }
        }

        assert(res>0);
    }

}