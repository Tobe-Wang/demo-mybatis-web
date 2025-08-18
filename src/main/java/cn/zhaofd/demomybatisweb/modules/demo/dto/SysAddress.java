/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.modules.demo.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 手动xml方式配置的MyBatis应用示例
 */
@Data
public class SysAddress implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;

    @Size(max = 30)
    private String address;

    @Size(max = 6)
    private String zipcode;

    private Integer userid;

    private SysUser sysUser;
}
