package com.chaurasiya.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class Activity2 extends AppCompatActivity {
    TextView textView;
    Random rc = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        int luckNumber = rc.nextInt();
        textView=findViewById(R.id.textView3);
        textView.setText(""+luckNumber);
    }
}