/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.ui.homePageViewer
 * Date: 11/07/2020
 */

package com.marinumau.sabbia.ui.homePageViewer;


import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.marinumau.sabbia.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.home_tab_1, R.string.home_tab_2, R.string.home_tab_3};
    private final Context mContext;

    /**
     *
     * @param context the context
     * @param fm the fragment manager
     */
    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     *
     * @param position the current position in the view pager
     * @return the fragment for the given position
     */
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return HistoryFragment.newInstance(position + 1);
            case 1:
                return SavedFragment.newInstance(position + 1);
            default:
                return PromotedFragment.newInstance(position + 1);
        }

    }

    /**
     *
     * @param position the current position in the view pager
     * @return the title for the current tab
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    /**
     *
     * @return the item count
     */
    @Override
    public int getCount() {
        return 3;
    }
}
