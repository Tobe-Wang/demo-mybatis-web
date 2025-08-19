/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.modules.demo.web;

import cn.zhaofd.core.net.exception.HttpException;
import cn.zhaofd.core.spring.validation.ValidationUtil;
import cn.zhaofd.demomybatisweb.core.dto.DataSet;
import cn.zhaofd.demomybatisweb.modules.demo.dto.SysParam;
import cn.zhaofd.demomybatisweb.modules.demo.dto.SysUser;
import cn.zhaofd.demomybatisweb.modules.demo.service.SysParamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 注解方式配置的MyBatis应用示例
 */
@RestController
@RequestMapping("/sys/param")
public class SysParamController {
    private final SysParamService sysParamService;

    public SysParamController(@Autowired SysParamService sysParamService) {
        this.sysParamService = sysParamService;
    }

    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysParam
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SysParam findById(@PathVariable("id") Integer id) {
        return sysParamService.findById(id);
    }

    /**
     * 查询
     *
     * @param params 查询参数
     * @return {@code List<SysParam>}
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SysParam> find(@RequestParam Map<String, Object> params) {
        return sysParamService.find(params);
    }

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return {@code List<SysParam>}
     */
    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SysParam> findPage(@RequestParam Map<String, Object> params) {
        return sysParamService.findPage(params);
    }

    /**
     * 新增保存(前端json对象数据)
     *
     * @param sysParam DTO数据传输对象
     * @param errors  Errors对象
     * @return 保存后的DTO数据传输对象
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public SysParam save(@Valid @RequestBody SysParam sysParam, Errors errors) {
        // 输入参数验证
        if (errors.hasErrors()) {
            throw new HttpException(HttpStatus.BAD_REQUEST.value(), ValidationUtil.getFieldErrorMsg(errors));
        }

        return sysParamService.save(sysParam);
    }

    /**
     * 批量保存
     *
     * @param ds 增、删、改数据集
     * @return 保存后的增、删、改数据集
     */
    @PostMapping(value = "/dataset", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataSet<SysParam, Integer> saveDataSet(@RequestBody DataSet<SysParam, Integer> ds) {
        return sysParamService.save(ds);
    }

    /**
     * 修改(前端json对象数据)
     *
     * @param sysParam    DTO数据传输对象
     * @param errors Errors对象
     * @return 修改后的DTO数据传输对象
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SysParam update(@Valid @RequestBody SysParam sysParam, Errors errors) {
        // 输入参数验证
        if (errors.hasErrors()) {
            throw new HttpException(HttpStatus.BAD_REQUEST.value(), ValidationUtil.getFieldErrorMsg(errors));
        }

        // 验证主键字段是否有值
        if (sysParam.getId() == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST.value(), "主键字段值(id)不能为空");
        }

        return sysParamService.update(sysParam);
    }

    /**
     * 删除
     *
     * @param id 主键id
     */
    @DeleteMapping(value = "/{id}")
    public Integer deleteById(@PathVariable("id") Integer id) {
        return sysParamService.deleteById(id);
    }

    /**
     * 查询总数
     *
     * @param params 查询参数
     * @return 总记录数
     */
    @GetMapping(value = "/count")
    public Long count(@RequestParam Map<String, Object> params) {
        return sysParamService.count(params);
    }

    /**
     * 调用存储过程
     *
     * @param name 姓名
     * @return {@code List<SysUser>}
     */
    @GetMapping(value = "/procUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SysUser> procUser(@RequestParam String name) {
        return sysParamService.procUser(name);
    }
}
