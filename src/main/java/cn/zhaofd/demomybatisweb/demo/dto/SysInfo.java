/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

/**
 * 手动配置的MyBatis应用示例
 */
@Data
public class SysInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    @Size(max = 32)
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant rcreatetime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant rupdatetime;
}