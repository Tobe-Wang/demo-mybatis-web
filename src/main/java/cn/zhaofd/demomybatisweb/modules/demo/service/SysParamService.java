/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.modules.demo.service;

import cn.zhaofd.core.base.NumberUtil;
import cn.zhaofd.core.base.ObjectUtil;
import cn.zhaofd.demomybatisweb.core.dto.DataSet;
import cn.zhaofd.demomybatisweb.modules.demo.dto.SysParam;
import cn.zhaofd.demomybatisweb.modules.demo.dto.SysUser;
import cn.zhaofd.demomybatisweb.modules.demo.repository.SysParamRepository;
import cn.zhaofd.demomybatisweb.type.MyBatisParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 注解方式配置的MyBatis应用示例
 */
@Service
public class SysParamService {
    private final SysParamRepository sysParamRepository;

    public SysParamService(@Autowired SysParamRepository sysParamRepository) {
        this.sysParamRepository = sysParamRepository;
    }

    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysParam
     */
    @Transactional(readOnly = true)
    public SysParam findById(Integer id) {
        return sysParamRepository.findById(id);
    }

    /**
     * 查询
     *
     * @param params 查询参数
     * @return {@code List<SysParam>}
     */
    @Transactional(readOnly = true)
    public List<SysParam> find(Map<String, Object> params) {
        return sysParamRepository.find(params);
    }

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return 分页结果集
     */
    @Transactional(readOnly = true)
    public List<SysParam> findPage(Map<String, Object> params) {
        // 1、计算分页参数
        Object pageOffset = params.get(MyBatisParamType.PAGE_OFFSET.toString()); // 分页偏移量(第1行记录偏移量为0)
        Object pageNumber = params.get(MyBatisParamType.PAGE_NUMBER.toString()); // 分页页码(第1页=1)，默认页码(第1页)
        Object pageSize = params.get(MyBatisParamType.PAGE_SIZE.toString()); // 分页大小，默认每页显示记录数(20条)
        // 1.1、转换为数值类型
        if (ObjectUtil.exists(pageOffset)) {
            pageOffset = ObjectUtil.convert(pageOffset, Integer.class);
            params.put(MyBatisParamType.PAGE_OFFSET.toString(), pageOffset);
        }
        if (ObjectUtil.exists(pageNumber)) {
            pageNumber = ObjectUtil.convert(pageNumber, Integer.class);
            params.put(MyBatisParamType.PAGE_NUMBER.toString(), pageNumber);
        }
        if (ObjectUtil.exists(pageSize)) {
            pageSize = ObjectUtil.convert(pageSize, Integer.class);
            params.put(MyBatisParamType.PAGE_SIZE.toString(), pageSize);
        }
        // 1.2、分页参数处理
        if (!ObjectUtil.exists(pageSize) || !NumberUtil.isDigits(ObjectUtil.convert(pageSize, String.class))) { // 分页大小，默认值
            pageSize = 20;
            params.put(MyBatisParamType.PAGE_SIZE.toString(), pageSize);
        }
        if (!ObjectUtil.exists(pageOffset) || !NumberUtil.isDigits(ObjectUtil.convert(pageOffset, String.class))) {
            if (!ObjectUtil.exists(pageNumber) || !NumberUtil.isDigits(ObjectUtil.convert(pageNumber, String.class))) { // 分页偏移量、分页页码，默认值
                pageOffset = 0;
                pageNumber = 1;
                params.put(MyBatisParamType.PAGE_OFFSET.toString(), pageOffset);
                params.put(MyBatisParamType.PAGE_NUMBER.toString(), pageNumber);
            } else { // 使用分页页码计算分页偏移量
                int number = ObjectUtil.convert(pageNumber, Integer.class);
                int size = ObjectUtil.convert(pageSize, Integer.class);
                pageOffset = (number - 1) * size;
                params.put(MyBatisParamType.PAGE_OFFSET.toString(), pageOffset);
            }
        }

        return sysParamRepository.findPage(params);
    }

    /**
     * 新增保存
     *
     * @param sysParam DTO数据传输对象
     * @return 保存后的DTO数据传输对象
     */
    @Transactional(rollbackFor = {Exception.class})
    public SysParam save(SysParam sysParam) {
        int num = sysParamRepository.save(sysParam);
        return num > 0 ? sysParam : null;
    }

    /**
     * 批量保存
     *
     * @param ds 增、删、改数据集
     * @return 保存后的增、删、改数据集
     */
    @Transactional(rollbackFor = {Exception.class})
    public DataSet<SysParam, Integer> save(DataSet<SysParam, Integer> ds) {
        // 删除
        if (ds.getDeletedIds() != null && !ds.getDeletedIds().isEmpty()) {
            sysParamRepository.delete(ds.getDeletedIds());
        }

        // 修改
        if (ds.getUpdatedList() != null && !ds.getUpdatedList().isEmpty()) {
            List<SysParam> list = ds.getUpdatedList();
            if (list != null && !list.isEmpty()) {
                for (SysParam sysParam : list) {
                    sysParamRepository.update(sysParam);
                }
            }
        }

        // 增加
        if (ds.getInsertedList() != null && !ds.getInsertedList().isEmpty()) {
            sysParamRepository.saveAll(ds.getInsertedList());
        }

        return ds;
    }

    /**
     * 修改
     *
     * @param sysParam DTO数据传输对象
     * @return 修改后的DTO数据传输对象
     */
    @Transactional(rollbackFor = {Exception.class})
    public SysParam update(SysParam sysParam) {
        int num = sysParamRepository.update(sysParam);
        return num > 0 ? sysParam : null;
    }

    /**
     * 删除
     *
     * @param id 主键ID
     * @return 受影响行数
     */
    @Transactional(rollbackFor = {Exception.class})
    public int deleteById(Integer id) {
        return sysParamRepository.deleteById(id);
    }

    /**
     * 查询总数
     *
     * @param params 查询参数
     * @return 总记录数
     */
    @Transactional(readOnly = true)
    public Long count(Map<String, Object> params) {
        return sysParamRepository.count(params);
    }

    /**
     * 调用存储过程
     *
     * @param name 姓名
     * @return {@code List<SysUser>}
     */
    public List<SysUser> procUser(String name) {
        return sysParamRepository.procUser(name);
    }
}
