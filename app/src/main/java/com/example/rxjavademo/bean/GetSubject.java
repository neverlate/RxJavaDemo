package com.example.rxjavademo.bean;

import com.example.rxjavademo.http.HttpApi;

import rx.Observable;
import rx.Subscriber;

/**
 * 作者: sand 时间: 2016/10/24 21:12
 * 邮箱:yaohaobing@163.com
 */

public class GetSubject extends BaseEntity{
    private Subscriber mSubscriber;
    private boolean all;

    public GetSubject(Subscriber subscriber, boolean all) {
        mSubscriber = subscriber;
        this.all = all;
    }

    @Override
    public Observable getObservable(HttpApi api) {
        return api.getSubjects(true);
    }

    @Override
    public Subscriber getSubscriber() {
        return mSubscriber;
    }


}
