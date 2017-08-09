package com.example.bravo.vo;

public class VO<T> {
    String msg;
    T data;

    public VO(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public VO(T data) {
        this.msg = "success";
        this.data = data;
        if(data==null)this.msg = "fail";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
