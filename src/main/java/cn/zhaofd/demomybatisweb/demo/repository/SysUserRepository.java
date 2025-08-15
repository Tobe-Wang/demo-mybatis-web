/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.demo.repository;

import cn.zhaofd.demomybatisweb.demo.dto.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 手动配置的MyBatis应用示例
 */
@Mapper
public interface SysUserRepository {
    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysUser
     */
    @Transactional(readOnly = true)
    SysUser findById(Integer id);
}
