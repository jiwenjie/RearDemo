package com.kuky.base.kotlin.demo.test.api;

import com.kuky.base.kotlin.demo.test.bean.UserInfo;
import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * author:Jiwenjie
 * email:278630464@qq.com
 * time:2018/12/13
 * desc:
 * version:1.0
 */
public interface ApiService {
    @POST("user/login")
    Observable<UserInfo> getLoginUser(@Query("username") String username, @Query("password") String password);
}
