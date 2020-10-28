package com.example.nihao.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.nihao.fragment.TaoFragment;

import java.util.ArrayList;

public class ShouYeAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<String> title;

    public ShouYeAdapter(FragmentManager fm,ArrayList<Fragment> fragments,ArrayList<String> title) {
        super(fm);
        this.fragments=fragments;
        this.title=title;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
