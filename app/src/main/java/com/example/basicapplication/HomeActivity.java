package com.example.basicapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnAlert = findViewById(R.id.btnAlert);
        Button btnNotification = findViewById(R.id.btnNotification);
        Button btnSharedPreferences = findViewById(R.id.btnSharedPreferences);
        Spinner spinner = findViewById(R.id.spinner);
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextAge = findViewById(R.id.editTextAge);
        Button btnSubmitForm = findViewById(R.id.btnSubmitForm);

        // Sample data for the spinner
        String[] spinnerData = {"Option 1", "Option 2", "Option 3"};

        // Create an ArrayAdapter using the sample data
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerData);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Button click listeners
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AlertActivity.class));
            }
        });

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, NotificationActivity.class));
            }
        });

        btnSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, SharedPreferencesActivity.class));
            }
        });

        btnSubmitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click for the Submit Form button
                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();

                // Do something with the user-inputted data, for example, display a Toast
                Toast.makeText(HomeActivity.this, "Name: " + name + ", Age: " + age, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void openRecyclerViewActivity(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }

    public void openFragmentsActivity(View view) {
        Intent intent = new Intent(this, FragmentsActivity.class);
        startActivity(intent);
    }

    public void openCalculatorActivity(View view) {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }

    public void openDatabaseActivity(View view) {
        Intent intent = new Intent(this, DatabaseActivity.class);
        startActivity(intent);
    }
}

