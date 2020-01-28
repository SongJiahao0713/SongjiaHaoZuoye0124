package com.bawei.songjiahao.zuoye0124.api;
import com.bawei.songjiahao.zuoye0124.entity.LoginEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 时间：2020/1/24 0024
 * 作者：Songjiahao
 * 类的作用：
 */
public interface LoginApiService {
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginEntity> login(@FieldMap HashMap<String, String> params);
}
