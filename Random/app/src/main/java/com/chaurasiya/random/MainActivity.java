package com.chaurasiya.random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtHeight;
    EditText edtWeight;
    AppCompatButton button;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHeight = findViewById(R.id.height);
        edtWeight = findViewById(R.id.weight);
        button= findViewById(R.id.button);
        result=findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int height = Integer.parseInt(edtHeight.getText().toString());
//                int weight = Integer.parseInt(edtWeight.getText().toString());

                result.setText(""+getBMIValue());
            }
        });

    }
    public float getBMIValue(){
                String heights = edtHeight.getText().toString();
                float height = Float.parseFloat(heights);
                String weights = edtWeight.getText().toString();
                float weight = Float.parseFloat(weights);
                float bmi = weight/((height*height)/10000);
          return bmi;
    }
}









