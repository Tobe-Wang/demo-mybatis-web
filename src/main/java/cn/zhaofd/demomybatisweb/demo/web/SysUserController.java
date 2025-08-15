/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.demo.web;

import cn.zhaofd.core.net.exception.HttpException;
import cn.zhaofd.core.spring.validation.ValidationUtil;
import cn.zhaofd.demomybatisweb.core.dto.DataSet;
import cn.zhaofd.demomybatisweb.demo.dto.SysUser;
import cn.zhaofd.demomybatisweb.demo.service.SysUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
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
     * 新增保存(前端json对象数据)
     *
     * @param sysUser DTO数据传输对象
     * @param errors  Errors对象
     * @return 保存后的DTO数据传输对象
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public SysUser save(@Valid @RequestBody SysUser sysUser, Errors errors) {
        // 输入参数验证
        if (errors.hasErrors()) {
            throw new HttpException(HttpStatus.BAD_REQUEST.value(), ValidationUtil.getFieldErrorMsg(errors));
        }

        return sysUserService.save(sysUser);
    }

    /**
     * 批量保存
     *
     * @param ds 增、删、改数据集
     * @return 保存后的增、删、改数据集
     */
    @PostMapping(value = "/dataset", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataSet<SysUser, Integer> saveDataSet(@RequestBody DataSet<SysUser, Integer> ds) {
        return sysUserService.save(ds);
    }

    /**
     * 修改(前端json对象数据)
     *
     * @param sysUser    DTO数据传输对象
     * @param errors Errors对象
     * @return 修改后的DTO数据传输对象
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SysUser update(@Valid @RequestBody SysUser sysUser, Errors errors) {
        // 输入参数验证
        if (errors.hasErrors()) {
            throw new HttpException(HttpStatus.BAD_REQUEST.value(), ValidationUtil.getFieldErrorMsg(errors));
        }

        // 验证主键字段是否有值
        if (sysUser.getId() == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST.value(), "主键字段值(id)不能为空");
        }

        return sysUserService.update(sysUser);
    }

    /**
     * 删除
     *
     * @param id 主键id
     */
    @DeleteMapping(value = "/{id}")
    public Integer deleteById(@PathVariable("id") Integer id) {
        return sysUserService.deleteById(id);
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
