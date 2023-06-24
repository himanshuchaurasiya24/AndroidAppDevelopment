package com.chaurasiya.bmibyyoutube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtHeightFt, edtHeightIn, edtWeight;
        TextView txtResult;
        AppCompatButton btnCalculate;
        LinearLayout layout;
        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        layout = findViewById(R.id.layout);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = Integer.parseInt(edtWeight.getText().toString());
                int heightFt;
                int heightIn;
                if(edtHeightIn.getText().toString().equals("")){
                    heightIn=0;
                }else{
                   heightIn = Integer.parseInt(edtHeightIn.getText().toString());
                }
                if(edtHeightFt.getText().toString().equals("")){
                    heightFt=0;
                }else{
                   heightFt = Integer.parseInt(edtHeightIn.getText().toString());
                }


                int totalIn = heightFt*12 + heightIn;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;
                double bmi = weight/(totalM*totalM);
                if(bmi>25){
                    txtResult.setText("You are Over Weight");
                    layout.setBackgroundColor(getResources().getColor(R.color.color_overweight));
                }else if(bmi<18){
                    txtResult.setText("You are Under Weight");
                    layout.setBackgroundColor(getResources().getColor(R.color.color_underweight));
                }else{
                    txtResult.setText("You are Fit");
                    layout.setBackgroundColor(getResources().getColor(R.color.color_fit));
                }
            }
        });
    }
}





















