package com.example.amr.compass_17.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.amr.compass_17.LstViewAdapter;
import com.example.amr.compass_17.R;

/**
 * Created by abdel on 9/20/2016.
 */
public class SessionsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sessions_fragment,container,false);


        ListView lstview=(ListView)view.findViewById(R.id.listview);
        // Inflate header view
        ViewGroup headerView = (ViewGroup)getLayoutInflater(null).inflate(R.layout.header, lstview,false);
        // Add header view to the ListView
        lstview.addHeaderView(headerView);
        // Get the string array defined in strings.xml file
        String[] items=getResources().getStringArray(R.array.list_items);
        // Create an adapter to bind data to the ListView
        LstViewAdapter adapter=new LstViewAdapter(getActivity(),R.layout.rowlayout,R.id.txtname,items);
        // Bind data to the ListView
        lstview.setAdapter(adapter);


        return view;
    }
}
