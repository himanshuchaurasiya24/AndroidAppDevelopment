package com.chaurasiya.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    EditText edtHeight;
    EditText edtWeight;
    AppCompatButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHeight = findViewById(R.id.edtHeightInCms);
        edtWeight = findViewById(R.id.edtWeightInKgs);
        btn = findViewById(R.id.button);
        result = findViewById(R.id.result);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(""+calculate());
            }
        });

    }
    float calculate(){
        float height = Integer.parseInt(String.valueOf(edtHeight.getText()));
        float weight = Integer.parseInt(String.valueOf(edtWeight.getText()));
        float heightSquare = (height*height)/10000;
        return weight/heightSquare;
    }

}




















