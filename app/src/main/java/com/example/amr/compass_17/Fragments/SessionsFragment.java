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


    @Bind(R.id.nougat)
    ImageButton nougat;
    @Bind(R.id.trible)
    ImageButton trible;
    @Bind(R.id.photoshop)
    ImageButton photoshop;
    @Bind(R.id.smily)
    ImageButton smily;
    @Bind(R.id.topaz)
    ImageButton topaz;
    @Bind(R.id.ulalia)
    ImageButton ulalia;
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
        if (data.getWorkshop().equals("nougat")) {
            selectedWorkshop = "nougat";
            reset();
            nougat.setImageResource(R.drawable.nougats);
//            nougat.setBackgroundResource(R.drawable.ring);
            selectedImage.setImageResource(R.drawable.nougat);
            selectedText.setText("Hello Nougat : It’s COMPASS’17’s android workshop, the objective of this workshop is fairly simple, to show you guys how an android application works, how to make a great looking android application from scratch and the knowledge necessary to do so, but of course with a touch of fun, the way that COMPASS has always done it.");
        }
        if (data.getWorkshop().equals("photoshop")) {
            selectedWorkshop = "photoshop";
            reset();
            photoshop.setImageResource(R.drawable.photoshops);
//            photoshop.setBackgroundResource(R.drawable.ring);
            selectedImage.setImageResource(R.drawable.photoshop);
            selectedText.setText("Photoshop Workshop");
        }
        if (data.getWorkshop().equals("trible")) {
            selectedWorkshop = "trible";
            reset();
            trible.setImageResource(R.drawable.tribles);
//            trible.setBackgroundResource(R.drawable.ring);
            selectedImage.setImageResource(R.drawable.trible);
            selectedText.setText("Triple double U Workshop");
        }
        if (data.getWorkshop().equals("smily")) {
            selectedWorkshop = "smily";
            reset();
            smily.setImageResource(R.drawable.smilys);
//            smily.setBackgroundResource(R.drawable.ring);
            selectedImage.setImageResource(R.drawable.smily);
            selectedText.setText("Smiley Face Workshop");
        }
        if (data.getWorkshop().equals("ulalia")) {
            selectedWorkshop = "ulalia";
            reset();
            ulalia.setImageResource(R.drawable.ulalias);
//            ulalia.setBackgroundResource(R.drawable.ring);
            selectedImage.setImageResource(R.drawable.ulalia);
            selectedText.setText("Ulalia Workshop");
        }
        if (data.getWorkshop().equals("topaz")) {
            selectedWorkshop = "topaz";
            reset();
            topaz.setImageResource(R.drawable.topazs);
//            topaz.setBackgroundResource(R.drawable.ring);
            selectedImage.setImageResource(R.drawable.topaz);
            selectedText.setText("Topaz Workshop");
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

        trible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "trible";
                reset();
                trible.setImageResource(R.drawable.tribles);
//                trible.setBackgroundResource(R.drawable.ring);
                selectedImage.setImageResource(R.drawable.trible);
                selectedText.setText("Triple double U Workshop");
            }
        });

        nougat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "nougat";
                reset();
                nougat.setImageResource(R.drawable.nougats);
//                nougat.setBackgroundResource(R.drawable.ring);
                selectedImage.setImageResource(R.drawable.nougat);
                selectedText.setText("Hello Nougat : It’s COMPASS’17’s android workshop, the objective of this workshop is fairly simple, to show you guys how an android application works, how to make a great looking android application from scratch and the knowledge necessary to do so, but of course with a touch of fun, the way that COMPASS has always done it.");
            }
        });
        topaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "topaz";
                reset();
                topaz.setImageResource(R.drawable.topazs);
//                topaz.setBackgroundResource(R.drawable.ring);
                selectedImage.setImageResource(R.drawable.topaz);
                selectedText.setText("Topaz Workshop");
            }
        });
        ulalia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "ulalia";
                reset();
                ulalia.setImageResource(R.drawable.ulalias);
//                ulalia.setBackgroundResource(R.drawable.ring);
                selectedImage.setImageResource(R.drawable.ulalia);
                selectedText.setText("Ulalia Workshop");
            }
        });
        photoshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "photoshop";
                reset();
                photoshop.setImageResource(R.drawable.photoshops);
//                photoshop.setBackgroundResource(R.drawable.ring);
                selectedImage.setImageResource(R.drawable.photoshop);
                selectedText.setText("Photoshop Workshop");
            }
        });
        smily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "smily";
                reset();
                smily.setImageResource(R.drawable.smilys);
//                smily.setBackgroundResource(R.drawable.ring);
                selectedImage.setImageResource(R.drawable.smily);
                selectedText.setText("Smiley Face Workshop");
            }
        });
        return view;
    }

    public void reset(){
        topaz.setImageResource(R.drawable.topaz);
//        nougat.setBackgroundResource(0);
//        topaz.setBackgroundResource(0);
//        photoshop.setBackgroundResource(0);
//        smily.setBackgroundResource(0);
//        ulalia.setBackgroundResource(0);
//        trible.setBackgroundResource(0);
        trible.setImageResource(R.drawable.trible);
        nougat.setImageResource(R.drawable.nougat);
        smily.setImageResource(R.drawable.smily);
        photoshop.setImageResource(R.drawable.photoshop);
        ulalia.setImageResource(R.drawable.ulalia);
    }
}
