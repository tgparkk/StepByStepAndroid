package com.example.poetry;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Poem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poem);

        // LinearLayout ll = (LinearLayout) findViewById(R.id.background);

        TextView tv_title  = (TextView)findViewById(R.id.title);
        TextView tv_author = (TextView)findViewById(R.id.author);
        TextView tv_body   = (TextView)findViewById(R.id.body);

        Intent it = getIntent();
        String tag  = it.getStringExtra("it_tag");

        Resources res = getResources();

        int id_title = res.getIdentifier("title" + tag, "string", getPackageName());
        String title = res.getString(id_title);
        tv_title.setText(title);

        int id_author = res.getIdentifier("author" + tag, "string", getPackageName());
        String author = res.getString(id_author);
        tv_author.setText(author);

        int id_body = res.getIdentifier("body" + tag, "string", getPackageName());
        String body = res.getString(id_body);
        tv_body.setText(body);

        /*
        int id_img = res.getIdentifier("background" + tag, "string", getPackageName());
        String picture = res.getString(id_img);
        int id_img2 = res.getIdentifier(picture, "drawable", getPackageName());
        Drawable drawable = res.getDrawable(id_img2);
        ll.setBackground(drawable);
        // ll.setAlpha(0.8f);
        ll.setBackgroundColor(Color.TRANSPARENT);
        */
    }

    public void closePoem(View v) {
        finish();
    }
}
