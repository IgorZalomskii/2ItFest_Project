package com.example.testik;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class SensorsList extends Activity {

    TextView tvText;
    SensorManager sensorManager;
    List<Sensor> sensors;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensorslist);
        tvText = (TextView) findViewById(R.id.tvText);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SensorsList.this, MainActivity.class);
                startActivity(i);

            }
        });
    }

    public void onClickSensList(View v){
        StringBuilder sb = new StringBuilder();

        for (Sensor sensor : sensors) {
            sb.append("name = ").append(sensor.getName()).append(", type = ")
                    .append(sensor.getType()).append("\nvendor = ")
                    .append(sensor.getVendor()).append(" ,version = ")
                    .append(sensor.getVersion()).append("\nmax = ")
                    .append(sensor.getMaximumRange()).append(", resolution = ")
                    .append(sensor.getResolution())
                    .append("\n-------------------------------------------------------------\n");
        }
        tvText.setText(sb);
    }
}