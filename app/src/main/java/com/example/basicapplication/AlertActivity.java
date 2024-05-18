package com.example.basicapplication;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
    }

    @Override
    public void onBackPressed() {
        // Create the object of AlertDialog.Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Set the message show for the Alert time
        builder.setMessage("Do you want to exit ?");
        // Set Alert Title
        builder.setTitle("Are u sure!");
        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(false);
        // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setPositiveButton("Yes", (dialog, which) -> {
            // When the user clicks yes button then the app will close
            finish();
        });
        // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setNegativeButton("No", (dialog, which) -> {
            // If the user clicks no, then the dialog box is canceled.
            dialog.cancel();
        });
        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        alertDialog.show();
    }
}

