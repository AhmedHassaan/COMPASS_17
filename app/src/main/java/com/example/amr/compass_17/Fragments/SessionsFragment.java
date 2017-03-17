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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    static Animation animation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sessions_fragment, container, false);
        ButterKnife.bind(this, view);
        data = new Users(getActivity());
        animation = AnimationUtils.loadAnimation(getActivity(),R.anim.workshop_selected);
        selectedText.setMovementMethod(new ScrollingMovementMethod());
        if (data.getWorkshop().equals("nougat")) {
            selectedWorkshop = "nougat";
            reset();
            selectSession(nougat);
            selectedImage.setImageResource(R.drawable.nougat);
            selectedText.setText("This is Android Workshop");
        }
        if (data.getWorkshop().equals("photoshop")) {
            selectedWorkshop = "photoshop";
            reset();
            selectSession(photoshop);
            selectedImage.setImageResource(R.drawable.photoshop);
            selectedText.setText("This is Photoshop Workshop");
        }
        if (data.getWorkshop().equals("triple")) {
            selectedWorkshop = "triple";
            reset();
            selectSession(trible);
            selectedImage.setImageResource(R.drawable.trible);
            selectedText.setText("This is web workshop");
        }
        if (data.getWorkshop().equals("smily")) {
            selectedWorkshop = "smily";
            reset();
            selectSession(smily);
            selectedImage.setImageResource(R.drawable.smily);
            selectedText.setText("This is PR workshop");
        }
        if (data.getWorkshop().equals("ulalia")) {
            selectedWorkshop = "ulalia";
            reset();
            selectSession(ulalia);
            selectedImage.setImageResource(R.drawable.ulalia);
            selectedText.setText("This is Marketing workshop");
        }
        if (data.getWorkshop().equals("topaz")) {
            selectedWorkshop = "topaz";
            reset();
            selectSession(topaz);
            selectedImage.setImageResource(R.drawable.topaz);
            selectedText.setText("This is Creativity workshop");
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
                selectSession(trible);
                selectedImage.setImageResource(R.drawable.trible);
                selectedText.setText("This is web workshop");
            }
        });

        nougat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "nougat";
                reset();
                selectSession(nougat);
                selectedImage.setImageResource(R.drawable.nougat);
                selectedText.setText("This is Android workshop");}
        });
        topaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "topaz";
                reset();
                selectSession(topaz);
                selectedImage.setImageResource(R.drawable.topaz);
                selectedText.setText("This is Creativity workshop");
            }
        });
        ulalia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "ulalia";
                reset();
                selectSession(ulalia);
                selectedImage.setImageResource(R.drawable.ulalia);
                selectedText.setText("This is Marketing workshop");
            }
        });
        photoshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "photoshop";
                reset();
                selectSession(photoshop);
                selectedImage.setImageResource(R.drawable.photoshop);
                selectedText.setText("This is Photoshop workshop");
            }
        });
        smily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedWorkshop = "smily";
                reset();
                selectSession(smily);
                selectedImage.setImageResource(R.drawable.smily);
                selectedText.setText("This is PR workshop");
            }
        });
        return view;
    }

    public void reset(){
        topaz.setImageResource(R.drawable.topaz);
        nougat.setBackgroundResource(0);
        topaz.setBackgroundResource(0);
        photoshop.setBackgroundResource(0);
        smily.setBackgroundResource(0);
        ulalia.setBackgroundResource(0);
        trible.setBackgroundResource(0);
        trible.setImageResource(R.drawable.trible);
        nougat.setImageResource(R.drawable.nougat);
        smily.setImageResource(R.drawable.smily);
        photoshop.setImageResource(R.drawable.photoshop);
        ulalia.setImageResource(R.drawable.ulalia);
    }

    public void selectSession(View view){
        view.setBackgroundResource(R.drawable.ring);
        view.startAnimation(animation);
    }
}
