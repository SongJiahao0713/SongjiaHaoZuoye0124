package com.bawei.songjiahao.zuoye0124.presenter;

import com.bawei.songjiahao.zuoye0124.base.mvp.BasePresenter;
import com.bawei.songjiahao.zuoye0124.contract.IContract;
import com.bawei.songjiahao.zuoye0124.model.Model;

import java.util.HashMap;

/**
 * 时间：2020/1/24 0024
 * 作者：Songjiahao
 * 类的作用：
 */
public class Presenter extends BasePresenter<Model, IContract.IView> implements IContract.IPresenter{


    @Override
    protected Model initModel() {
        return new Model();
    }

    @Override
    public void register(HashMap<String, String> params) {
        model.register(params, new IContract.IModel.ModelCallBack() {
            @Override
            public void success(Object object) {
                getView().success(object);
            }

            @Override
            public void failur(Throwable throwable) {

            }
        });
    }

    @Override
    public void login(HashMap<String, String> params) {
        model.login(params, new IContract.IModel.ModelCallBack() {
            @Override
            public void success(Object object) {
                getView().success(object);
            }

            @Override
            public void failur(Throwable throwable) {
                getView().failur(throwable);
            }
        });
    }

    @Override
    public void getCartData(String userId, String sessionId) {
        model.getCartData(userId, sessionId, new IContract.IModel.ModelCallBack() {
            @Override
            public void success(Object object) {
                getView().success(object);
            }

            @Override
            public void failur(Throwable throwable) {
                getView().failur(throwable);
            }
        });
    }
}

