package com.chaurasiya.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= findViewById(R.id.btn);
        Intent intentSecond = new Intent(MainActivity.this, SecondActivity.class);
        intentSecond.putExtra("Title", "Student Info");
        intentSecond.putExtra("Roll Number", 10);
        intentSecond.putExtra("Student Name", "Himanshu Chaurasiya");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentSecond);
//                setContentView(R.layout.activity_second); // this does not stack the layout but replaces with second layout;
            }
        });
    }
}