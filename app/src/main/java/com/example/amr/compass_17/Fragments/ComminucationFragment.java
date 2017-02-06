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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    DatabaseReference db;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.communication_fragment,container,false);
        controlRealm = new ControlRealm(getActivity());
        listView = (ListView)root.findViewById(R.id.listview);
        allMessages = controlRealm.getAllMessages();
        messages = new ArrayList<>();
        db= FirebaseDatabase.getInstance().getReference();
        adapter = new messageAdapter(getActivity(),R.layout.onemessage,messages);
        listView.setAdapter(adapter);


        DatabaseReference db1 = db.child("Message").child("legos");
        db1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                messages.add(dataSnapshot.getValue(String.class));
                adapter.notifyDataSetChanged();
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

        return root;
    }
}
