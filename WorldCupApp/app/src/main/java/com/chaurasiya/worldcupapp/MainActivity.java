package com.chaurasiya.worldcupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
private static CustomAdapter adapter;
ArrayList<Country> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Adapter View
        listView = findViewById(R.id.listView);
        // Data Source
        arrayList= new ArrayList<>();
        arrayList.add( new Country("Germany", "2", R.drawable.germany));
        arrayList.add( new Country("Spain", "3", R.drawable.spain));
        arrayList.add( new Country("Saudi Arabia", "1", R.drawable.saudiarabia));
        arrayList.add( new Country("Brazil", "5", R.drawable.brazil));
        arrayList.add( new Country("England", "1", R.drawable.unitedkingdom));
        arrayList.add( new Country("USA", "3", R.drawable.unitedstates));
        // Adapter
        adapter = new CustomAdapter(arrayList, getApplicationContext());
        listView.setAdapter(adapter);
    }
}