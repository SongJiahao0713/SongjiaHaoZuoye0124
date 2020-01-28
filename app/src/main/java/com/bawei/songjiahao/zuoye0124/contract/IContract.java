package com.bawei.songjiahao.zuoye0124.contract;

import com.bawei.songjiahao.zuoye0124.base.mvp.IBaseModel;
import com.bawei.songjiahao.zuoye0124.base.mvp.IBaseView;

import java.util.HashMap;

/**
 * 时间：2020/1/24 0024
 * 作者：Songjiahao
 * 类的作用：
 */
public interface IContract {
    interface IModel extends IBaseModel {
        void register(HashMap<String ,String> params, ModelCallBack modelCallBack);
        void login(HashMap<String ,String> params,ModelCallBack modelCallBack);
        void getCartData(String userId,String sessionId,ModelCallBack modelCallBack);
        interface ModelCallBack{
            void success(Object object);
            void failur(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void success(Object object);
        void failur(Throwable throwable);
    }
    interface IPresenter{
        void register(HashMap<String ,String> params);
        void login(HashMap<String ,String> params);
        void getCartData(String userId, String sessionId);
    }

}
