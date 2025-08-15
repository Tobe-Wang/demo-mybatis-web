/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.demo.repository;

import cn.zhaofd.demomybatisweb.demo.dto.SysInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    SysInfo findById(String id);
}
