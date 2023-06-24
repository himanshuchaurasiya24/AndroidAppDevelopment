package com.chaurasiya.unitcoverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView resultView, welcomeText;
    Button btn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeText = findViewById(R.id.unitConverterApp);
        resultView = findViewById(R.id.resultView);
        btn= findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText()!=null){
                    double kilosEntered = Double.parseDouble(editText.getText().toString());
                    convertToPounds(kilosEntered);
                    resultView.setText(""+convertToPounds(kilosEntered));
                }else{
                    Toast.makeText(MainActivity.this, "Please enter value", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public double convertToPounds(double kilos){
       double result= kilos*2.20462;
       return  result;
    }
}