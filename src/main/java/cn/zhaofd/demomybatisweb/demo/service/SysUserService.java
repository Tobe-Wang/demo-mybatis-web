/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.demo.service;

import cn.zhaofd.demomybatisweb.demo.dto.SysUser;
import cn.zhaofd.demomybatisweb.demo.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 手动配置的MyBatis应用示例
 */
@Service
public class SysUserService {
    private final SysUserRepository sysUserRepository;

    public SysUserService(@Autowired SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysUser
     */
    public SysUser findById(Integer id) {
        return sysUserRepository.findById(id);
    }
}
