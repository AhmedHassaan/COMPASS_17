package com.example.amr.compass_17;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by abdel on 9/27/2016.
 */


public class NewsAdapter extends BaseExpandableListAdapter {

    List<News> newsList;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public int getGroupCount() {
        return newsList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return newsList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return newsList.get(groupPosition).getArticle();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        News news = newsList.get(groupPosition);
        if (convertView == null)
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_single_item, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.news_title_textView);
        title.setTypeface(null, Typeface.BOLD);
        title.setText(news.getTitle());
        ImageView image = (ImageView)convertView.findViewById(R.id.news_image_imageView);
        image.setImageResource(news.getImage());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        News news = newsList.get(groupPosition);
        if (convertView == null)
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_child_item, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.news_article_textView);
        title.setText(news.getArticle());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}






















/*
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    List<News> newsList;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_single_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.title.setText(news.getTitle());
        holder.image.setImageResource(news.getImage());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        ImageView image;

        public MyViewHolder(View view) {
            super(view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Welcome to COMPASS sample app",Toast.LENGTH_SHORT).show();
                }
            });

            title = (TextView) view.findViewById(R.id.news_title_textView);
            image = (ImageView)view.findViewById(R.id.news_image_imageView);
        }
    }
}
*/