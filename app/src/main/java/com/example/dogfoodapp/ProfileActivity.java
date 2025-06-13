package com.example.dogfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private EditText nameEditText, emailEditText, phoneEditText, addressEditText;
    private Button saveButton;
    private TextView backTextView;

    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        addressEditText = findViewById(R.id.addressEditText);
        saveButton = findViewById(R.id.saveButton);
        backTextView = findViewById(R.id.backTextView);

        // Assuming userId is passed through intent
        userId = getIntent().getIntExtra("userId", -1);

        // Load user profile data
        loadUserProfile();

        saveButton.setOnClickListener(view -> saveUserProfile());
        backTextView.setOnClickListener(view -> finish());
    }

    private void loadUserProfile() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        Cursor cursor = dbHelper.getUserProfile(userId);
        if (cursor != null && cursor.moveToFirst()) {
            nameEditText.setText(cursor.getString(cursor.getColumnIndexOrThrow("username")));
            emailEditText.setText(cursor.getString(cursor.getColumnIndexOrThrow("email")));
            phoneEditText.setText(cursor.getString(cursor.getColumnIndexOrThrow("phone")));
            addressEditText.setText(cursor.getString(cursor.getColumnIndexOrThrow("address")));
            cursor.close();
        }
    }

    private void saveUserProfile() {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String address = addressEditText.getText().toString();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            boolean isUpdated = dbHelper.updateUserProfile(userId, name, email, phone, address);
            if (isUpdated) {
                Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Update failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
