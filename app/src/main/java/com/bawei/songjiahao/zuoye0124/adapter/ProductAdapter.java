package com.bawei.songjiahao.zuoye0124.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.songjiahao.zuoye0124.MainActivity;
import com.bawei.songjiahao.zuoye0124.R;
import com.bawei.songjiahao.zuoye0124.entity.CartEntity;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间：2020/1/23 0023
 * 作者：Songjiahao
 * 类的作用：
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    public Context context;
    public List<CartEntity.ResultBean.ShoppingCartListBean> list;


    public ProductAdapter(Context context, List<CartEntity.ResultBean.ShoppingCartListBean> list) {
        this.context = context;
        this.list = list;
    }

    public List<CartEntity.ResultBean.ShoppingCartListBean> getList() {
        return list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(View.inflate(context, R.layout.product_item_layout, null));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MainActivity mainActivity= (MainActivity) context;
        if(list.get(position).getProductChecked()){
            holder.cbProduct.setChecked(true);
        }else{
            holder.cbProduct.setChecked(false);
        }

        holder.tvProductName.setText(list.get(position).getCommodityName());
        holder.tvPrice.setText("￥"+list.get(position).getPrice());
        Glide.with(context).load(list.get(position).getPic()).into(holder.image);
        List<CartEntity.ResultBean> data = mainActivity.getData();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cb_product)
        CheckBox cbProduct;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.tv_productName)
        TextView tvProductName;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

