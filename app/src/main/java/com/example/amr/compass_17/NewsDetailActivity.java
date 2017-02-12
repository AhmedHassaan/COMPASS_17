package com.example.amr.compass_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {

    TextView title,article;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        title = (TextView)findViewById(R.id.detail_title_textview);
        article = (TextView)findViewById(R.id.detail_article_textview);
        image = (ImageView)findViewById(R.id.detail_image_textview);



        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        article.setText(intent.getStringExtra("article"));

        Picasso.with(this)
                .load(intent.getStringExtra("image"))
                .fit()
                .into(image);
    }
}
