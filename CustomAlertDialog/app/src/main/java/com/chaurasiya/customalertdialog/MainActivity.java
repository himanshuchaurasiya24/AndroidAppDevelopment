package com.chaurasiya.customalertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCustomDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCustomDialog = findViewById(R.id.btnCustomAlertDialog);
        btnCustomDialog.setOnClickListener(view -> {
            Dialog customDialog = new Dialog(MainActivity.this);
            customDialog.setContentView(R.layout.custom_dialog_layout);
            customDialog.setCancelable(false); // to prevent it from being dismissed after being tapped anywhere else on the screen;
            Button btnCustomOkay = customDialog.findViewById(R.id.btnOkay);
            btnCustomOkay.setOnClickListener(v -> customDialog.dismiss());
            customDialog.show();
        });

    }
}