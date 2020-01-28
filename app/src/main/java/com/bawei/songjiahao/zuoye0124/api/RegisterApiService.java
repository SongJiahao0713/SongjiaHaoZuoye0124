package com.bawei.songjiahao.zuoye0124.api;

/**
 * 时间：2020/1/24 0024
 * 作者：Songjiahao
 * 类的作用：
 */
import com.bawei.songjiahao.zuoye0124.entity.RegisterEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface RegisterApiService {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegisterEntity> register(@FieldMap HashMap<String ,String> params);
}