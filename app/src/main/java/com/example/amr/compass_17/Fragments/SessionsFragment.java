package com.example.amr.compass_17.Fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.amr.compass_17.R;
import com.example.amr.compass_17.data.Users;

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
    @Bind(R.id.infoButton)
    Button info;
    String selectedWorkshop;
    Users data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sessions_fragment, container, false);
        ButterKnife.bind(this, view);
        data = new Users(getActivity());
        selectedText.setMovementMethod(new ScrollingMovementMethod());
        if (data.getWorkshop().equals("sugerrush")) {
            selectedWorkshop = "sugerrush";
            cliche.setImageResource(R.drawable.cliche);
            dnet.setImageResource(R.drawable.dnet);
            sugarrush.setImageResource(R.drawable.sugarrushs);
            pharopell.setImageResource(R.drawable.pharopell);
            laypuzz.setImageResource(R.drawable.laypuzz);
            legoss.setImageResource(R.drawable.legoss);
            selectedImage.setImageResource(R.drawable.sugarrush);
            selectedText.setText("Hello Nougat : It’s COMPASS’17’s android workshop, the objective of this workshop is fairly simple, to show you guys how an android application works, how to make a great looking android application from scratch and the knowledge necessary to do so, but of course with a touch of fun, the way that COMPASS has always done it.");
        }
        if (data.getWorkshop().equals("pharopell")) {
            selectedWorkshop = "pharopell";
            cliche.setImageResource(R.drawable.cliche);
            dnet.setImageResource(R.drawable.dnet);
            sugarrush.setImageResource(R.drawable.sugarrush);
            pharopell.setImageResource(R.drawable.pharopells);
            laypuzz.setImageResource(R.drawable.laypuzz);
            legoss.setImageResource(R.drawable.legoss);
            selectedImage.setImageResource(R.drawable.pharopell);
            selectedText.setText("Pharopell Workshop");
        }
        if (data.getWorkshop().equals("legos")) {
            selectedWorkshop = "legos";
            cliche.setImageResource(R.drawable.cliche);
            dnet.setImageResource(R.drawable.dnet);
            sugarrush.setImageResource(R.drawable.sugarrush);
            pharopell.setImageResource(R.drawable.pharopell);
            laypuzz.setImageResource(R.drawable.laypuzz);
            legoss.setImageResource(R.drawable.legosss);
            selectedImage.setImageResource(R.drawable.legoss);
            selectedText.setText("Legoss Workshop");
        }
        if (data.getWorkshop().equals("laypuzz")) {
            selectedWorkshop = "laypuzz";
            cliche.setImageResource(R.drawable.cliche);
            dnet.setImageResource(R.drawable.dnet);
            sugarrush.setImageResource(R.drawable.sugarrush);
            pharopell.setImageResource(R.drawable.pharopell);
            laypuzz.setImageResource(R.drawable.laypuzzs);
            legoss.setImageResource(R.drawable.legoss);
            selectedImage.setImageResource(R.drawable.laypuzz);
            selectedText.setText("Laypyzz Workshop");
        }
        if (data.getWorkshop().equals("cliche")) {
            selectedWorkshop = "cliche";
            cliche.setImageResource(R.drawable.cliches);
            dnet.setImageResource(R.drawable.dnet);
            sugarrush.setImageResource(R.drawable.sugarrush);
            pharopell.setImageResource(R.drawable.pharopell);
            laypuzz.setImageResource(R.drawable.laypuzz);
            legoss.setImageResource(R.drawable.legoss);
            selectedImage.setImageResource(R.drawable.cliche);
            selectedText.setText("Cliche Workshop");
        }
        if (data.getWorkshop().equals("dnet")) {
            selectedWorkshop = "dnet";
            cliche.setImageResource(R.drawable.cliche);
            dnet.setImageResource(R.drawable.dnets);
            sugarrush.setImageResource(R.drawable.sugarrush);
            pharopell.setImageResource(R.drawable.pharopell);
            laypuzz.setImageResource(R.drawable.laypuzz);
            legoss.setImageResource(R.drawable.legoss);
            selectedImage.setImageResource(R.drawable.dnet);
            selectedText.setText("Triple Double U : Are you considering web development as a career? Do you simply want to learn to create your own web sites but don't know where to start? \n" +
                    "This is the right place for you to discover the dos and don'ts for designing for the web and learn how to create exciting and effective website designs & how to create responsive websites that deliver a message to any screen size. Don't hesitate to join us.");
        }

        if(!data.getLogin()){
            info.setActivated(false);
            info.setScaleY(0);
            info.setScaleX(0);
        }

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "Place : " + data.getWorkshopPlaceName(selectedWorkshop) + "\n" + "Time : " + data.getWorkshopTime(selectedWorkshop);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                if (!data.getWorkshopPlaceMap(selectedWorkshop).equals("N/A")) {
                    builder.setNegativeButton("Get Location", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getWorkshopPlaceMap(selectedWorkshop)));
                            startActivity(intent);
                        }
                    });
                }
                if(data.getWorkshopPlaceName(selectedWorkshop).equals("N/A"))
                    s = "No Available Data Yet";
                AlertDialog dialog = builder.create();
                dialog.setMessage(s);
                dialog.show();
            }
        });

        dnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "dnet";
                cliche.setImageResource(R.drawable.cliche);
                dnet.setImageResource(R.drawable.dnets);
                sugarrush.setImageResource(R.drawable.sugarrush);
                pharopell.setImageResource(R.drawable.pharopell);
                laypuzz.setImageResource(R.drawable.laypuzz);
                legoss.setImageResource(R.drawable.legoss);
                selectedImage.setImageResource(R.drawable.dnet);
                selectedText.setText("Triple Double U : Are you considering web development as a career? Do you simply want to learn to create your own web sites but don't know where to start? \n" +
                        "This is the right place for you to discover the dos and don'ts for designing for the web and learn how to create exciting and effective website designs & how to create responsive websites that deliver a message to any screen size. Don't hesitate to join us.");
            }
        });

        cliche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "cliche";
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
                selectedWorkshop = "laypuzz";
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
                selectedWorkshop = "legos";
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
                selectedWorkshop = "pharopell";
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
                selectedWorkshop = "sugarrush";
                cliche.setImageResource(R.drawable.cliche);
                dnet.setImageResource(R.drawable.dnet);
                sugarrush.setImageResource(R.drawable.sugarrushs);
                pharopell.setImageResource(R.drawable.pharopell);
                laypuzz.setImageResource(R.drawable.laypuzz);
                legoss.setImageResource(R.drawable.legoss);
                selectedImage.setImageResource(R.drawable.sugarrush);
                selectedText.setText("Hello Nougat : It’s COMPASS’17’s android workshop, the objective of this workshop is fairly simple, to show you guys how an android application works, how to make a great looking android application from scratch and the knowledge necessary to do so, but of course with a touch of fun, the way that COMPASS has always done it.");
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
