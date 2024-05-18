package com.example.basicapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private TextView tvLoginOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvLoginOption = findViewById(R.id.tvLoginOption);

        Button btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                // Perform basic signup validation (you should implement server-based validation)
                if (isValidSignup(username, email, password)) {
                    // Signup successful, navigate to LoginActivity
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    // Signup failed, show an error message
                    Toast.makeText(SignupActivity.this, "Invalid input or user already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listener for "Already have an account? Log in here."
        tvLoginOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event, navigate to LoginActivity
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // Basic signup validation (replace with server-based validation)
    private boolean isValidSignup(String username, String email, String password) {
        // Example validation: Check if fields are not empty and username is unique
        return !username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !username.equals("demo");
    }
}
