package com.chaurasiya.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBHelper myDBHelper = new MyDBHelper(MainActivity.this);
        myDBHelper.addContact("Himanshu Chaurasiya", "9129611321");
        myDBHelper.addContact("Shishir Chaurasiya", "8177074123");
        myDBHelper.addContact("Sanjay Chaurasiya", "9795015976");
//        StructureClassArray structureClassArray = new StructureClassArray();
//        structureClassArray.id=1;
//        structureClassArray.name= "Himanshu";
//        structureClassArray.phoneNumber = "1234567890";
//        myDBHelper.updateContact(structureClassArray);
        myDBHelper.deleteContact(1);

        ArrayList<StructureClassArray> structureClassArrayArrayList = myDBHelper.fetchContact();
        for (int i =0; i<structureClassArrayArrayList.size(); i++){
            Log.d("Contact Info", "Name: "+structureClassArrayArrayList.get(i).name+" Phone number: "+ structureClassArrayArrayList.get(i).phoneNumber);
        }
    }
}