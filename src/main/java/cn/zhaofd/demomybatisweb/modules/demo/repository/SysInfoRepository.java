/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.modules.demo.repository;

import cn.zhaofd.demomybatisweb.modules.demo.dto.SysInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 手动xml方式配置的MyBatis应用示例
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

    /**
     * 新增保存
     *
     * @param sysInfo DTO数据传输对象
     * @return 受影响行数
     */
    int save(SysInfo sysInfo);
}
