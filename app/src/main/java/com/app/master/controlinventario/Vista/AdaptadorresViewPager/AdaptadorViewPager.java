package com.app.master.controlinventario.Vista.AdaptadorresViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Rafael p on 23/6/2017.
 */

public class AdaptadorViewPager extends FragmentPagerAdapter {

    ArrayList<Fragment>fragments;

    public AdaptadorViewPager(FragmentManager fm,ArrayList<Fragment>fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
