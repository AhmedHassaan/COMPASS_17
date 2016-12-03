package com.example.amr.compass_17.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.amr.compass_17.Adapters.messageAdapter;
import com.example.amr.compass_17.R;
import com.example.amr.compass_17.data.ControlRealm;
import com.example.amr.compass_17.data.OneMessage;

import java.util.ArrayList;

/**
 * Created by Lenovo on 12/2/2016.
 */

public class ComminucationFragment extends Fragment{
    ListView listView;
    messageAdapter adapter;
    ArrayList<String> messages = new ArrayList<>();
    ArrayList<OneMessage> allMessages = new ArrayList<>();
    ControlRealm controlRealm;
    boolean first  = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.communication_fragment,container,false);
        controlRealm = new ControlRealm(getActivity());
        listView = (ListView)root.findViewById(R.id.listview);
        allMessages = controlRealm.getAllMessages();
        messages = new ArrayList<>();
        messages.add("Test test");
        for(int i=0;i<allMessages.size();i++)
            messages.add(allMessages.get(i).getBody());
        adapter = new messageAdapter(getActivity(),R.layout.onemessage,messages);
        listView.setAdapter(adapter);
        first = true;
        return root;
    }
}
