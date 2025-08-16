/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.modules.demo.web;

import cn.zhaofd.demomybatisweb.modules.demo.dto.SysInfo;
import cn.zhaofd.demomybatisweb.modules.demo.service.SysInfoService;
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
@RequestMapping("/sys/info")
public class SysInfoController {
    private final SysInfoService sysInfoService;

    public SysInfoController(@Autowired SysInfoService sysInfoService) {
        this.sysInfoService = sysInfoService;
    }

    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysInfo
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SysInfo findById(@PathVariable("id") String id) {
        return sysInfoService.findById(id);
    }
}
