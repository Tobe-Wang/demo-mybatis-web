/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.modules.demo.web;

import cn.zhaofd.core.net.exception.HttpException;
import cn.zhaofd.core.spring.validation.ValidationUtil;
import cn.zhaofd.demomybatisweb.modules.demo.dto.SysInfo;
import cn.zhaofd.demomybatisweb.modules.demo.service.SysInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

/**
 * 手动xml方式配置的MyBatis应用示例
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

    /**
     * 新增保存(前端json对象数据)
     *
     * @param sysInfo DTO数据传输对象
     * @param errors  Errors对象
     * @return 保存后的DTO数据传输对象
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public SysInfo save(@Valid @RequestBody SysInfo sysInfo, Errors errors) {
        // 输入参数验证
        if (errors.hasErrors()) {
            throw new HttpException(HttpStatus.BAD_REQUEST.value(), ValidationUtil.getErrorMsg(errors));
        }

        return sysInfoService.save(sysInfo);
    }
}
