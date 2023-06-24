package com.chaurasiya.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        String [] dataSource = {"Lollipop", "Kitkat", "Marshmallow", "Oreo", "Pie", "Android 10", "Android 11"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.my_item,R.id.textView, dataSource);
        listView.setAdapter(adapter);
    }
}