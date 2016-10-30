package com.example.rxjavademo.bean;

/**
 * 作者: sand 时间: 2016/10/24 20:58
 * 邮箱:yaohaobing@163.com
 */

public class BaseHttpResult<T> {

    private int resultRet;
    private String message;
    private T data;

    public BaseHttpResult() {
    }

    public int getResultRet() {
        return resultRet;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setResultRet(int resultRet) {
        this.resultRet = resultRet;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseHttpResult{" +
                "resultRet=" + resultRet +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
