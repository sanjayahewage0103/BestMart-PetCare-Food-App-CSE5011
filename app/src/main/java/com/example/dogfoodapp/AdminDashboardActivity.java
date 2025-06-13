package com.example.dogfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AdminDashboardActivity extends AppCompatActivity {

    private Button manageProductsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        manageProductsButton = findViewById(R.id.manageProductsButton);

        manageProductsButton.setOnClickListener(view -> {
            Intent intent = new Intent(AdminDashboardActivity.this, ManageProductsActivity.class);
            startActivity(intent);
        });
    }
}
