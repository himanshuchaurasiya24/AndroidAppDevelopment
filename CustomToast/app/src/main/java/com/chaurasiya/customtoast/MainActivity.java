package com.chaurasiya.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Custom Toast
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = getLayoutInflater().inflate(R.layout.custom_toast_layout,(ViewGroup) findViewById(R.id.linearLayout));
                Toast toast = new Toast(getApplicationContext());
                toast.setView(v);
//        toast.setText("gjhh");
//                TextView textView = v.findViewById(R.id.txtMsg);
//                textView.setText("Message Sent");
                toast.setDuration(Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.TOP|Gravity.END,0, 0);
                toast.setGravity(Gravity.CLIP_HORIZONTAL,0, 0);
                toast.show();
            }
        });
    }
}