package com.chaurasiya.randomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Activity2 extends AppCompatActivity {
TextView textView, randomNumber;
Button shareButton;
Random rc = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textView = findViewById(R.id.textView);
        randomNumber = findViewById(R.id.textView2);
        shareButton = findViewById(R.id.shareButton);
        int rNumber = rc.nextInt();
        Intent intent2 = getIntent();
        String userName = intent2.getStringExtra("name");
        randomNumber.setText(""+rNumber);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName, rNumber);
            }
        });
    }
    public void shareData(String userName, int randomNumber){
        Intent intent2 = new Intent(Intent.ACTION_SEND);
        intent2.setType("text/plain");
        String  number = String.valueOf(randomNumber);
        intent2.putExtra(Intent.EXTRA_SUBJECT, userName);
        intent2.putExtra(Intent.EXTRA_TEXT, userName+ " got his luck number: "+number);
        startActivity(Intent.createChooser(intent2, "Choose a Platform"));
    }
}