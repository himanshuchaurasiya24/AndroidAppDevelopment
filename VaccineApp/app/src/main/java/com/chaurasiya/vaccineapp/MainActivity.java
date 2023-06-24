package com.chaurasiya.vaccineapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    RecyclerView recyclerView;
    VaccineModel [] listData;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        listData = new VaccineModel[]{
                new VaccineModel("Vaccine 1", R.drawable.vaccine1),
                new VaccineModel("Vaccine 1", R.drawable.vaccine1),
                new VaccineModel("Vaccine 2", R.drawable.vaccine5),
                new VaccineModel("Vaccine 2", R.drawable.vaccine5),
                new VaccineModel("Vaccine 3", R.drawable.vaccine6),
                new VaccineModel("Vaccine 3", R.drawable.vaccine6),
                new VaccineModel("Vaccine 4", R.drawable.vaccine4),
                new VaccineModel("Vaccine 4", R.drawable.vaccine4),
                new VaccineModel("Vaccine 5", R.drawable.vaccine5),
                new VaccineModel("Vaccine 5", R.drawable.vaccine5),
                new VaccineModel("Vaccine 7", R.drawable.vaccine7),
                new VaccineModel("Vaccine 7", R.drawable.vaccine7),
        };
        myAdapter = new MyAdapter(listData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(myAdapter);
        myAdapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Vaccine name: "+listData[pos].getTitle(), Toast.LENGTH_LONG).show();
    }
}