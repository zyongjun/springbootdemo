package com.joe.springbootdemo.model;

public class CommonResult {
    private static final String MSG_SUCCESS = "请求成功";
    private static final String MSG_FAIL = "服务器出错了";
    private static final int CODE_SUCCESS = 200;
    private static final int CODE_FAIL = 500;
    private int code;
    private String msg;
    private Object data;
    public CommonResult(){

    }

    public void setSuccess() {
        setCode(CODE_SUCCESS);
        setMsg(MSG_SUCCESS);
    }

    public void setFail() {
        setCode(CODE_FAIL);
        setMsg(MSG_FAIL);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
