/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.modules.demo.repository;

import cn.zhaofd.core.base.ObjectUtil;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 注解方式配置的MyBatis应用示例
 */
public class SysParamSqlBuilder {
    /**
     * 查询
     *
     * @param params 查询参数
     * @return sql语句
     */
    public static String find(final Map<String, Object> params) {
        return new SQL() {{
            SELECT("id, code, value, regtime");
            FROM("sys_param");
            if (params.get("id") != null) {
                WHERE("id = #{id}");
            }
            if (params.get("code") != null) {
                WHERE("code = #{code}");
            } else if (ObjectUtil.exists(params.get("code_LIKE"))) {
                WHERE("code like '%' || #{code_LIKE} || '%'");
            }
            if (params.get("value") != null) {
                WHERE("value = #{value}");
            }
            if (ObjectUtil.exists(params.get("ORDER_BY"))) {
                ORDER_BY("${ORDER_BY}");
            }
        }}.toString();
    }

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return sql语句
     */
    public static String findPage(final Map<String, Object> params) {
        return new SQL() {{
            SELECT("id, code, value, regtime");
            FROM("sys_param");
            if (params.get("id") != null) {
                WHERE("id = #{id}");
            }
            if (params.get("code") != null) {
                WHERE("code = #{code}");
            } else if (ObjectUtil.exists(params.get("code_LIKE"))) {
                WHERE("code like '%' || #{code_LIKE} || '%'");
            }
            if (params.get("value") != null) {
                WHERE("value = #{value}");
            }
            if (ObjectUtil.exists(params.get("ORDER_BY"))) {
                ORDER_BY("${ORDER_BY}");
            }
            LIMIT("#{PAGE_OFFSET}, #{PAGE_SIZE}");
        }}.toString();
    }

    /**
     * 查询总数
     *
     * @param params 查询参数
     * @return sql语句
     */
    public static String count(final Map<String, Object> params) {
        return new SQL() {{
            SELECT("count(1)");
            FROM("sys_param");
            if (params.get("id") != null) {
                WHERE("id = #{id}");
            }
            if (params.get("code") != null) {
                WHERE("code = #{code}");
            } else if (ObjectUtil.exists(params.get("code_LIKE"))) {
                WHERE("code like '%' || #{code_LIKE} || '%'");
            }
            if (params.get("value") != null) {
                WHERE("value = #{value}");
            }
        }}.toString();
    }
}
