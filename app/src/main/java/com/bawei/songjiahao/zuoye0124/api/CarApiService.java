package com.bawei.songjiahao.zuoye0124.api;


import com.bawei.songjiahao.zuoye0124.entity.CartEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * 时间：2020/1/24 0024
 * 作者：Songjiahao
 * 类的作用：
 */
public interface CarApiService {
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<CartEntity> getData(@Header("userId") String userId, @Header("sessionId") String sessionId);
}
