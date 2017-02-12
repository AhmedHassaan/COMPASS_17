package com.example.amr.compass_17.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.amr.compass_17.News;
import com.example.amr.compass_17.NewsAdapter;
import com.example.amr.compass_17.NewsDetailActivity;
import com.example.amr.compass_17.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdel on 9/20/2016.
 */
public class HomeFragment extends Fragment {

    NewsAdapter newsAdapter;
    RecyclerView recyclerView;
    List<News> newsList = new ArrayList<>();

    public HomeFragment(){}

    /*public HomeFragment(List<News> newsList)
    {this.newsList = newsList;}
*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.news_recyclerview);

        newsList = new ArrayList<>();
        newsList.add(new News("Antalya","http://res.cloudinary.com/dflpifew9/image/upload/v1486849057/antalya_hg4npr.jpg","This is a test article to see if it works correctly or not."));
        newsList.add(new News("Turkey","http://res.cloudinary.com/dflpifew9/image/upload/v1486849105/turkey_lbr9iv.jpg","This is a test article to see if it works correctly or not."));
        newsList.add(new News("Antalya","http://res.cloudinary.com/dflpifew9/image/upload/v1486849057/antalya_hg4npr.jpg","This is a test article to see if it works correctly or not."));
        newsList.add(new News("Turkey","http://res.cloudinary.com/dflpifew9/image/upload/v1486849105/turkey_lbr9iv.jpg","This is a test article to see if it works correctly or not."));
        newsAdapter = new NewsAdapter(getContext(),newsList);



        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(newsAdapter);

        return view;
    }
}
