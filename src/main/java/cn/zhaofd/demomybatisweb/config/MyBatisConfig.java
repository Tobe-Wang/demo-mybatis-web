/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类s
 */
@Configuration
@MapperScan(
        basePackages = {"cn.zhaofd.demomybatisweb.modules.demo.repository"}, // 扫描的Mapper接口包，多个以数组方式配置
        annotationClass = Mapper.class // 指定Mapper接口的注解
)
public class MyBatisConfig {
}
