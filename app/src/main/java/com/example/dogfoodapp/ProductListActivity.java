package com.example.dogfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        productRecyclerView = findViewById(R.id.productRecyclerView);
        productList = new ArrayList<>();
        loadProducts();

        productAdapter = new ProductAdapter(this, productList);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productRecyclerView.setAdapter(productAdapter);
    }

    private void loadProducts() {
        // Load sample products
        productList.add(new Product(1, "Dog Food Premium", "High quality dog food for adult dogs", 10.0, "Food", "Brand A", "Adult", R.drawable.product_image1));
        productList.add(new Product(2, "Dog Food Puppy", "Nutritious dog food for puppies", 20.0, "Food", "Brand B", "Puppy", R.drawable.product_image2));
        productList.add(new Product(3, "Dog Treats", "Delicious dog treats", 30.0, "Treats", "Brand C", "All Ages", R.drawable.product_image3));
        productList.add(new Product(4, "Dog Toy", "Durable dog toy", 40.0, "Toys", "Brand D", "All Ages", R.drawable.product_image4));
        productList.add(new Product(5, "Dog Bed", "Comfortable dog bed", 50.0, "Accessories", "Brand E", "All Ages", R.drawable.product_image5));
    }
}
