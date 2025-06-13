package com.example.dogfoodapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEmailEditText, passwordEditText;
    private Button loginButton;
    private TextView signUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEmailEditText = findViewById(R.id.usernameEmailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        signUpTextView = findViewById(R.id.signUpTextView);

        loginButton.setOnClickListener(view -> loginUser());
        signUpTextView.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });
    }

    private void loginUser() {
        String usernameEmail = usernameEmailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (usernameEmail.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            Cursor cursor = dbHelper.getUser(usernameEmail, password);
            if (cursor != null && cursor.moveToFirst()) {
                int userId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                boolean isAdmin = dbHelper.isAdmin(userId);
                Log.d("LoginActivity", "User found: " + userId + ", isAdmin: " + isAdmin);

                if (isAdmin) {
                    Intent intent = new Intent(LoginActivity.this, AdminDashboardActivity.class);
                    intent.putExtra("userId", userId);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(LoginActivity.this, UserDashboardActivity.class);
                    intent.putExtra("userId", userId);
                    startActivity(intent);
                }
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
