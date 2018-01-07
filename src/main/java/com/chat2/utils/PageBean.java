package com.chat2.utils;

import java.util.Arrays;
import java.util.List;

public class PageBean<T> {
    //总记录数，从数据库中查出来的列表的总记录数
    private long total;
    //每页的最多显示的数量
    private int pageSize;
    //总页数
    private int pages;
    //当前页码
    private int pageNum;
    //这页显示的数据组成的列表
    private List<T> list;
    //当前页显示的数量，即list的大小
    private int size;

    //以下为导航页的计算

    //导航页码总数
    private int navigatePages;
    //第一页
    private int firstPage;
    //前一页
    private int prePage;
    //下一页
    private int nextPage;
    //最后一页
    private int lastPage;

    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;
    //是否有前一页
    private boolean hasPreviousPage = false;
    //是否有下一页
    private boolean hasNextPage = false;
    //所有导航页号
    private int[] navigatepageNums;

    public PageBean(List<T> list, int pageNum, int pageSize, int navigatePages) {
        this.total = list.size();//总记录数
        this.pageSize = pageSize;//每页最多记录数
        this.pages = calcPages(list, pageSize);//总页数
        this.pageNum = pageNum;//页码
        this.list = calcList(list, pageNum, pageSize);//这页显示的数据组成的列表
        this.size = this.list.size();//当前页显示的数量，即list的大小

        this.navigatePages = navigatePages;
        //设置导航页
        calcNavigatepageNums();
        //设置前后页，第一页，最后一页
        calcPage();
        //判断页面是否到达边界
        judgePageBoudary();

    }

    //计算总页数
    public int calcPages(List<T> list, int pageSize) {
        return (int) Math.ceil((double) list.size() / (double) pageSize);//计算总页数
    }

    //计算返回的列表
    public List<T> calcList(List<T> list, int pageNum, int pageSize) {
        if (pageNum == 1) {//当页码是第一页时
            return list.subList(0, pageSize - 1);
        } else if (pageNum == calcPages(list, pageSize)) {//当页码是最后一页时
            return list.subList((pageNum - 1) * pageSize, list.size());
        } else {//页码在中间时
            return list.subList((pageNum - 1) * pageSize, pageNum * pageSize);
        }
    }

    /**
     * 计算导航页
     */
    private void calcNavigatepageNums() {
        //当总页数小于或等于导航页码数时
        if (pages <= navigatePages) {
            navigatepageNums = new int[pages];
            for (int i = 0; i < pages; i++) {
                navigatepageNums[i] = i + 1;
            }
        } else { //当总页数大于导航页码数时
            navigatepageNums = new int[navigatePages];
            int startNum = pageNum - navigatePages / 2;
            int endNum = pageNum + navigatePages / 2;

            if (startNum < 1) {//当计算出的第一个导航页数小于1时，导航页从1开始
                startNum = 1;//设置第一个navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > pages) {//当计算出的最后一个导航页数大于总页数时，导航页从总页数结尾
                endNum = pages;//设置最后一个navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            } else { //所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            }
        }
    }

    /**
     * 计算前后页，第一页，最后一页
     */
    private void calcPage() {
        if (navigatepageNums != null && navigatepageNums.length > 0) {
            firstPage = navigatepageNums[0];
            lastPage = navigatepageNums[navigatepageNums.length - 1];
            if (pageNum > 1) {
                prePage = pageNum - 1;
            }
            if (pageNum < pages) {
                nextPage = pageNum + 1;
            }
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages;
        hasPreviousPage = pageNum > 1;
        hasNextPage = pageNum < pages;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    public void setNavigatepageNums(int[] navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", pageSize=" + pageSize +
                ", pages=" + pages +
                ", pageNum=" + pageNum +
                ", list=" + list +
                ", size=" + size +
                ", navigatePages=" + navigatePages +
                ", firstPage=" + firstPage +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", lastPage=" + lastPage +
                ", isFirstPage=" + isFirstPage +
                ", isLastPage=" + isLastPage +
                ", hasPreviousPage=" + hasPreviousPage +
                ", hasNextPage=" + hasNextPage +
                ", navigatepageNums=" + Arrays.toString(navigatepageNums) +
                '}';
    }
}
