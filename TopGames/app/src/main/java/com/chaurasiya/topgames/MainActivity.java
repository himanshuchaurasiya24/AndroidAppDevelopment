package com.chaurasiya.topgames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModelClass> gameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        gameList = new ArrayList<>();
        gameList.add(new ModelClass("PUBG", R.drawable.card2));
        gameList.add(new ModelClass("Horizon Chase", R.drawable.card1));
        gameList.add(new ModelClass("Hooked On You", R.drawable.card4));
        gameList.add(new ModelClass("Head Ball 2", R.drawable.card3));
        gameList.add(new ModelClass("FIFA Mobile 2022", R.drawable.card5));
        gameList.add(new ModelClass("Fortnite", R.drawable.card6));
        MyAdapter myAdapter = new MyAdapter(getApplicationContext(), gameList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

    }
}