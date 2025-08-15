/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.demo.service;

import cn.zhaofd.core.base.NumberUtil;
import cn.zhaofd.core.base.ObjectUtil;
import cn.zhaofd.demomybatisweb.core.dto.DataSet;
import cn.zhaofd.demomybatisweb.demo.dto.SysUser;
import cn.zhaofd.demomybatisweb.demo.repository.SysUserRepository;
import cn.zhaofd.demomybatisweb.type.MyBatisParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
    @Transactional(readOnly = true)
    public SysUser findById(Integer id) {
        return sysUserRepository.findById(id);
    }

    /**
     * 查询
     *
     * @param params 查询参数
     * @return {@code List<SysUser>}
     */
    @Transactional(readOnly = true)
    public List<SysUser> find(Map<String, Object> params) {
        return sysUserRepository.find(params);
    }

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return 分页结果集
     */
    @Transactional(readOnly = true)
    public List<SysUser> findPage(Map<String, Object> params) {
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

        return sysUserRepository.findPage(params);
    }

    /**
     * 新增保存
     *
     * @param sysUser DTO数据传输对象
     * @return 保存后的DTO数据传输对象
     */
    @Transactional
    public SysUser save(SysUser sysUser) {
        int num = sysUserRepository.save(sysUser);
        return num > 0 ? sysUser : null;
    }

    /**
     * 批量保存
     *
     * @param ds 增、删、改数据集
     * @return 保存后的增、删、改数据集
     */
    @Transactional
    public DataSet<SysUser, Integer> save(DataSet<SysUser, Integer> ds) {
        // 删除
        if (ds.getDeletedIds() != null && !ds.getDeletedIds().isEmpty()) {
            sysUserRepository.delete(ds.getDeletedIds());
        }

        // 修改
        if (ds.getUpdatedList() != null && !ds.getUpdatedList().isEmpty()) {
            List<SysUser> list = ds.getUpdatedList();
            if (list != null && !list.isEmpty()) {
                for (SysUser sysUser : list) {
                    sysUserRepository.update(sysUser);
                }
            }
        }

        // 增加
        if (ds.getInsertedList() != null && !ds.getInsertedList().isEmpty()) {
            sysUserRepository.saveAll(ds.getInsertedList());
        }

        return ds;
    }

    /**
     * 修改
     *
     * @param sysUser DTO数据传输对象
     * @return 修改后的DTO数据传输对象
     */
    @Transactional
    public SysUser update(SysUser sysUser) {
        int num = sysUserRepository.update(sysUser);
        return num > 0 ? sysUser : null;
    }

    /**
     * 删除
     *
     * @param id 主键ID
     * @return 受影响行数
     */
    @Transactional
    public int deleteById(Integer id) {
        return sysUserRepository.deleteById(id);
    }

    /**
     * 查询总数
     *
     * @param params 查询参数
     * @return 总记录数
     */
    @Transactional(readOnly = true)
    public Long count(Map<String, Object> params) {
        return sysUserRepository.count(params);
    }
}
