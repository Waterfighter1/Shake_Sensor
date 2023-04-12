package com.zybooks.shake_sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Main Text
        TextView mainTxt = findViewById(R.id.txt_main);
        Button btn = findViewById(R.id.button);
        btn.setVisibility(View.GONE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               btn.setVisibility(View.GONE);
               mainTxt.setText("Don\'t Shake Me\n>:(");
            }
        });

        // Sensor Manager: Purpose = "Manages all of the Sensors"
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Make a Sensor that specifically gets the Accelerometer
        Sensor sensorShake = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null) {

                    float x_accel = sensorEvent.values[0];
                    float y_accel = sensorEvent.values[1];
                    float z_accel = sensorEvent.values[2];

                    if ((x_accel > 2 || x_accel < -2 || y_accel > 12 || y_accel < -12 ||  z_accel > 2 || z_accel < -2)) {
                        mainTxt.setText("I said DON'T SHAKE ME!!!");
                        btn.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        sensorManager.registerListener(sensorEventListener, sensorShake, sensorManager.SENSOR_DELAY_NORMAL);
    }
}