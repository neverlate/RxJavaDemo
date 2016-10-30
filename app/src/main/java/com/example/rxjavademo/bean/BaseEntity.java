package com.example.rxjavademo.bean;

import com.example.rxjavademo.http.HttpApi;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * 作者: sand 时间: 2016/10/24 21:03
 * 邮箱:yaohaobing@163.com
 */

public abstract class BaseEntity<T> implements Func1<BaseHttpResult<T>, T> {

    public abstract Observable getObservable(HttpApi api);
    public abstract Subscriber getSubscriber();

    @Override
    public T call(BaseHttpResult<T> tBaseHttpResult) {
        if (tBaseHttpResult.getResultRet()==0){

        }
        return tBaseHttpResult.getData();
    }

}
