package com.example.videoalbum;


import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_playback);

        setTitle("동영상 재생");

        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");

        TextView title = (TextView)findViewById(R.id.title);
        VideoView videoview = (VideoView)findViewById(R.id.videoview);

        int stringId;
        String myKey;

        Resources res = getResources();

        stringId = res.getIdentifier("title" + tag, "string", getPackageName());
        myKey = res.getString(stringId);
        title.setText(myKey);

        stringId = res.getIdentifier("video" + tag, "string", getPackageName());
        myKey = res.getString(stringId);

        int id_video = res.getIdentifier(myKey, "raw", getPackageName());

        Uri uri = Uri.parse("android.resource://com.example.videoalbum/" + id_video);

        videoview.setVideoURI(uri);
        videoview.start();

        MediaController mcontroller = new MediaController(this);
        videoview.setMediaController(mcontroller);
    }

    public void closeVideo(View v) {
        finish();
    }
}
