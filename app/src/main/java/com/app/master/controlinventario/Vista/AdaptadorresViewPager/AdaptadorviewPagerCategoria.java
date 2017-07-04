package com.app.master.controlinventario.Vista.AdaptadorresViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Rafael p on 3/7/2017.
 */

public class AdaptadorviewPagerCategoria extends FragmentPagerAdapter {

    private ArrayList<Fragment>fragments;
    public AdaptadorviewPagerCategoria(FragmentManager fm,ArrayList<Fragment>fragments) {
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
