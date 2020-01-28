package com.bawei.songjiahao.zuoye0124.model;

import com.bawei.songjiahao.zuoye0124.api.CarApiService;
import com.bawei.songjiahao.zuoye0124.api.LoginApiService;
import com.bawei.songjiahao.zuoye0124.api.RegisterApiService;
import com.bawei.songjiahao.zuoye0124.contract.IContract;
import com.bawei.songjiahao.zuoye0124.entity.CartEntity;
import com.bawei.songjiahao.zuoye0124.entity.LoginEntity;
import com.bawei.songjiahao.zuoye0124.entity.RegisterEntity;
import com.bawei.songjiahao.zuoye0124.util.RetrofitUtils;

import java.util.HashMap;
import io.reactivex.functions.Consumer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间：2020/1/24 0024
 * 作者：Songjiahao
 * 类的作用：
 */
public class Model implements IContract.IModel {
    /**
     * 注册
     * @param params
     * @param modelCallBack
     */
    @Override
    public void register(HashMap<String, String> params, ModelCallBack modelCallBack) {
        RetrofitUtils.getInstance().creatService(RegisterApiService.class)
                .register(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterEntity>() {
                    /**
                     * 成功
                     * @param registerEntity
                     * @throws Exception
                     */
                    @Override
                    public void accept(RegisterEntity registerEntity) throws Exception {
                        modelCallBack.success(registerEntity);
                    }
                }, new Consumer<Throwable>() {
                    /**
                     * 失败
                     * @param throwable
                     * @throws Exception
                     */
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        modelCallBack.failur(throwable);
                    }
                });
    }

    /**
     * 登陆
     * @param params
     * @param modelCallBack
     */
    @Override
    public void login(HashMap<String, String> params, ModelCallBack modelCallBack) {
        RetrofitUtils.getInstance().creatService(LoginApiService.class)
                .login(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginEntity>() {
                    @Override
                    public void accept(LoginEntity loginEntity) throws Exception {
                        modelCallBack.success(loginEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        modelCallBack.failur(throwable);
                    }
                });
    }

    @Override
    public void getCartData(String userId, String sessionId, ModelCallBack modelCallBack) {
        RetrofitUtils.getInstance().creatService(CarApiService.class)
                .getData(userId,sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CartEntity>() {
                    @Override
                    public void accept(CartEntity carEntity) throws Exception {
                        modelCallBack.success(carEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        modelCallBack.failur(throwable);
                    }
                });
    }
}

