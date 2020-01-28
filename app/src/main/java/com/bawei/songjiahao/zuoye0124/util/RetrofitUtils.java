package com.bawei.songjiahao.zuoye0124.util;

import com.bawei.songjiahao.zuoye0124.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 时间：2020/1/24 0024
 * 作者：Songjiahao
 * 类的作用：
 */
public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private final Retrofit retrofit;

    private RetrofitUtils() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))//日志拦截器
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class){
                if(retrofitUtils==null){
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }
    public <T>T creatService(Class<T> classS){
        T t = retrofit.create(classS);
        return t;
    }
}

