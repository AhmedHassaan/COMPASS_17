package com.example.amr.compass_17.Fragments;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import java.util.List;

/**
 * Created by abdel on 9/20/2016.
 */
public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;
    String[] tabsName;
    Drawable[] tabIcons;

    public MyFragmentPageAdapter(FragmentManager fm,List<Fragment> fragmentList,String[] tabsName,Drawable[] tabIcons) {
        super(fm);
        this.fragmentList = fragmentList;
        this.tabsName = tabsName;
        this.tabIcons = tabIcons;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        Drawable d = tabIcons[position];
        d.setBounds(0,0,100,100);

        ImageSpan imageSpan = new ImageSpan(d);
        SpannableString spannableString = new SpannableString(tabsName[position]);
        spannableString.setSpan(imageSpan,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
        //return tabsName[position];
    }

}
