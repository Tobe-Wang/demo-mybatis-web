/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.demo.repository;

import cn.zhaofd.demomybatisweb.demo.dto.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 手动配置的MyBatis应用示例
 */
@Mapper
public interface SysUserRepository {
    /**
     * 新增保存
     *
     * @param sysUser DTO数据传输对象
     * @return 受影响行数
     */
    int save(SysUser sysUser);

    /**
     * 批量保存
     *
     * @param list 批量保存的集合
     * @return 受影响行数
     */
    int saveAll(List<SysUser> list);

    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysUser
     */
    SysUser findById(Integer id);

    /**
     * 查询
     *
     * @param params 查询参数
     * @return {@code List<SysUser>}
     */
    List<SysUser> find(Map<String, Object> params);

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return {@code List<SysUser>}
     */
    List<SysUser> findPage(Map<String, Object> params);

    /**
     * 查询总数
     *
     * @param params 查询参数
     * @return 总记录数
     */
    Long count(Map<String, Object> params);
}
