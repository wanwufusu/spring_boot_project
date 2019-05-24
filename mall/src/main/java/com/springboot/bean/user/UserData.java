package com.springboot.bean.user;

import java.util.List;

public class UserData<T> {
    private int total;
    private List<T> items;

    public UserData() {
    }

    public UserData(int total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItem(List<T> item) {
        this.items = items;
    }
}
