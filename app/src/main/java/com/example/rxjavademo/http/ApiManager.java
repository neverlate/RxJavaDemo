package com.example.rxjavademo.http;


import com.example.rxjavademo.bean.BaseEntity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者: sand 时间: 2016/10/24 20:57
 * 邮箱:yaohaobing@163.com
 */

public class ApiManager {

    public static final String BASE_URL = "http://www.izaodao.com/Api/";
    private static final int DEFAULT_TIMEOUT = 6;
    private HttpApi mHttpApi;
    private volatile static ApiManager INSTANCE;


    private ApiManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mHttpApi = retrofit.create(HttpApi.class);
    }


    //获取单例
    public static ApiManager getInstance() {
        if (INSTANCE == null) {
            synchronized (ApiManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ApiManager();
                }
            }
        }
        return INSTANCE;
    }

    public void doHttpRequest(BaseEntity entity) {
        Observable observable = entity.getObservable(mHttpApi)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(entity);
        observable.subscribe(entity.getSubscriber());


    }

}
