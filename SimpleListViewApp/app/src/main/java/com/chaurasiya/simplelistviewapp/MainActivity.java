package com.chaurasiya.simplelistviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String [] worldCup = {"Germany", "Spain", "Brazil", "England", "USA", "Saudi Arabia", "Qatar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.my_list_items,
                R.id.textView,
                worldCup
        );
        listView.setAdapter(adapter);
    }
}