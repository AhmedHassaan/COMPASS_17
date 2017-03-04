package com.example.amr.compass_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {

    TextView title,article;
    ImageView image;
    //CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.myCollapsingToolbar);
        //collapsingToolbarLayout.setTitle("COMPASS 17");


        title = (TextView)findViewById(R.id.detail_title_textview);
        article = (TextView)findViewById(R.id.detail_article_textview);
        image = (ImageView)findViewById(R.id.detail_image_textview);

        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        article.setText(intent.getStringExtra("article"));

        Picasso.with(this)
                .load(intent.getStringExtra("image")).into(image);


        /*Explode explode = new Explode();
        explode.setDuration(750);
        getWindow().setEnterTransition(explode);*/
    }
}
