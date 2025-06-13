package com.example.dogfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class UserDashboardActivity extends AppCompatActivity {

    private Button profileButton, productCatalogButton;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        profileButton = findViewById(R.id.profileButton);
        productCatalogButton = findViewById(R.id.productCatalogButton);

        // Assuming userId is passed through intent
        userId = getIntent().getIntExtra("userId", -1);

        profileButton.setOnClickListener(view -> {
            Intent intent = new Intent(UserDashboardActivity.this, ProfileActivity.class);
            // Pass userId through intent
            intent.putExtra("userId", userId);
            startActivity(intent);
        });

        productCatalogButton.setOnClickListener(view -> {
            Intent intent = new Intent(UserDashboardActivity.this, ProductCatalogActivity.class);
            startActivity(intent);
        });
    }
}
