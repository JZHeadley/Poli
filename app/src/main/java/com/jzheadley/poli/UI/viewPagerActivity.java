package com.jzheadley.poli.UI;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Menu;
import android.view.MenuItem;

import com.jzheadley.poli.R;

public class viewPagerActivity extends FragmentPagerAdapter {
    private static int NUM_ITEMS= 12;

    public viewPagerActivity(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
   public Fragment getItem(int position){
        switch (position) {
            case 0:
                return ArrayListFragment;
        }
    }


}
