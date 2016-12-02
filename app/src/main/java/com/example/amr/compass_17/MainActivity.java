package com.example.amr.compass_17;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.amr.compass_17.Fragments.AboutUsFragment;
import com.example.amr.compass_17.Fragments.HomeFragment;
import com.example.amr.compass_17.Adapters.MyFragmentPageAdapter;
import com.example.amr.compass_17.Fragments.SessionsFragment;
import com.example.amr.compass_17.SlideTabs.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager mPager;
    ImageView homeIcon,aboutusIcon,workshopIcon;

    final int HOMEICON_POSTION = 0;
    final int WORKSHOPICON_POSTION = 1;
    final int ABOUTUS_POSTION = 2;

    int[] selectedImages = {R.drawable.home_selected,R.drawable.workshop_selected,R.drawable.aboutus_selected};
    int[] unSelectedImages = {R.drawable.home_unselected,R.drawable.workshop_unselected,R.drawable.aboutus_unselected};
    int[] images = {R.drawable.home_selected,R.drawable.workshop_unselected,R.drawable.aboutus_unselected};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViewPager();
    }

    void setViewPager()
    {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new SessionsFragment());
        fragmentList.add(new AboutUsFragment());


        mPager = (ViewPager) findViewById(R.id.pager);
        homeIcon =(ImageView)findViewById(R.id.home_icon);
        workshopIcon =(ImageView)findViewById(R.id.workshop_icon);
        aboutusIcon =(ImageView)findViewById(R.id.aboutus_icon);

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

    void setUnSelectedImages()
    {
        for(int i = 0;i< unSelectedImages.length;i++)
        {
            images[i] = unSelectedImages[i];
        }
    }

    void setSelectedImage(int postion)
    {
        images[postion] = selectedImages[postion];
    }

    void setImages()
    {
        homeIcon.setImageResource(images[HOMEICON_POSTION]);
        workshopIcon.setImageResource(images[WORKSHOPICON_POSTION]);
        aboutusIcon.setImageResource(images[ABOUTUS_POSTION]);
    }

    void imagesOnClickListener()
    {
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
    public void onBackPressed() {
//        Intent intent = new Intent(MainActivity.this, SplashActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.putExtra("EXIT", true);
//        startActivity(intent);
        System.exit(0);


    }

}