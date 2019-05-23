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

public class ResponseVO<T> {
    private T data;
    private String errmsg;
    private int errno;

    public ResponseVO() {
    }

    public ResponseVO(T data, String errmsg, int errno) {
        this.data = data;
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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
        return "ResponseVO{" +
                "data=" + data +
                ", errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                '}';
    }

    public void setSuccessMsg(){
        this.errmsg = "成功";
        this.errno = 0;
    }
}
