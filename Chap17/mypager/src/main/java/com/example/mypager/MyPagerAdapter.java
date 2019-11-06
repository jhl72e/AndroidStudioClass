package com.example.mypager;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;
    String[] titles = new String[]{"OneFragment", "TwoFragment", "DetailFragment", "OneFragment", "OneFragment"};
    public MyPagerAdapter(FragmentManager fm)
    {
        super(fm);
        fragments = new ArrayList<Fragment>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new DetailFragment());
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());

    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
