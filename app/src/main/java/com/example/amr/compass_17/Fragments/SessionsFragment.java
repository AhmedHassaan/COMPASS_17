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
        View view = inflater.inflate(R.layout.sessions_fragment, container, false);
        ButterKnife.bind(this, view);

        cliche.setImageResource(R.drawable.cliche);
        dnet.setImageResource(R.drawable.dnet);
        sugarrush.setImageResource(R.drawable.sugarrushs);
        pharopell.setImageResource(R.drawable.pharopell);
        laypuzz.setImageResource(R.drawable.laypuzz);
        legoss.setImageResource(R.drawable.legoss);
        selectedImage.setImageResource(R.drawable.sugarrush);
        selectedText.setText("Sugarrush Workshop");

        dnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliche.setImageResource(R.drawable.cliche);
                dnet.setImageResource(R.drawable.dnets);
                sugarrush.setImageResource(R.drawable.sugarrush);
                pharopell.setImageResource(R.drawable.pharopell);
                laypuzz.setImageResource(R.drawable.laypuzz);
                legoss.setImageResource(R.drawable.legoss);
                selectedImage.setImageResource(R.drawable.dnet);
                selectedText.setText("Dnet Workshop");
            }
        });

        cliche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliche.setImageResource(R.drawable.cliches);
                dnet.setImageResource(R.drawable.dnet);
                sugarrush.setImageResource(R.drawable.sugarrush);
                pharopell.setImageResource(R.drawable.pharopell);
                laypuzz.setImageResource(R.drawable.laypuzz);
                legoss.setImageResource(R.drawable.legoss);
                selectedImage.setImageResource(R.drawable.cliche);
                selectedText.setText("Cliche Workshop");
            }
        });
        laypuzz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cliche.setImageResource(R.drawable.cliche);
                dnet.setImageResource(R.drawable.dnet);
                sugarrush.setImageResource(R.drawable.sugarrush);
                pharopell.setImageResource(R.drawable.pharopell);
                laypuzz.setImageResource(R.drawable.laypuzzs);
                legoss.setImageResource(R.drawable.legoss);
                selectedImage.setImageResource(R.drawable.laypuzz);
                selectedText.setText("Laypyzz Workshop");
            }
        });
        legoss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliche.setImageResource(R.drawable.cliche);
                dnet.setImageResource(R.drawable.dnet);
                sugarrush.setImageResource(R.drawable.sugarrush);
                pharopell.setImageResource(R.drawable.pharopell);
                laypuzz.setImageResource(R.drawable.laypuzz);
                legoss.setImageResource(R.drawable.legosss);
                selectedImage.setImageResource(R.drawable.legoss);
                selectedText.setText("Legoss Workshop");
            }
        });
        pharopell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliche.setImageResource(R.drawable.cliche);
                dnet.setImageResource(R.drawable.dnet);
                sugarrush.setImageResource(R.drawable.sugarrush);
                pharopell.setImageResource(R.drawable.pharopells);
                laypuzz.setImageResource(R.drawable.laypuzz);
                legoss.setImageResource(R.drawable.legoss);
                selectedImage.setImageResource(R.drawable.pharopell);
                selectedText.setText("Pharopell Workshop");
            }
        });
        sugarrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliche.setImageResource(R.drawable.cliche);
                dnet.setImageResource(R.drawable.dnet);
                sugarrush.setImageResource(R.drawable.sugarrushs);
                pharopell.setImageResource(R.drawable.pharopell);
                laypuzz.setImageResource(R.drawable.laypuzz);
                legoss.setImageResource(R.drawable.legoss);
                selectedImage.setImageResource(R.drawable.sugarrush);
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
                cliche.setImageResource(R.drawable.cliches);
                dnet.setImageResource(R.drawable.dnet);
                sugarrush.setImageResource(R.drawable.sugarrush);
                pharopell.setImageResource(R.drawable.pharopell);
                laypuzz.setImageResource(R.drawable.laypuzz);
                legoss.setImageResource(R.drawable.legoss);
                selectedImage.setImageResource(R.drawable.cliche);
                selectedText.setText("Cliche Workshop");
                break;
            case R.id.sugarrush:
                cliche.setImageResource(R.drawable.cliche);
                dnet.setImageResource(R.drawable.dnet);
                sugarrush.setImageResource(R.drawable.sugarrushs);
                pharopell.setImageResource(R.drawable.pharopell);
                laypuzz.setImageResource(R.drawable.laypuzz);
                legoss.setImageResource(R.drawable.legoss);
                selectedImage.setImageResource(R.drawable.sugarrush);
                selectedText.setText("Sugarrush Workshop");
                break;
            case R.id.laypuz:
                cliche.setImageResource(R.drawable.cliche);
                dnet.setImageResource(R.drawable.dnet);
                sugarrush.setImageResource(R.drawable.sugarrush);
                pharopell.setImageResource(R.drawable.pharopell);
                laypuzz.setImageResource(R.drawable.laypuzzs);
                legoss.setImageResource(R.drawable.legoss);
                selectedImage.setImageResource(R.drawable.laypuzz);
                selectedText.setText("Laypyzz Workshop");
                break;
            case R.id.legoss:
                cliche.setImageResource(R.drawable.cliche);
                dnet.setImageResource(R.drawable.dnet);
                sugarrush.setImageResource(R.drawable.sugarrush);
                pharopell.setImageResource(R.drawable.pharopell);
                laypuzz.setImageResource(R.drawable.laypuzz);
                legoss.setImageResource(R.drawable.legosss);
                selectedImage.setImageResource(R.drawable.legoss);
                selectedText.setText("Legoss Workshop");
                break;
            case R.id.pharopell:
                cliche.setImageResource(R.drawable.cliche);
                dnet.setImageResource(R.drawable.dnet);
                sugarrush.setImageResource(R.drawable.sugarrush);
                pharopell.setImageResource(R.drawable.pharopells);
                laypuzz.setImageResource(R.drawable.laypuzz);
                legoss.setImageResource(R.drawable.legoss);
                selectedImage.setImageResource(R.drawable.pharopell);
                selectedText.setText("Pharopell Workshop");
                break;
            case R.id.dnet:
                cliche.setImageResource(R.drawable.cliche);
                dnet.setImageResource(R.drawable.dnets);
                sugarrush.setImageResource(R.drawable.sugarrush);
                pharopell.setImageResource(R.drawable.pharopell);
                laypuzz.setImageResource(R.drawable.laypuzz);
                legoss.setImageResource(R.drawable.legoss);
                selectedImage.setImageResource(R.drawable.dnet);
                selectedText.setText("Dnet Workshop");
                break;
        }
    }
    */
}
