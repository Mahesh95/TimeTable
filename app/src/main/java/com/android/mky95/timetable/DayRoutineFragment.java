package com.android.mky95.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mahesh on 10/4/16.
 */
public class DayRoutineFragment extends Fragment {
    private static final String DAY_ARG = "day";
    private DayRoutine mDayRoutine;
    private TextView day;
    private TextView daySlot1;
    private TextView daySlot2;
    private TextView daySlot3;
    private TextView daySlot4;
    private TextView daySlot5;
    private TextView daySlot6;
    private TextView daySlot7;
    private TextView daySlot8;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.day_routine_fragment_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_item_new_day_routine);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_day_routine:
                Intent intent = NewDayRoutineActivity.newIntent(getActivity(),"add");
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    public static DayRoutineFragment newInstance(String day){
        Bundle args = new Bundle();
        args.putSerializable(DAY_ARG, day);

        DayRoutineFragment dayRoutineFragment = new DayRoutineFragment();
        dayRoutineFragment.setArguments(args);

        return dayRoutineFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        String day = getArguments().getSerializable(DAY_ARG).toString();
        mDayRoutine = TimeTableWrapper.get(getActivity()).getDayRoutine(day);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.day_routine_fragment, container, false);
        day = (TextView) v.findViewById(R.id.day_text_view);
        daySlot1 = (TextView) v.findViewById(R.id.time_slot_1);
        daySlot2 = (TextView) v.findViewById(R.id.time_slot_2);
        daySlot3 = (TextView) v.findViewById(R.id.time_slot_3);
        daySlot4 = (TextView) v.findViewById(R.id.time_slot_4);
        daySlot5 = (TextView) v.findViewById(R.id.time_slot_5);
        daySlot6 = (TextView) v.findViewById(R.id.time_slot_6);
        daySlot7 = (TextView) v.findViewById(R.id.time_slot_7);
        daySlot8 = (TextView) v.findViewById(R.id.time_slot_8);

        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = NewDayRoutineActivity.newIntent(getActivity(), day.getText().toString());
                startActivity(intent);
            }
        });

        updateUI();

        return v;
    }

    private void updateUI(){
        day.setText(mDayRoutine.getDay());
        daySlot1.setText(mDayRoutine.getTimeSlot1());
        daySlot2.setText(mDayRoutine.getTimeSlot2());
        daySlot3.setText(mDayRoutine.getTimeSlot3());
        daySlot4.setText(mDayRoutine.getTimeSlot4());
        daySlot5.setText(mDayRoutine.getTimeSlot5());
        daySlot6.setText(mDayRoutine.getTimeSlot6());
        daySlot7.setText(mDayRoutine.getTimeSlot7());
        daySlot8.setText(mDayRoutine.getTimeSlot8());
    }
}

