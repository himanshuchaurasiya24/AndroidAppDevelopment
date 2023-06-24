package com.chaurasiya.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intentSecond = getIntent();
        String title = intentSecond.getStringExtra("Title");
        String studentName = intentSecond.getStringExtra("Student Name");
        int rollNumber = intentSecond.getIntExtra("Roll Number", 0);
        TextView txtInfo;
        txtInfo= findViewById(R.id.txtInfo);
        txtInfo.setText("Roll Number "+rollNumber+" "+studentName);
        getSupportActionBar().setTitle(title);

    }
}