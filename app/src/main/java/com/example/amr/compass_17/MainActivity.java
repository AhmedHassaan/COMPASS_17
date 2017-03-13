package com.example.amr.compass_17;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.amr.compass_17.Adapters.MyFragmentPageAdapter;
import com.example.amr.compass_17.Fragments.AboutUsFragment;
import com.example.amr.compass_17.Fragments.HomeFragment;
import com.example.amr.compass_17.Fragments.SessionsFragment;
import com.example.amr.compass_17.data.ControlRealm;
import com.example.amr.compass_17.data.Users;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final int HOMEICON_POSTION = 0;
    final int WORKSHOPICON_POSTION = 1;
    final int ABOUTUS_POSTION = 2;
    ViewPager mPager;
    Toolbar toolbar;
    ControlRealm realm;
    String workshop;
    Users data;
    DatabaseReference db;
    ImageView homeIcon, aboutusIcon, workshopIcon;
    int[] selectedImages = {R.drawable.home_selected, R.drawable.workshop_selected, R.drawable.aboutus_selected};
    int[] unSelectedImages = {R.drawable.home_unselected, R.drawable.workshop_unselected, R.drawable.aboutus_unselected};
    int[] images = {R.drawable.home_selected, R.drawable.workshop_unselected, R.drawable.aboutus_unselected};
    Menu myMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = new ControlRealm(getApplicationContext());
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        db = FirebaseDatabase.getInstance().getReference();
        setSupportActionBar(toolbar);
        data = new Users(this);
        if (getIntent().getExtras() != null) {
            Bundle b = getIntent().getExtras();
            String s = b.getString("p");
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        }
        setViewPager();
        workshop = data.getWorkshop();
        if(data.getLogin() && !data.getFirstMessageSync()){
            data.setFirstMessageSync();
            DatabaseReference db1 = db.child("Message").child(workshop);
            db1.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    realm.setMessage(dataSnapshot.getValue(String.class),workshop);
                    data.setLastMessage(dataSnapshot.getValue(String.class));
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
        }

        if(!data.getFirstWorkshopSync()){
            data.setFirstWorkshopSync();
            DatabaseReference workshopref = db.child("Workshop").child("android");
            workshopref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    switch (dataSnapshot.getKey()){
                        case "map":
                            data.setWorkshopPlaceMap(dataSnapshot.getValue(String.class),"android");
                            break;
                        case "name":
                            data.setWorkshopPlaceName(dataSnapshot.getValue(String.class),"android");
                            break;
                        case "time":
                            data.setWorkshopTime(dataSnapshot.getValue(String.class),"android");
                            break;
                        default:
                            break;
                    }
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
            workshopref = db.child("Workshop").child("triple");
            workshopref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    switch (dataSnapshot.getKey()){
                        case "map":
                            data.setWorkshopPlaceMap(dataSnapshot.getValue(String.class),"triple");
                            break;
                        case "name":
                            data.setWorkshopPlaceName(dataSnapshot.getValue(String.class),"triple");
                            break;
                        case "time":
                            data.setWorkshopTime(dataSnapshot.getValue(String.class),"triple");
                            break;
                        default:
                            break;
                    }
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
            workshopref = db.child("Workshop").child("topaz");
            workshopref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    switch (dataSnapshot.getKey()){
                        case "map":
                            data.setWorkshopPlaceMap(dataSnapshot.getValue(String.class),"topaz");
                            break;
                        case "name":
                            data.setWorkshopPlaceName(dataSnapshot.getValue(String.class),"topaz");
                            break;
                        case "time":
                            data.setWorkshopTime(dataSnapshot.getValue(String.class),"topaz");
                            break;
                        default:
                            break;
                    }
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
            workshopref = db.child("Workshop").child("smiley");
            workshopref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    switch (dataSnapshot.getKey()){
                        case "map":
                            data.setWorkshopPlaceMap(dataSnapshot.getValue(String.class),"smiley");
                            break;
                        case "name":
                            data.setWorkshopPlaceName(dataSnapshot.getValue(String.class),"smiley");
                            break;
                        case "time":
                            data.setWorkshopTime(dataSnapshot.getValue(String.class),"smiley");
                            break;
                        default:
                            break;
                    }
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
            workshopref = db.child("Workshop").child("photoshop");
            workshopref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    switch (dataSnapshot.getKey()){
                        case "map":
                            data.setWorkshopPlaceMap(dataSnapshot.getValue(String.class),"photoshop");
                            break;
                        case "name":
                            data.setWorkshopPlaceName(dataSnapshot.getValue(String.class),"photoshop");
                            break;
                        case "time":
                            data.setWorkshopTime(dataSnapshot.getValue(String.class),"photoshop");
                            break;
                        default:
                            break;
                    }
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
            workshopref = db.child("Workshop").child("ulalia");
            workshopref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    switch (dataSnapshot.getKey()){
                        case "map":
                            data.setWorkshopPlaceMap(dataSnapshot.getValue(String.class),"ulalia");
                            break;
                        case "name":
                            data.setWorkshopPlaceName(dataSnapshot.getValue(String.class),"ulalia");
                            break;
                        case "time":
                            data.setWorkshopTime(dataSnapshot.getValue(String.class),"ulalia");
                            break;
                        default:
                            break;
                    }
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
        }

    }

    void setViewPager() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new SessionsFragment());
        fragmentList.add(new AboutUsFragment());


        mPager = (ViewPager) findViewById(R.id.pager);
        homeIcon = (ImageView) findViewById(R.id.home_icon);
        workshopIcon = (ImageView) findViewById(R.id.workshop_icon);
        aboutusIcon = (ImageView) findViewById(R.id.aboutus_icon);
        setImages();

        imagesOnClickListener();

        mPager.setAdapter(new MyFragmentPageAdapter(getSupportFragmentManager(), fragmentList));

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setUnSelectedImages();
                setSelectedImage(position);
                setImages();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    void setUnSelectedImages() {
        for (int i = 0; i < unSelectedImages.length; i++) {
            images[i] = unSelectedImages[i];
        }
    }

    void setSelectedImage(int postion) {
        images[postion] = selectedImages[postion];
    }

    void setImages() {
        homeIcon.setImageResource(images[HOMEICON_POSTION]);
        workshopIcon.setImageResource(images[WORKSHOPICON_POSTION]);
        aboutusIcon.setImageResource(images[ABOUTUS_POSTION]);
    }

    void imagesOnClickListener() {
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUnSelectedImages();
                setSelectedImage(HOMEICON_POSTION);
                setImages();
                mPager.setCurrentItem(HOMEICON_POSTION);
            }
        });

        workshopIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUnSelectedImages();
                setSelectedImage(WORKSHOPICON_POSTION);
                setImages();
                mPager.setCurrentItem(WORKSHOPICON_POSTION);
            }
        });

        aboutusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUnSelectedImages();
                setSelectedImage(ABOUTUS_POSTION);
                setImages();
                mPager.setCurrentItem(ABOUTUS_POSTION);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.comm,menu);
        myMenu = menu;
        if(!data.getLogin())
            if(myMenu!=null)
                myMenu.getItem(0).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.comm){
            startActivity(new Intent(this,Comm_Activity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        System.exit(0);
    }

}