/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.demo.web;

import cn.zhaofd.demomybatisweb.demo.dto.SysUser;
import cn.zhaofd.demomybatisweb.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 手动配置的MyBatis应用示例
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    private final SysUserService sysUserService;

    public SysUserController(@Autowired SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysUser
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SysUser findById(@PathVariable("id") Integer id) {
        return sysUserService.findById(id);
    }
}
