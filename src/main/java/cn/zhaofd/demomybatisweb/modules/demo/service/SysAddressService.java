/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.modules.demo.service;

import cn.zhaofd.demomybatisweb.modules.demo.dto.SysAddress;
import cn.zhaofd.demomybatisweb.modules.demo.repository.SysAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 手动xml方式配置的MyBatis应用示例
 */
@Service
public class SysAddressService {
    private final SysAddressRepository sysAddressRepository;

    public SysAddressService(@Autowired SysAddressRepository sysAddressRepository) {
        this.sysAddressRepository = sysAddressRepository;
    }

    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysAddress
     */
    @Transactional(readOnly = true)
    public SysAddress findById(Integer id) {
        return sysAddressRepository.findById(id);
    }

    /**
     * 根据id查询(包括外键对象)
     *
     * @param id 主键ID
     * @return SysAddress
     */
    @Transactional(readOnly = true)
    public SysAddress findAllById(Integer id) {
        return sysAddressRepository.findAllById(id);
    }
}
