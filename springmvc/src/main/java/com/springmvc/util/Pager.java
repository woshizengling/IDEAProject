package com.springmvc.util;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("all")
public class Pager<T> implements Serializable {
    private Integer total;
    private List<T> rows;

    public Pager() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
