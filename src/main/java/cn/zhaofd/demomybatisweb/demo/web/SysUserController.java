/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.demo.web;

import cn.zhaofd.demomybatisweb.demo.dto.SysUser;
import cn.zhaofd.demomybatisweb.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询
     *
     * @param params 查询参数
     * @return {@code List<SysUser>}
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SysUser> find(@RequestParam Map<String, Object> params) {
        return sysUserService.find(params);
    }

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return {@code List<SysUser>}
     */
    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SysUser> findPage(@RequestParam Map<String, Object> params) {
        return sysUserService.findPage(params);
    }

    /**
     * 查询总数
     *
     * @param params 查询参数
     * @return 总记录数
     */
    @GetMapping(value = "/count")
    public Long count(@RequestParam Map<String, Object> params) {
        return sysUserService.count(params);
    }
}
