/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.demo.service;

import cn.zhaofd.demomybatisweb.demo.dto.SysInfo;
import cn.zhaofd.demomybatisweb.demo.repository.SysInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 手动配置的MyBatis应用示例
 */
@Service
public class SysInfoService {
    private final SysInfoRepository sysInfoRepository;

    public SysInfoService(@Autowired SysInfoRepository sysInfoRepository) {
        this.sysInfoRepository = sysInfoRepository;
    }

    /**
     * 根据id查询
     *
     * @param id 主键ID
     * @return SysInfo
     */
    @Transactional(readOnly = true)
    public SysInfo findById(String id) {
        return sysInfoRepository.findById(id);
    }
}
