package com.bawei.songjiahao.zuoye0124.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.songjiahao.zuoye0124.base.mvp.BasePresenter;
import com.bawei.songjiahao.zuoye0124.base.mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 时间：2020/1/24 0024
 * 作者：Songjiahao
 * 类的作用：
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    public P presenter;
    private Unbinder bind;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutid());
        presenter=initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        bind = ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int bindLayoutid();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deatch();

        }
        if (bind != null) {
            bind.unbind();
        }
    }
}
