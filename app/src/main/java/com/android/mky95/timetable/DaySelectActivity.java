package com.android.mky95.timetable;

import android.support.v4.app.Fragment;

/**
 * Created by mahesh on 10/4/16.
 */
public class DaySelectActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new DaySelectFragment();
    }


}
