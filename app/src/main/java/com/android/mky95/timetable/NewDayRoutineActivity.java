package com.android.mky95.timetable;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by mahesh on 10/4/16.
 */
public class NewDayRoutineActivity extends SingleFragmentActivity{
    private static final String NEW_ROUTINE_ACTIVITY = "new routine activity";
    private static final String EXTRA_ADD_OR_UPDATE = "addOrUpdate";

    public static Intent newIntent(Context packageContext, String doThis){
        Intent intent = new Intent(packageContext, NewDayRoutineActivity.class);
        intent.putExtra(EXTRA_ADD_OR_UPDATE, doThis);

        return intent;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    protected Fragment createFragment(){
        String doThis = getIntent().getSerializableExtra(EXTRA_ADD_OR_UPDATE).toString();
        Log.d(NEW_ROUTINE_ACTIVITY, doThis);

        return NewDayRoutineFragment.newInstance(doThis);
    }
}
