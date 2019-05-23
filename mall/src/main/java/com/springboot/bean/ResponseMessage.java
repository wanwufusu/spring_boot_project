package com.springboot.bean;


/**
 * 用于返回结果
 * by 杨渝挺
 */
public class ResponseMessage {
    private int errno;
    private String errmsg;
    private Object data;

    public ResponseMessage() {
    }

    public ResponseMessage(int errno, String errmsg, Object data) {
        this.errno = errno;
        this.errmsg = errmsg;
        this.data = data;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
