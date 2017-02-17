package com.example.amr.compass_17;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by abdel on 9/27/2016.
 */


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private Context context;
    private List<News> newsList;

    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final News news = newsList.get(position);
        holder.title.setText(news.getTitle());
        Picasso.with(context)
                .load(news.getImage())
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explodeAnimation(news);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void explodeAnimation(News news)
    {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context);
        Intent intent = new Intent(context,NewsDetailActivity.class);
        intent.putExtra("title",news.getTitle());
        intent.putExtra("image",news.getImage());
        intent.putExtra("article",news.getArticle());
        context.startActivity(intent,options.toBundle());
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        ImageView image;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.cardview_title);
            image = (ImageView) view.findViewById(R.id.cardview_image);
        }
    }
}