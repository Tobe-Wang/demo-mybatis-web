/*
 * Copyright (c) 2025. Tobe Wang
 */

package cn.zhaofd.demomybatisweb.core.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 分页结果集
 *
 * @param <T> DTO数据传输对象
 */
public class PageResult<T extends Serializable> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 当前页码(第1页=1)
     */
    private Integer pageNumber;
    /**
     * 当前页记录数
     */
    private Integer pageSize;
    /**
     * 当前页数据列表
     */
    private List<T> pageData;
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 构造方法
     *
     * @param pageNumber 当前页码(第1页=1)
     * @param pageSize   当前页记录数
     * @param pageData   当前页数据列表
     * @param total      总记录数
     * @param totalPages 总页数
     */
    public PageResult(Integer pageNumber, Integer pageSize, List<T> pageData, Long total, Integer totalPages) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.pageData = pageData;
        this.total = total;
        this.totalPages = totalPages;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
