package cuit.epoch.pymjl.result;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cuit.epoch.pymjl.constant.ResultEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PageResult<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = -3720998571176536865L;

    /**
     * 数据条数
     */
    private List<T> records = new ArrayList<T>();

    /**
     * 是否成功
     */
    private Boolean succeed;
    /**
     * 处理信息
     */
    private String message;

    /**
     * 一共有多少条数据
     */
    private long totalElements;

    /**
     * 当前页数
     */
    private long currentPage;

    /**
     * 一页数据最多有多少条数据
     */
    private long pageSize;

    /**
     * 一共有多少页
     */
    private long totalPages;

    /**
     * 当前页数有多少条数据
     */
    private int numberOfElements;

    public PageResult() {
    }

    /**
     * 构造方法，只用把原来的page类放进来即可
     *
     * @param page 查出来的分页对象
     */
    public PageResult(Page<T> page) {
        this.succeed = ResultEnum.OK.getSucceed();
        this.message = ResultEnum.OK.getMsg();
        this.records = page.getRecords();
        this.totalElements = page.getTotal();
        this.currentPage = page.getCurrent();
        this.pageSize = page.getSize();
        this.numberOfElements = page.getRecords().size();
        this.totalPages = page.getPages();
    }

    /**
     * 构造方法，只用把原来的page类放进来即可
     *
     * @param page    查出来的分页对象
     * @param message 处理信息
     */
    public PageResult(Page<T> page, String message) {
        this.succeed = ResultEnum.OK.getSucceed();
        this.message = message;
        this.records = page.getRecords();
        this.totalElements = page.getTotal();
        this.currentPage = page.getCurrent();
        this.pageSize = page.getSize();
        this.numberOfElements = page.getRecords().size();
        this.totalPages = page.getPages();
    }


    public Boolean getSucceed() {
        return succeed;
    }

    public void setSucceed(Boolean succeed) {
        this.succeed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * 是否有前一页
     *
     * @return boolean
     */
    public boolean hasPrevious() {
        return getCurrentPage() > 0;
    }

    /**
     * 是否有下一页
     *
     * @return boolean
     */
    public boolean hasNext() {
        return getCurrentPage() + 1 < getTotalPages();
    }

    /**
     * 获取总的页数
     *
     * @return long
     */
    public long getTotalPages() {
        return this.totalPages;
    }


    /**
     * 获取当前页的数据
     *
     * @return List<T>
     */
    public List<T> getRecords() {
        return Collections.unmodifiableList(records);
    }

    /**
     * 设置内容
     *
     * @param records 内容
     */
    public void setRecords(List<T> records) {
        this.records = records;
    }

    /**
     * 是否有内容
     *
     * @return boolean
     */
    public boolean hasRecords() {
        return getNumberOfElements() > 0;
    }

    /**
     * 获取单页大小
     */
    public Long getPageSize() {
        return pageSize;
    }

    /**
     * 设置单页大小
     */
    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取全部元素数目
     */
    public long getTotalElements() {
        return totalElements;
    }

    /**
     * 设置全部元素数目
     */
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }


    /**
     * 获取当前页号
     */
    public Long getCurrentPage() {
        return currentPage;
    }

    /**
     * 设置当前页号
     */
    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }


    /**
     * 获取单页元素数目
     */
    public int getNumberOfElements() {
        return numberOfElements;
    }

    /**
     * 设置单页元素数目
     */
    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }


    /**
     * 迭代器
     */
    @Override
    public Iterator<T> iterator() {
        return getRecords().iterator();
    }
}