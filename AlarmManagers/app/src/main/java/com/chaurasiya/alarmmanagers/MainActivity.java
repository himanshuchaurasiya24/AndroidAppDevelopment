package com.chaurasiya.alarmmanagers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int ALARM_REQ_CODE= 100;
    EditText edtTime;
    Button btnSet;
    TextView txtOnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTime = findViewById(R.id.edtTime);
        btnSet = findViewById(R.id.btnSet);
        View inflatedView = getLayoutInflater().inflate(R.layout.on_play, null);
        txtOnPlay = (TextView) inflatedView.findViewById(R.id.txtOnPlay);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        btnSet .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(edtTime.getText().toString());
                long triggerTime = System.currentTimeMillis()+(time*1000);
                Intent iBroadcast = new Intent(MainActivity.this , MyReceiver.class);
                Intent onPlay = new Intent(MainActivity.this,OnPlay.class );
                PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, ALARM_REQ_CODE,iBroadcast, PendingIntent.FLAG_IMMUTABLE );
                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime, pi);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(onPlay);
                        finish();
                    }
                }, triggerTime);
            }
        });

    }
}