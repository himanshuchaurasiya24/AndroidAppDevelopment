package com.chaurasiya.gridviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    gridView = findViewById(R.id.gridView);
        ArrayList<CourseModel> courseModelArrayList =  new ArrayList<CourseModel>();
        courseModelArrayList.add(new CourseModel("The complete android development course",R.drawable.course1));
        courseModelArrayList.add(new CourseModel("The complete java developer course", R.drawable.course2));
        courseModelArrayList.add(new CourseModel("The complete kotlin course", R.drawable.course3));
        courseModelArrayList.add(new CourseModel("The complete data structure ad algorithm course", R.drawable.course4));
        MyAdapter myAdapter = new MyAdapter(this, courseModelArrayList);
        gridView.setAdapter(myAdapter);
    }
}