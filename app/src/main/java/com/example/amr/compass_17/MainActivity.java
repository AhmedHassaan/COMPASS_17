package com.example.amr.compass_17;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.amr.compass_17.Fragments.AboutUsFragment;
import com.example.amr.compass_17.Fragments.HomeFragment;
import com.example.amr.compass_17.Fragments.MyFragmentPageAdapter;
import com.example.amr.compass_17.Fragments.SessionsFragment;
import com.example.amr.compass_17.SlideTabs.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager mPager;
    SlidingTabLayout mTabs;

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
        fragmentList.add(new AboutUsFragment());
        fragmentList.add(new SessionsFragment());

        mPager = (ViewPager) findViewById(R.id.pager);

        String[] tabsName = {"Home","About Us","Sessions"};
        Drawable[] tabIcons = {
                getResources().getDrawable(R.drawable.compass)
                ,getResources().getDrawable(R.drawable.compass)
                ,getResources().getDrawable(R.drawable.compass)
        };
        mPager.setAdapter(new MyFragmentPageAdapter(getSupportFragmentManager(),fragmentList,tabsName,tabIcons));
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mTabs.setDistributeEvenly(true);
        mTabs.setCustomTabView(R.layout.custom_tab_view,R.id.tab_text);
        mTabs.setViewPager(mPager);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this, SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }

}

