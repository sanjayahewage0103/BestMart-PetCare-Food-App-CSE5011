package com.example.dogfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ManageProductsActivity extends AppCompatActivity {

    private Button addProductButton;
    private RecyclerView manageProductsRecyclerView;
    private ProductManagementAdapter productManagementAdapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_products);

        addProductButton = findViewById(R.id.addProductButton);
        manageProductsRecyclerView = findViewById(R.id.manageProductsRecyclerView);

        // Initialize the product list
        productList = new ArrayList<>();
        loadProducts();

        productManagementAdapter = new ProductManagementAdapter(this, productList);
        manageProductsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        manageProductsRecyclerView.setAdapter(productManagementAdapter);

        addProductButton.setOnClickListener(view -> {
            // Handle add product action
        });
    }

    private void loadProducts() {
        // Load sample products
        productList.add(new Product(1, "Dry Food 1", "Description 1", 10.0, "Dry Food", "Brand A", "Adult", R.drawable.sample_image));
        productList.add(new Product(2, "Dry Food 2", "Description 2", 12.0, "Dry Food", "Brand B", "Puppy", R.drawable.sample_image));
        productList.add(new Product(3, "Dry Food 3", "Description 3", 15.0, "Dry Food", "Brand C", "Senior", R.drawable.sample_image));
        // Add more products...
    }
}
