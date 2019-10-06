package com.example.audio;

import android.media.MediaPlayer;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.hare);
        mp.setLooping(true);;
        mp.start();
    }

    protected void onDestroy() {
        mp.stop();
        mp.release();
        super.onDestroy();
    }
}
