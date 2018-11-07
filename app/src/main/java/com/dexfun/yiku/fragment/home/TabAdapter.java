package com.dexfun.yiku.fragment.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Smile on 16/5/26.
 */
public class TabAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> strings;


    public TabAdapter(FragmentManager fm, List<Fragment> fragments, List<String> strings) {
        super(fm);
        this.fragments = fragments;
        this.strings = strings;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
//    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position % strings.size());
    }
}
