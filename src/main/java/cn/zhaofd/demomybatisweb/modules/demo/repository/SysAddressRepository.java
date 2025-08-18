/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.modules.demo.repository;

import cn.zhaofd.demomybatisweb.modules.demo.dto.SysAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 手动xml方式配置的MyBatis应用示例
 */
@Mapper
public interface SysAddressRepository {
    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysAddress
     */
    SysAddress findById(Integer id);

    /**
     * 根据用户id查询
     *
     * @param userid 用户id
     * @return {@code List<SysAddress>}
     */
    List<SysAddress> findByUserId(Integer userid);
}
