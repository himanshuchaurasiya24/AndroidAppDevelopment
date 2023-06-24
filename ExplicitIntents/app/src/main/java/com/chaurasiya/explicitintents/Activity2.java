package com.chaurasiya.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent intent2 = getIntent();
        String k = intent2.getStringExtra("id");
        Toast.makeText(this, "we passed: "+k, Toast.LENGTH_SHORT).show();
    }
}