package com.springboot.bean;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Ruimingz
 * @create 2019/5/22
 * @since 1.0.0
 */

public class ObjectResponseVO<T> {
    private Result<T> data;
    private String errmsg;
    private int errno;

    public ObjectResponseVO() {
    }

    public Result<T> getData() {
        return data;
    }

    public void setData(Result<T> data) {
        this.data = data;
    }

    public ObjectResponseVO(Result<T> data, String errmsg, int errno) {
        this.data = data;
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    @Override
    public String toString() {
        return "ObjectResponseVO{" +
                "data=" + data +
                ", errmsg='" + errmsg + '\'' +
                ", errno='" + errno + '\'' +
                '}';
    }
}
