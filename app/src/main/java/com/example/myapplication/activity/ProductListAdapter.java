package com.example.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Interfaces.ProductListenerInterface;
import com.example.myapplication.R;
import com.example.myapplication.RealmClasses.ProductsRealm;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    private Context context;
    private List<ProductsRealm> productsRealm;
    private ProductListenerInterface productListenerInterface;


    public ProductListAdapter(Context context, List<ProductsRealm> productsRealm, ProductListenerInterface productListenerInterface) {
        this.context = context;
        this.productsRealm = productsRealm;
        this.productListenerInterface = productListenerInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recyclerview_product_details, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final ProductsRealm productRealm = productsRealm.get(holder.getAdapterPosition());
        holder.txtProductName.setText(productRealm.getProductName());
        holder.txtProductTax.setText(productRealm.getProductTaxRate()+"%");
        holder.txtProductPrice.setText("Rs "+productRealm.getProductPrice());

        holder.imgProductAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productListenerInterface.onProductAdd(productRealm);
            }
        });

       /* holder.lnrUserDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, userDetails.class);
                intent.putExtra("user_UUId", userRealm.getUserUUID());
                context.startActivity(intent);
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               userdelete.deleteUser(holder.getAdapterPosition(), userRealm.getUserUUID());
            }
        });

        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,updateuserlist.class);
                intent.putExtra("user_UUId", userRealm.getUserUUID());
                intent.putExtra("username" ,userRealm.getUserName());
                intent.putExtra("usermobile", userRealm.getUserMobileNumber());
                intent.putExtra("useremail", userRealm.getUserEmailId());
                context.startActivity(intent);
            }
        });*/


    }

    public void deleteUser(int position) {
        productsRealm.remove(position);
        notifyItemRemoved(position);
    }


    @Override
    public int getItemCount() {
        return productsRealm.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView txtProductName, txtProductTax, txtProductPrice;
        public AppCompatImageView imgProductAdd;


        public ViewHolder(View itemView) {
            super(itemView);
            this.txtProductName = (AppCompatTextView) itemView.findViewById(R.id.txt_product_name);
            this.imgProductAdd = (AppCompatImageView) itemView.findViewById(R.id.img_product_add);
            this.txtProductTax = (AppCompatTextView) itemView.findViewById(R.id.txt_product_tax);
            this.txtProductPrice = (AppCompatTextView) itemView.findViewById(R.id.txt_product_price);

        }
    }
}
