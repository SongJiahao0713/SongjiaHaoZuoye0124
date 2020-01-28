 package com.bawei.songjiahao.zuoye0124;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.songjiahao.zuoye0124.adapter.CartAdapter;
import com.bawei.songjiahao.zuoye0124.base.BaseActivity;
import com.bawei.songjiahao.zuoye0124.contract.IContract;
import com.bawei.songjiahao.zuoye0124.entity.CartEntity;
import com.bawei.songjiahao.zuoye0124.presenter.Presenter;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

 public class MainActivity extends BaseActivity<Presenter> implements IContract.IView {


     @BindView(R.id.iv_headerPic)
     ImageView ivHeaderPic;
     @BindView(R.id.rv)
     RecyclerView rv;
     @BindView(R.id.cb_checkbox_all)
     CheckBox cbCheckboxAll;
     @BindView(R.id.tv_totlePrice)
     TextView tvTotlePrice;
     private CartAdapter carAdapter;

     @Override
     protected Presenter initPresenter() {
         return new Presenter();
     }

     @Override
     protected void initView() {
         rv.setLayoutManager(new LinearLayoutManager(this));
     }

     @Override
     protected void initData() {
         String headlerPic = getIntent().getStringExtra("headlerPic");
         Glide.with(this).load(headlerPic).into(ivHeaderPic);
         presenter.getCartData("27977", "157968159790927977");


         cbCheckboxAll.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //判断是否选中
                 if (cbCheckboxAll.isChecked()) {
                     //选中状态
                     for (CartEntity.ResultBean resultBean : carAdapter.getList()) {
                         resultBean.setCartChecked(true);
                         for (CartEntity.ResultBean.ShoppingCartListBean shoppingCartListBean : resultBean.getShoppingCartList()) {
                             shoppingCartListBean.setProductChecked(true);
                         }
                     }
                     carAdapter.notifyDataSetChanged();
                 } else {
                     //未选中状态
                     for (CartEntity.ResultBean resultBean : carAdapter.getList()) {
                         resultBean.setCartChecked(false);
                         for (CartEntity.ResultBean.ShoppingCartListBean shoppingCartListBean : resultBean.getShoppingCartList()) {
                             shoppingCartListBean.setProductChecked(false);
                         }
                     }
                     carAdapter.notifyDataSetChanged();
                 }
                 totlePrice();
             }
         });

     }

     /**
      * 计算总价钱
      */

     public void totlePrice() {
         int num=0;
         for (CartEntity.ResultBean resultBean : carAdapter.getList()) {
             for (CartEntity.ResultBean.ShoppingCartListBean shoppingCartListBean : resultBean.getShoppingCartList()) {
                 if(shoppingCartListBean.getProductChecked()){
                     num+=shoppingCartListBean.getPrice();
                 }else{
                     tvTotlePrice.setText("￥ :0");
                 }
             }
             tvTotlePrice.setText("￥ :"+num);
         }
         for (CartEntity.ResultBean resultBean : carAdapter.getList()) {
             if(resultBean.getCartChecked()){
                 cbCheckboxAll.setChecked(true);
             }else{
                 cbCheckboxAll.setChecked(false);

             }
         }

     }

     @Override
     protected int bindLayoutid() {
         return R.layout.activity_main;
     }

     @Override
     public void success(Object object) {
         if (object instanceof CartEntity) {

             carAdapter = new CartAdapter(MainActivity.this, ((CartEntity) object).getResult());
             rv.setAdapter(carAdapter);

         }
     }

     @Override
     public void failur(Throwable throwable) {

     }
     public List<CartEntity.ResultBean> getData(){
         List<CartEntity.ResultBean> list=null;
         carAdapter.setCarAdapterCallBack(new CartAdapter.CarAdapterCallBack() {
             public void getCartList(List<CartEntity.ResultBean> list) {
                 list=list;
             }

         });
         return list;
     }

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         // TODO: add setContentView(...) invocation
         ButterKnife.bind(this);
     }
 }
