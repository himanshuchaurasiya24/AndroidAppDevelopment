package com.chaurasiya.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerMessengerAdapter extends FragmentPagerAdapter {
    public ViewPagerMessengerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // in this method define at what position which fragment will load
        // it takes position and returns Fragments;
        if (position==0) {
            return new ChatFragment();
        }
        else if (position==1) {
            return new StatusFragment();
        }
        else {
            return new CallsFragment();
        }

    }

    @Override
    public int getCount() {
        return 3; // here in return count give the number of your tabLayout;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) { // to set the title of the fragment
        if (position==0)
            return "Chats";
        else if (position==1)
            return "Status";
        else
            return "Calls";
    }
}
