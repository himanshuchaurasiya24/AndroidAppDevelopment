package com.chaurasiya.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private ArrayList<CourseModel> courseModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        recyclerView = findViewById(R.id.recyclerView);
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new CourseModel("The Complete Android Developer Course",R.drawable.masterandroid ));
        courseModelArrayList.add( new CourseModel("The Complete java", R.drawable.satar));
        courseModelArrayList.add(new CourseModel("Youtube Course", R.drawable.youtube));
        courseModelArrayList.add(new  CourseModel("Logo", R.drawable.loggo));
        MyAdapter adapter = new MyAdapter(this, courseModelArrayList);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}