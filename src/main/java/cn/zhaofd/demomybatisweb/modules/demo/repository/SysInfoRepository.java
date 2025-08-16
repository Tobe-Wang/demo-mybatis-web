/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.modules.demo.repository;

import cn.zhaofd.demomybatisweb.modules.demo.dto.SysInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 手动配置的MyBatis应用示例
 */
@Mapper
public interface SysInfoRepository {
    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysInfo
     */
    SysInfo findById(String id);
}
