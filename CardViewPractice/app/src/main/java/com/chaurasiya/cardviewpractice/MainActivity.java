package com.chaurasiya.cardviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<MyItemList> myItemLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        myItemLists = new ArrayList<>();
        myItemLists.add(new MyItemList("App1", R.drawable.app1));
        myItemLists.add(new MyItemList("App2", R.drawable.app2));
        myItemLists.add(new MyItemList("App3", R.drawable.app3));
        MyAdapter myAdapter = new MyAdapter(this, myItemLists);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

    }
}