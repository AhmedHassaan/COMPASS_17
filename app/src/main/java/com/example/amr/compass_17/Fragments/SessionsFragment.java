package com.example.amr.compass_17.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.amr.compass_17.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by abdel on 9/20/2016.
 */
public class SessionsFragment extends Fragment {


    @Bind(R.id.cliche)
    ImageButton cliche;
    @Bind(R.id.sugarrush)
    ImageButton sugarrush;
    @Bind(R.id.pharopell)
    ImageButton pharopell;
    @Bind(R.id.legoss)
    ImageButton legoss;
    @Bind(R.id.laypuz)
    ImageButton laypuzz;
    @Bind(R.id.dnet)
    ImageButton dnet;
    @Bind(R.id.selectedImage)
    ImageButton selectedImage;
    @Bind(R.id.selectedText)
    TextView selectedText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sessions_fragment,container,false);
        ButterKnife.bind(this , view);


        cliche.setBackgroundResource(R.drawable.cliche);
        dnet.setBackgroundResource(R.drawable.dnet);
        sugarrush.setBackgroundResource(R.drawable.sugarrushs);
        pharopell.setBackgroundResource(R.drawable.pharopell);
        laypuzz.setBackgroundResource(R.drawable.laypuzz);
        legoss.setBackgroundResource(R.drawable.legoss);
        selectedImage.setBackgroundResource(R.drawable.sugarrush);
        selectedText.setText("Sugarrush Workshop");

        dnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliche.setBackgroundResource(R.drawable.cliche);
                dnet.setBackgroundResource(R.drawable.dnets);
                sugarrush.setBackgroundResource(R.drawable.sugarrush);
                pharopell.setBackgroundResource(R.drawable.pharopell);
                laypuzz.setBackgroundResource(R.drawable.laypuzz);
                legoss.setBackgroundResource(R.drawable.legoss);
                selectedImage.setBackgroundResource(R.drawable.dnet);
                selectedText.setText("Dnet Workshop");
            }
        });

        cliche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliche.setBackgroundResource(R.drawable.cliches);
                dnet.setBackgroundResource(R.drawable.dnet);
                sugarrush.setBackgroundResource(R.drawable.sugarrush);
                pharopell.setBackgroundResource(R.drawable.pharopell);
                laypuzz.setBackgroundResource(R.drawable.laypuzz);
                legoss.setBackgroundResource(R.drawable.legoss);
                selectedImage.setBackgroundResource(R.drawable.cliche);
                selectedText.setText("Cliche Workshop");
            }
        });
        laypuzz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cliche.setBackgroundResource(R.drawable.cliche);
                dnet.setBackgroundResource(R.drawable.dnet);
                sugarrush.setBackgroundResource(R.drawable.sugarrush);
                pharopell.setBackgroundResource(R.drawable.pharopell);
                laypuzz.setBackgroundResource(R.drawable.laypuzzs);
                legoss.setBackgroundResource(R.drawable.legoss);
                selectedImage.setBackgroundResource(R.drawable.laypuzz);
                selectedText.setText("Laypyzz Workshop");
            }
        });
        legoss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliche.setBackgroundResource(R.drawable.cliche);
                dnet.setBackgroundResource(R.drawable.dnet);
                sugarrush.setBackgroundResource(R.drawable.sugarrush);
                pharopell.setBackgroundResource(R.drawable.pharopell);
                laypuzz.setBackgroundResource(R.drawable.laypuzz);
                legoss.setBackgroundResource(R.drawable.legosss);
                selectedImage.setBackgroundResource(R.drawable.legoss);
                selectedText.setText("Legoss Workshop");
            }
        });
        pharopell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliche.setBackgroundResource(R.drawable.cliche);
                dnet.setBackgroundResource(R.drawable.dnet);
                sugarrush.setBackgroundResource(R.drawable.sugarrush);
                pharopell.setBackgroundResource(R.drawable.pharopells);
                laypuzz.setBackgroundResource(R.drawable.laypuzz);
                legoss.setBackgroundResource(R.drawable.legoss);
                selectedImage.setBackgroundResource(R.drawable.pharopell);
                selectedText.setText("Pharopell Workshop");
            }
        });
        sugarrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliche.setBackgroundResource(R.drawable.cliche);
                dnet.setBackgroundResource(R.drawable.dnet);
                sugarrush.setBackgroundResource(R.drawable.sugarrushs);
                pharopell.setBackgroundResource(R.drawable.pharopell);
                laypuzz.setBackgroundResource(R.drawable.laypuzz);
                legoss.setBackgroundResource(R.drawable.legoss);
                selectedImage.setBackgroundResource(R.drawable.sugarrush);
                selectedText.setText("Sugarrush Workshop");
            }
        });
        return view;
    }

    /*
    @OnClick({R.id.cliche,R.id.sugarrush,R.id.pharopell,R.id.dnet,R.id.legoss,R.id.laypuz})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.cliche:
                cliche.setBackgroundResource(R.drawable.cliches);
                dnet.setBackgroundResource(R.drawable.dnet);
                sugarrush.setBackgroundResource(R.drawable.sugarrush);
                pharopell.setBackgroundResource(R.drawable.pharopell);
                laypuzz.setBackgroundResource(R.drawable.laypuzz);
                legoss.setBackgroundResource(R.drawable.legoss);
                selectedImage.setBackgroundResource(R.drawable.cliche);
                selectedText.setText("Cliche Workshop");
                break;
            case R.id.sugarrush:
                cliche.setBackgroundResource(R.drawable.cliche);
                dnet.setBackgroundResource(R.drawable.dnet);
                sugarrush.setBackgroundResource(R.drawable.sugarrushs);
                pharopell.setBackgroundResource(R.drawable.pharopell);
                laypuzz.setBackgroundResource(R.drawable.laypuzz);
                legoss.setBackgroundResource(R.drawable.legoss);
                selectedImage.setBackgroundResource(R.drawable.sugarrush);
                selectedText.setText("Sugarrush Workshop");
                break;
            case R.id.laypuz:
                cliche.setBackgroundResource(R.drawable.cliche);
                dnet.setBackgroundResource(R.drawable.dnet);
                sugarrush.setBackgroundResource(R.drawable.sugarrush);
                pharopell.setBackgroundResource(R.drawable.pharopell);
                laypuzz.setBackgroundResource(R.drawable.laypuzzs);
                legoss.setBackgroundResource(R.drawable.legoss);
                selectedImage.setBackgroundResource(R.drawable.laypuzz);
                selectedText.setText("Laypyzz Workshop");
                break;
            case R.id.legoss:
                cliche.setBackgroundResource(R.drawable.cliche);
                dnet.setBackgroundResource(R.drawable.dnet);
                sugarrush.setBackgroundResource(R.drawable.sugarrush);
                pharopell.setBackgroundResource(R.drawable.pharopell);
                laypuzz.setBackgroundResource(R.drawable.laypuzz);
                legoss.setBackgroundResource(R.drawable.legosss);
                selectedImage.setBackgroundResource(R.drawable.legoss);
                selectedText.setText("Legoss Workshop");
                break;
            case R.id.pharopell:
                cliche.setBackgroundResource(R.drawable.cliche);
                dnet.setBackgroundResource(R.drawable.dnet);
                sugarrush.setBackgroundResource(R.drawable.sugarrush);
                pharopell.setBackgroundResource(R.drawable.pharopells);
                laypuzz.setBackgroundResource(R.drawable.laypuzz);
                legoss.setBackgroundResource(R.drawable.legoss);
                selectedImage.setBackgroundResource(R.drawable.pharopell);
                selectedText.setText("Pharopell Workshop");
                break;
            case R.id.dnet:
                cliche.setBackgroundResource(R.drawable.cliche);
                dnet.setBackgroundResource(R.drawable.dnets);
                sugarrush.setBackgroundResource(R.drawable.sugarrush);
                pharopell.setBackgroundResource(R.drawable.pharopell);
                laypuzz.setBackgroundResource(R.drawable.laypuzz);
                legoss.setBackgroundResource(R.drawable.legoss);
                selectedImage.setBackgroundResource(R.drawable.dnet);
                selectedText.setText("Dnet Workshop");
                break;
        }
    }
    */
}
