package com.android.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    private  int numOftabs;
    PageAdapter(FragmentManager fm,int numOftabs)
    {
      super(fm);
      this.numOftabs=numOftabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return new  ChatFragment();
            case 1:
                return new StatusFragment();
            case  2:
                return new CallFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numOftabs;
    }
}
