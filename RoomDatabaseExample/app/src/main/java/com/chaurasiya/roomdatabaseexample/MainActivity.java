package com.chaurasiya.roomdatabaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAmount;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtAmount = findViewById(R.id.edtAmount);
        btnAdd = findViewById(R.id.btnAdd);
        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String amount = edtAmount.getText().toString();
                databaseHelper.expenseDAO().addTransaction(
                        new Expense(name , amount)
                );
                ArrayList<Expense> arrExpenses = (ArrayList<Expense>)databaseHelper.expenseDAO().getAllExpense();
                for (int i =0; i<arrExpenses.size(); i++){
                    Log.d("Data", "ID: "+arrExpenses.get(i).getId()+" Name: "+arrExpenses.get(i).getName() + " Amount: "+arrExpenses.get(i).getAmount());
                }
            }
        });

    }
}


















