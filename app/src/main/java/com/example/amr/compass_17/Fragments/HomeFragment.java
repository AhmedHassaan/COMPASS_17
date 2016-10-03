package com.example.amr.compass_17.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.amr.compass_17.News;
import com.example.amr.compass_17.NewsAdapter;
import com.example.amr.compass_17.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdel on 9/20/2016.
 */
public class HomeFragment extends Fragment {

    NewsAdapter newsAdapter;
    //RecyclerView recyclerView;
    ExpandableListView expandableListView;
    List<News> newsList = new ArrayList<>();

    public HomeFragment(){}

    /*public HomeFragment(List<News> newsList)
    {this.newsList = newsList;}
*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        //recyclerView = (RecyclerView)view.findViewById(R.id.homePage_recyclerView);
        expandableListView = (ExpandableListView)view.findViewById(R.id.homePage_list);

        News news = new News("Hi",R.drawable.ic_launcher,"hello");
        newsList.add(news);
        newsList.add(news);
        newsList.add(news);
        news = new News("Welcome",R.drawable.ic_launcher
                ,"ay kalam bas al mohem tasht3'l ya3ny w al article yb2a latef w rbna ya5lek l om al donya w mtnsash al fakka yastaa");
        newsList.add(news);
        newsList.add(news);
        newsList.add(news);
        newsList.add(news);
        newsList.add(news);
        newsList.add(news);
        newsList.add(news);
        newsList.add(news);
        newsList.add(news);

        newsAdapter = new NewsAdapter(newsList);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //recyclerView.setLayoutManager(layoutManager);
        //recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(48));
        //recyclerView.setAdapter(newsAdapter);
        expandableListView.setAdapter(newsAdapter);
        expandableListView.setGroupIndicator(null);

        return view;
    }
}
