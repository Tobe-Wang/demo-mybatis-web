/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.type;

/**
 * 查询参数中的关键字类型
 * <br />格式：查询参数=关键字
 */
public enum MyBatisParamType {
    /**
     * 排序
     * <br />例{"ORDER_BY":"birthday, id desc, name asc"}
     */
    ORDER_BY,
    /**
     * 分页页码(第1页=1)
     * <br />例{"PAGE_NUMBER":1}
     */
    PAGE_NUMBER,
    /**
     * 分页大小
     * <br />例{"PAGE_SIZE":20}
     */
    PAGE_SIZE,
    /**
     * 分页偏移量(第1行记录偏移量为0)
     * <br />例{"PAGE_OFFSET":0}
     */
    PAGE_OFFSET,
    /**
     * 去重
     * <br />例{"DISTINCT":true}
     */
    DISTINCT,
}
