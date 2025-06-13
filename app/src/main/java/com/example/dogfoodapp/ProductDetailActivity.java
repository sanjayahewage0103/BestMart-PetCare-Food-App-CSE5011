package com.example.dogfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView productImageView;
    private TextView productNameTextView;
    private TextView productDescriptionTextView;
    private TextView productPriceTextView;
    private Button addToCartButton;
    private RecyclerView reviewsRecyclerView;
    private ReviewAdapter reviewAdapter;
    private List<Review> reviewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        productImageView = findViewById(R.id.productImageView);
        productNameTextView = findViewById(R.id.productNameTextView);
        productDescriptionTextView = findViewById(R.id.productDescriptionTextView);
        productPriceTextView = findViewById(R.id.productPriceTextView);
        addToCartButton = findViewById(R.id.addToCartButton);
        reviewsRecyclerView = findViewById(R.id.reviewsRecyclerView);

        // Load product details
        Product product = (Product) getIntent().getSerializableExtra("product");
        if (product != null) {
            productImageView.setImageResource(product.getImageResourceId());
            productNameTextView.setText(product.getName());
            productDescriptionTextView.setText(product.getDescription());
            productPriceTextView.setText(String.format("$%.2f", product.getPrice()));
        }

        // Initialize review list and adapter
        reviewList = new ArrayList<>();
        // Load sample reviews
        loadReviews();
        reviewAdapter = new ReviewAdapter(this, reviewList);
        reviewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        reviewsRecyclerView.setAdapter(reviewAdapter);
    }

    private void loadReviews() {
        // Load sample reviews
        reviewList.add(new Review("User1", "Great product!", 5));
        reviewList.add(new Review("User2", "My dog loves it.", 4));
        reviewList.add(new Review("User3", "Good quality.", 5));
        // Add more reviews...
    }
}
