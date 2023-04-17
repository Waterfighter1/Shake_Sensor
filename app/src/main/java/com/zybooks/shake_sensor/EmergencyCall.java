package com.zybooks.shake_sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

public class EmergencyCall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_call);
        playCall(EmergencyCall.this);
    }

    public static void playCall(final Context context) {
        MediaPlayer call = MediaPlayer.create(context, R.raw.emergencycallsound);
        call.start();
    }
}