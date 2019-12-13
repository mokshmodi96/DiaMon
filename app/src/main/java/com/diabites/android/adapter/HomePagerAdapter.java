
package com.diabites.android.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.diabites.R;
import com.diabites.android.fragment.AssistantFragment;
import com.diabites.android.fragment.HistoryFragment;
import com.diabites.android.fragment.OverviewFragment;



public class HomePagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private OverviewFragment overviewFragment;
    private HistoryFragment historyFragment;
//    private AssistantFragment assistantFragment;


    public HomePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
        overviewFragment = OverviewFragment.newInstance();
        historyFragment = HistoryFragment.newInstance();
//        assistantFragment = new AssistantFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return overviewFragment;
            case 1:
                return historyFragment;
            default:
                return overviewFragment;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    // Workaround to refresh views with notifyDataSetChanged()
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.tab_overview);
            case 1:
                return mContext.getString(R.string.tab_history);
            default:
                return mContext.getString(R.string.tab_overview);
        }
    }


    public OverviewFragment getOverviewFragment() {
        return overviewFragment;
    }

    public void setOverviewFragment(OverviewFragment overviewFragment) {
        this.overviewFragment = overviewFragment;
    }

    public HistoryFragment getHistoryFragment() {
        return historyFragment;
    }

    public void setHistoryFragment(HistoryFragment historyFragment) {
        this.historyFragment = historyFragment;
    }

//    public AssistantFragment getAssistantFragment() {
//        return assistantFragment;
//    }
//
//    public void setAssistantFragment(AssistantFragment assistantFragment) {
//        this.assistantFragment = assistantFragment;
//    }
}