package com.android.mky95.timetable;

import android.support.v4.app.FragmentActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.List;

/**
 * Created by mahesh on 10/4/16.
 */
public class DayPagerActivity extends FragmentActivity {
    private static final String TAG = "day_pager";
    private static final String EXTRA_DAY = "com.android.mky95.timetable.day";
    private ViewPager mViewPager;
    private List<DayRoutine> mDayRoutines;

    public static  Intent newIntent(Context packageContext, String day){
        Intent intent = new Intent(packageContext, DayPagerActivity.class);
        intent.putExtra(EXTRA_DAY, day);

        return intent;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_pager_view);

        Log.d(TAG, "CrimePager running");
        mDayRoutines = TimeTableWrapper.get(this).getDayRoutines();
        mViewPager = (ViewPager) findViewById(R.id.day_pager_view_time_table);
        String day = getIntent().getSerializableExtra(EXTRA_DAY).toString();

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                DayRoutine dayRoutine = mDayRoutines.get(position);
                return DayRoutineFragment.newInstance(dayRoutine.getDay());
            }

            @Override
            public int getCount() {
                return mDayRoutines.size();
            }
        });


        for(int i = 0; i < mDayRoutines.size(); i++){
            if(mDayRoutines.get(i).getDay().equals(day)){
                mViewPager.setCurrentItem(i);
            }
        }
    }


}
