package com.example.demo.Util;

import java.util.List;

public class Page<E> {
    private int currentPage;// 当前页数
    private int totalPage;// 总页数
    private int totalNumber;// 总记录数
    private List<E> list;// 数据集
    private BaseParam param;

    public Page() {
        super();
    }

    //根据总记录数自动计算出总页数
    public Page(int totalNumber) {
        super();
        this.totalNumber = totalNumber;
        totalPage = totalNumber % PageConstants.PAGE_SIZE == 0 ? totalNumber / PageConstants.PAGE_SIZE : totalNumber / PageConstants.PAGE_SIZE + 1;
    }

    public Page(int totalNumber, BaseParam baseParam) {
        super();
        this.param = baseParam;
        if (totalNumber > 0) {
            this.totalNumber = totalNumber;
            totalPage = totalNumber % PageConstants.PAGE_SIZE == 0 ? totalNumber / PageConstants.PAGE_SIZE : totalNumber / PageConstants.PAGE_SIZE + 1;
            this.currentPage = baseParam.getCurrentPage();
            int t = baseParam.getBeginLine() + PageConstants.PAGE_SIZE;
            Integer endLine = t > totalNumber ? totalNumber : t;
            param.setEndLine(endLine);
        } else {
            param.setBeginLine(0);
            param.setEndLine(0);
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public BaseParam getParam() {
        return param;
    }

    public void setParam(BaseParam param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalNumber=" + totalNumber +
                ", list=" + list +
                ", param=" + param.toString() +
                '}';
    }
}
