package com.example.location;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by Administrator on 2016/4/3.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    public final int TOTAL =4;

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Log.w("FragmentList", "getItem " + i);
        return MyListFragment.newInstance(i);

    }

    @Override
    public int getCount() {
        return TOTAL;
    }
}
