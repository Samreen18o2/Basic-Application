package com.example.basicapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    EditText name, contact;
    Button insert, update, delete, view;
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);

        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "user-database")
                .allowMainThreadQueries()
                .build();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();

                UserDetails userDetails = new UserDetails(nameTXT, contactTXT);
                appDatabase.userDetailsDao().insert(userDetails);

                Toast.makeText(DatabaseActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();

                UserDetails userDetails = new UserDetails(nameTXT, contactTXT);
                appDatabase.userDetailsDao().update(userDetails);

                Toast.makeText(DatabaseActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                UserDetails userDetails = new UserDetails(nameTXT, "");

                appDatabase.userDetailsDao().delete(userDetails);

                Toast.makeText(DatabaseActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<UserDetails> userDetailsList = appDatabase.userDetailsDao().getAllUserDetails();

                if (userDetailsList.isEmpty()) {
                    Toast.makeText(DatabaseActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuilder buffer = new StringBuilder();
                for (UserDetails userDetails : userDetailsList) {
                    buffer.append("Name: ").append(userDetails.getName()).append("\n");
                    buffer.append("Contact: ").append(userDetails.getContact()).append("\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(DatabaseActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Student Records");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}
