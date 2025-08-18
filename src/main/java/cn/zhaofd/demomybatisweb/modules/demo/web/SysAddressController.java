/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.modules.demo.web;

import cn.zhaofd.demomybatisweb.modules.demo.dto.SysAddress;
import cn.zhaofd.demomybatisweb.modules.demo.service.SysAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 手动xml方式配置的MyBatis应用示例
 */
@RestController
@RequestMapping("/sys/address")
public class SysAddressController {
    private final SysAddressService sysAddressService;

    public SysAddressController(@Autowired SysAddressService sysAddressService) {
        this.sysAddressService = sysAddressService;
    }

    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysAddress
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SysAddress findById(@PathVariable("id") Integer id) {
        return sysAddressService.findById(id);
    }

    /**
     * 根据id查询(包括外键对象)
     *
     * @param id 主键ID
     * @return SysAddress
     */
    @GetMapping(value = "/all/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SysAddress findAllById(@PathVariable("id") Integer id) {
        return sysAddressService.findAllById(id);
    }
}
