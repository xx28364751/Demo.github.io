package com.example.demo.Util;

import java.io.Serializable;

public class BaseParam implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private Integer endLine;// 结束行
    private Integer currentPage = 1;// 当前页
    private Integer pageSize = PageConstants.PAGE_SIZE;
    private Integer beginLine = (currentPage - 1) * pageSize;// 起始行

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.beginLine = (currentPage - 1) * pageSize;
        this.currentPage = currentPage == null ? 1 : currentPage;
    }

    public Integer getBeginLine() {
        beginLine = (currentPage - 1) * pageSize;
        return beginLine;
    }

    public void setBeginLine(Integer beginLine) {
        if (null == beginLine) {
            beginLine = (currentPage - 1) * pageSize;
        }
        this.beginLine = beginLine;
    }

    public Integer getEndLine() {
        return endLine;
    }

    public void setEndLine(Integer endLine) {
        this.endLine = endLine;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize != null)
            this.pageSize = pageSize;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "BaseParam{" +
                "endLine=" + endLine +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", beginLine=" + beginLine +
                '}';
    }
}
