package com.example.dogfoodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductManagementAdapter extends RecyclerView.Adapter<ProductManagementAdapter.ProductManagementViewHolder> {

    private Context context;
    private List<Product> productList;

    public ProductManagementAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public ProductManagementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_manage_product, parent, false);
        return new ProductManagementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductManagementViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productNameTextView.setText(product.getName());
        holder.productDescriptionTextView.setText(product.getDescription());
        holder.productPriceTextView.setText(String.format("$%.2f", product.getPrice()));
        holder.productImageView.setImageResource(product.getImageResourceId());

        holder.editButton.setOnClickListener(view -> {
            // Handle edit product action
        });

        holder.deleteButton.setOnClickListener(view -> {
            // Handle delete product action
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductManagementViewHolder extends RecyclerView.ViewHolder {
        TextView productNameTextView;
        TextView productDescriptionTextView;
        TextView productPriceTextView;
        ImageView productImageView;
        Button editButton;
        Button deleteButton;

        public ProductManagementViewHolder(View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
            productDescriptionTextView = itemView.findViewById(R.id.productDescriptionTextView);
            productPriceTextView = itemView.findViewById(R.id.productPriceTextView);
            productImageView = itemView.findViewById(R.id.productImageView);
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
