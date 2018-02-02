/**
 *  该类有generator 自动生成
 * Copyright &copy; 2017-2018 All rights reserved.
 */
package com.squirrel.springcloud.squirrel.gen.web.service;


import com.squirrel.springcloud.squirrel.common.base.BaseService;
import com.squirrel.springcloud.squirrel.gen.web.entity.GenScheme;
import com.squirrel.springcloud.squirrel.gen.web.entity.GenSchemeExample;

/**
 * 代码生成方案表Service
 * @author JoinHan
 * @version 2017-09-06
 */
public interface GenSchemeService extends BaseService<GenScheme,GenSchemeExample> {

    /**
     * 根据方案生成代码
     * @param id
     * @return
     */
    boolean codeMake(Long id);
}