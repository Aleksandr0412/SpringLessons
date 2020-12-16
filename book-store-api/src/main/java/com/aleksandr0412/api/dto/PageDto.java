package com.aleksandr0412.api.dto;


import java.util.List;

public class PageDto<T> {

    List<T> data;

    long total;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public PageDto(List<T> data, long total) {
        this.data = data;
        this.total = total;
    }

    public PageDto() {
    }
}
