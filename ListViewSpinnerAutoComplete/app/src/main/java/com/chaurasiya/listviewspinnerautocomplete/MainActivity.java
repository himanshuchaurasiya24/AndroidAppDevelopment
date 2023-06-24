package com.chaurasiya.listviewspinnerautocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
Spinner spinner;
ArrayList <String> namesArrayList = new ArrayList<>();
ArrayList<String> arrayId = new ArrayList<>();
AutoCompleteTextView autoCompleteTextView;
ArrayList<String> arrayLanguage = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner= findViewById(R.id.spinner);
        listView= findViewById(R.id.listView);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        namesArrayList.add("Ram");
        namesArrayList.add("Raman");
        namesArrayList.add("Ramanujan");
        namesArrayList.add("Rameez");
        namesArrayList.add("Ramjan");
        namesArrayList.add("Ram");
        namesArrayList.add("Raman");
        namesArrayList.add("Ramanujan");
        namesArrayList.add("Rameez");
        namesArrayList.add("Ramjan");
        namesArrayList.add("Ram");
        namesArrayList.add("Raman");
        namesArrayList.add("Ramanujan");
        namesArrayList.add("Rameez");
        namesArrayList.add("Ramjan");
        namesArrayList.add("Ram");
        namesArrayList.add("Raman");
        namesArrayList.add("Ramanujan");
        namesArrayList.add("Rameez");
        namesArrayList.add("Ramjan");
        arrayId.add("Aadhaar Card");
        arrayId.add("PAN Card");
        arrayId.add("Voter ID Card");
        arrayId.add("Driving License Card");
        arrayId.add("Ration Card");
        arrayId.add("12th MarkSheet");
        arrayId.add("10th MarkSheet");
        arrayId.add("Aadhaar Card");
        arrayId.add("PAN Card");
        arrayId.add("Voter ID Card");
        arrayId.add("Driving License Card");
        arrayId.add("Ration Card");
        arrayId.add("12th MarkSheet");
        arrayId.add("10th MarkSheet");
        arrayId.add("Aadhaar Card");
        arrayId.add("PAN Card");
        arrayId.add("Voter ID Card");
        arrayId.add("Driving License Card");
        arrayId.add("Ration Card");
        arrayId.add("12th MarkSheet");
        arrayId.add("10th MarkSheet");
        arrayLanguage.add("C");
        arrayLanguage.add("C++");
        arrayLanguage.add("JAVA");
        arrayLanguage.add("PHP");
        arrayLanguage.add("PHP");
        arrayLanguage.add("Objective C");
        arrayLanguage.add("C#");
        arrayLanguage.add("C Script");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, namesArrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(MainActivity.this,"Clicked first item", Toast.LENGTH_LONG).show();
                }
            }
        });
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_checked, arrayId);
        spinner.setAdapter(spinnerAdapter);
        ArrayAdapter <String> arrLanguageAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_checked, arrayLanguage);
        autoCompleteTextView.setAdapter(arrLanguageAdapter);
        autoCompleteTextView.setThreshold(0); // to set the number of letter to be entered before showing the data in t he list
    }
}