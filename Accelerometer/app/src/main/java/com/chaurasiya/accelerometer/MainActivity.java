package com.chaurasiya.accelerometer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorListener {
    TextView txtSensorRes ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSensorRes = findViewById(R.id.txtSensorResult);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager!=null){
            Sensor acceleroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if(acceleroSensor!=null){
                sensorManager.registerListener((SensorEventListener) this, acceleroSensor, SensorManager.SENSOR_DELAY_NORMAL );
            }
        }else {
            Toast.makeText(this, "No sensor", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSensorChanged(int sensor, float[] values) {

    }

    @Override
    public void onAccuracyChanged(int sensor, int accuracy) {

    }

    @SuppressLint("SetTextI18n")
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            txtSensorRes.setText("X: "+event.values[0]+",Y: "+event.values[1]+", Z: "+event.values[2]);
        }
    }
}