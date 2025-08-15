/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 手动配置的MyBatis应用示例
 */
@Data
public class SysUser implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    @Size(max = 10)
    private String name;

    @Size(max = 1)
    private String sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Spring框架注解，用于前端到后端的数据绑定（HTTP请求参数->Java对象）
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Jackson库注解，用于JSON序列化和反序列化（Java对象<->JSON字符串）
    private LocalDateTime regtime;
}