package com.chaurasiya.widgetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox check1, check2;
    Button button1, button2, button3;
    RadioGroup radioGroup;
    Spinner spinner;
    TimePicker timePicker;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check1=findViewById(R.id.checkBox1);
        check2=findViewById(R.id.checkBox2);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                RadioButton radioButton = findViewById(checked);
                Toast.makeText(MainActivity.this, "Selected: "+radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        spinner = findViewById(R.id.spinner);
        String[] courses  = {"c++", "java", "python", "kotlin"};
        ArrayAdapter ad = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, courses);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(ad);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Selected: "+courses[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button1=findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.incrementProgressBy(10);

//                String currentTime = "Time: "+timePicker.getCurrentHour()+" : "+timePicker.getCurrentMinute();
//                Toast.makeText(getApplicationContext(), ""+currentTime, Toast.LENGTH_SHORT).show();
//
//                if(check1.isChecked()){
//                    Toast.makeText(getApplicationContext(), "Tomato is checked...", Toast.LENGTH_SHORT).show();
//                }else {
//
//                }
//                if(check2.isChecked()){
//                    Toast.makeText(MainActivity.this, "Cheese is checked...", Toast.LENGTH_SHORT).show();
//                }else {
//
//                }
            }
        });
        button2= findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePickerFrag = new TimePickerFragment();
                timePickerFrag.show(getSupportFragmentManager(), "Picked Time now:");
            }
        });
        button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePickerFragment = new DatePickerFragment();
                datePickerFragment.show(getSupportFragmentManager(), "Picked Date Now:");
            }
        });
        progressBar=findViewById(R.id.progressBar);
        progressBar.setProgress(0);


    }
}