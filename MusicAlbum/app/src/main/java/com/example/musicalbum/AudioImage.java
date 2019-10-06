package com.example.musicalbum;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AudioImage extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_image);

        setTitle("노래 재생");

        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");

        TextView title = (TextView)findViewById(R.id.title);
        ImageView song_image = (ImageView)findViewById(R.id.song_image);
        TextView lyrics = (TextView)findViewById(R.id.lyrics);

        Resources res = getResources();

        int stringId;
        String myKey;

        stringId = res.getIdentifier("title" + tag, "string", getPackageName());
        myKey = res.getString(stringId);
        title.setText(myKey);

        stringId = res.getIdentifier("song_image" + tag, "string", getPackageName());
        myKey = res.getString(stringId);

        int id_image = res.getIdentifier(myKey, "drawable", getPackageName());
        song_image.setImageResource(id_image);

        stringId = res.getIdentifier("lyrics" + tag, "string", getPackageName());
        myKey = res.getString(stringId);
        lyrics.setText(myKey);

        stringId = res.getIdentifier("audio" + tag, "string", getPackageName());
        myKey = res.getString(stringId);
        int id_audio = res.getIdentifier(myKey, "raw", getPackageName());
        mp = MediaPlayer.create(this, id_audio);
        mp.setLooping(false);
        mp.start();
    }

    public void goBack(View v) {
        mp.stop();
        mp.release();
        finish();
    }
}