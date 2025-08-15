/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.type;

/**
 * 查询参数中的表达式类型
 * <br />格式：查询参数=字段名_表达式
 */
public enum MyBatisExpressionType {
    /**
     * 为null
     * <br />例{"email_NULL":true}
     */
    NULL,
    /**
     * 非null
     * <br />例{"email_NOT_NULL":true}
     */
    NOT_NULL,
    /**
     * 为null或空值
     * <br />例{"email_EMPTY":true}
     */
    EMPTY,
    /**
     * 非null和空值
     * <br />例{"email_NOT_EMPTY":true}
     */
    NOT_EMPTY,
    /**
     * 等于
     * <br />方法一：查询参数=字段名，默认为等于操作
     * <br />方法二：例{"name_EQ":"张三"}
     */
    EQ,
    /**
     * 不等于
     * <br />例{"name_NE":"张三"}
     */
    NE,
    /**
     * 大于
     * <br />例{"birthday_GT":"2020-01-01"}
     */
    GT,
    /**
     * 大于等于
     * <br />例{"birthday_GE":"2020-01-01"}
     */
    GE,
    /**
     * 小于
     * <br />例{"birthday_LT":"2020-01-01"}
     */
    LT,
    /**
     * 小于等于
     * <br />例{"birthday_LE":"2020-01-01"}
     */
    LE,
    /**
     * 包含，in操作
     * <br />格式：多个以","分隔，例{"birthday_IN":"2020-01-01,2021-02-02"}
     */
    IN,
    /**
     * 不包含，not in操作
     * <br />格式：多个以","分隔，例{"birthday_NOT_IN":"2020-01-01,2021-02-02"}
     */
    NOT_IN,
    /**
     * 模糊匹配，like操作
     * <br />例{"name_LIKE":"张三"}，相当于like "%张三%"
     */
    LIKE,
    /**
     * 模糊匹配，like操作，开头匹配
     * <br />例{"name_LIKE_BEGIN":"张三"}，相当于like "张三%"
     */
    LIKE_BEGIN,
    /**
     * 模糊匹配，like操作，结尾匹配
     * <br />例{"name_LIKE_END":"张三"}，相当于like "%张三"
     */
    LIKE_END,
    /**
     * 不模糊匹配，not like操作
     * <br />例{"name_NOT_LIKE":"张三"}，相当于not like "%张三%"
     */
    NOT_LIKE,
    /**
     * 不模糊匹配，not like操作，开头匹配
     * <br />例{"name_NOT_LIKE_BEGIN":"张三"}，相当于not like "张三%"
     */
    NOT_LIKE_BEGIN,
    /**
     * 不模糊匹配，not like操作，结尾匹配
     * <br />例{"name_NOT_LIKE_END":"张三"}，相当于not like "%张三"
     */
    NOT_LIKE_END,
}
