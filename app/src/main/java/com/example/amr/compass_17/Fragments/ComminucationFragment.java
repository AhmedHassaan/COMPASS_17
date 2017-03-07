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
import com.example.amr.compass_17.data.Users;

import java.util.ArrayList;

/**
 * Created by Lenovo on 12/2/2016.
 */

public class ComminucationFragment extends Fragment {
    ListView listView;
    messageAdapter adapter;
    ArrayList<String> messages;
    Users data;
    ControlRealm realm;
    String workshop;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.communication_fragment, container, false);
        listView = (ListView) root.findViewById(R.id.listview);
        data = new Users(getActivity());
        realm = new ControlRealm(getActivity());
        messages = new ArrayList<>();
        workshop = data.getWorkshop();
        if(data.getLogin()) {
            messages = realm.getMessages(workshop);
            adapter = new messageAdapter(getActivity(), R.layout.onemessage, messages);
            listView.setAdapter(adapter);
        }
        return root;
    }
}
