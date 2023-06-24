package com.chaurasiya.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ContactModel> contactModels = new ArrayList<>();
    EditText edtAddContactName;
    EditText edtAddContactNumber;
    Button btnAddContact;
    RecyclerContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerContact);
        FloatingActionButton btnOpenDialog= findViewById(R.id.addFloating);
        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_layout);
                ImageView contactImage=dialog.findViewById(R.id.imgContact);
                EditText edtAddContactName = dialog.findViewById(R.id.edtAddContactName);
                EditText edtAddContactNumber = dialog.findViewById(R.id.edtAddContactNumber);
                Button btnAddContact = dialog.findViewById(R.id.btnAddContact);

                btnAddContact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "";
                        String number = "";
                        int contactImage = R.drawable.contact_img_default;
                        if(edtAddContactName.getText().toString().equals("")||edtAddContactNumber.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "Please Enter All Details!",Toast.LENGTH_LONG ).show();
                        }else {
                            name = edtAddContactName.getText().toString();
                            number = edtAddContactNumber.getText().toString();

                        }
                        contactModels.add(new ContactModel(contactImage, name, number));
                        adapter.notifyItemInserted(contactModels.size()-1);
                        recyclerView.scrollToPosition(contactModels.size()-1);
                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });




























        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        contactModels.add(new ContactModel(R.drawable.contact_img_default, "Himanshu Chaurasiya", "7607276024"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Anuj Chaurasiya", "9129611321"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Shishir Chaurasiya", "8177074123"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Sanjay Chaurasiya", "9795015976"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Sanju Chaurasiya", "9838227049"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Rinku Chaurasiya", "9616498089"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Rinku Devi", "8177074123"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Sudheer Chaurasiya", "9889149224"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Mithilesh Chaurasiya", "9696274123"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Mithilesh Chaurasiya", "9455074123"));contactModels.add(new ContactModel(R.drawable.contact_img_default, "Himanshu Chaurasiya", "7607276024"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Anuj Chaurasiya", "9129611321"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Shishir Chaurasiya", "8177074123"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Sanjay Chaurasiya", "9795015976"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Sanju Chaurasiya", "9838227049"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Rinku Chaurasiya", "9616498089"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Rinku Devi", "8177074123"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Sudheer Chaurasiya", "9889149224"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Mithilesh Chaurasiya", "9696274123"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Mithilesh Chaurasiya", "9455074123"));contactModels.add(new ContactModel(R.drawable.contact_img_default, "Himanshu Chaurasiya", "7607276024"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Anuj Chaurasiya", "9129611321"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Shishir Chaurasiya", "8177074123"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Sanjay Chaurasiya", "9795015976"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Sanju Chaurasiya", "9838227049"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Rinku Chaurasiya", "9616498089"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Rinku Devi", "8177074123"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Sudheer Chaurasiya", "9889149224"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Mithilesh Chaurasiya", "9696274123"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Mithilesh Chaurasiya", "9455074123"));contactModels.add(new ContactModel(R.drawable.contact_img_default, "Himanshu Chaurasiya", "7607276024"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Anuj Chaurasiya", "9129611321"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Shishir Chaurasiya", "8177074123"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Sanjay Chaurasiya", "9795015976"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Sanju Chaurasiya", "9838227049"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Rinku Chaurasiya", "9616498089"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Rinku Devi", "8177074123"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Sudheer Chaurasiya", "9889149224"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Mithilesh Chaurasiya", "9696274123"));
        contactModels.add( new ContactModel(R.drawable.contact_img_default, "Mithilesh Chaurasiya", "9455074123"));
        adapter = new RecyclerContactAdapter(this, contactModels);
        recyclerView.setAdapter(adapter);

    }
}




















