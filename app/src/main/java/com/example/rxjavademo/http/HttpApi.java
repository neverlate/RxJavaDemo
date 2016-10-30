package com.example.rxjavademo.http;

import com.example.rxjavademo.bean.BaseHttpResult;
import com.example.rxjavademo.bean.Subject;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 作者: sand 时间: 2016/10/24 20:58
 * 邮箱:yaohaobing@163.com
 */

public interface HttpApi  {

    @POST("AppFiftyToneGraph/videoLink")
    Observable<BaseHttpResult<List<Subject>>> getSubjects(@Body boolean once);

}
