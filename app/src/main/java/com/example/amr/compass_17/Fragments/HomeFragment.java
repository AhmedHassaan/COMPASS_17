package com.example.amr.compass_17.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amr.compass_17.News;
import com.example.amr.compass_17.NewsAdapter;
import com.example.amr.compass_17.NotificationServices;
import com.example.amr.compass_17.R;
import com.example.amr.compass_17.data.ControlRealm;
import com.example.amr.compass_17.data.Event;
import com.example.amr.compass_17.data.Users;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdel on 9/20/2016.
 */
public class HomeFragment extends Fragment {

    NewsAdapter newsAdapter;
    RecyclerView recyclerView;
    List<News> newsList = new ArrayList<>();
    DatabaseReference db;
    Users data;
    ControlRealm realm;

    public HomeFragment(){}

    /*public HomeFragment(List<News> newsList)
    {this.newsList = newsList;}
*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.news_recyclerview);
        data = new Users(getActivity());
        realm = new ControlRealm(getActivity());
        db = FirebaseDatabase.getInstance().getReference();
        newsList = new ArrayList<>();
        newsList.add(new News("Antalya","http://res.cloudinary.com/dflpifew9/image/upload/v1486849057/antalya_hg4npr.jpg","This is a test article to see if it works correctly or not."));
        newsList.add(new News("Turkey","http://res.cloudinary.com/dflpifew9/image/upload/v1486849105/turkey_lbr9iv.jpg","This is a test article to see if it works correctly or not."));
        newsList.add(new News("Antalya","http://res.cloudinary.com/dflpifew9/image/upload/v1486849057/antalya_hg4npr.jpg","This is a test article to see if it works correctly or not."));
        newsList.add(new News("Turkey","http://res.cloudinary.com/dflpifew9/image/upload/v1486849105/turkey_lbr9iv.jpg","This is a test article to see if it works correctly or not."));
        newsAdapter = new NewsAdapter(getContext(),newsList);
        if(!data.getEventFirstSync()) {
            DatabaseReference db1 = db.child("events");
            db1.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    data.setLastEvent(dataSnapshot.getValue(String.class));
                    String[] ss = dataSnapshot.getValue(String.class).split("---");
                    Event event = new Event();
                    event.setName(ss[0]);
                    event.setLocation(ss[1]);
                    event.setDescription(ss[2]);
                    event.setImage(ss[3]);
                    event.setTime(ss[4]);
                    realm.putEvent(event);
                    newsList.add(new News(ss[0], "http://res.cloudinary.com/dflpifew9/image/upload/v1486849105/turkey_lbr9iv.jpg", ss[2]));
                    newsAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            data.setEventFirstSync();
        }
        else{
            ArrayList<Event> ee = realm.getAllEvents();
            for(Event e : ee){
                newsList.add(new News(e.getName(),"Teeest",e.getDescription()));
            }
            newsAdapter.notifyDataSetChanged();
        }

        getActivity().startService(new Intent(getActivity(), NotificationServices.class));

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(newsAdapter);

        return view;
    }
}