package com.android.mky95.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by mahesh on 10/4/16.
 */
public class NewDayRoutineFragment extends Fragment {
    private static final String TAG = "NewDayRoutine";
    private static final String ADD_UPDATE_ARG="add or upgrade";
    private String doThis;
    private EditText day;
    private EditText timeSlot1;
    private EditText timeSlot2;
    private EditText timeSlot3;
    private EditText timeSlot4;
    private EditText timeSlot5;
    private EditText timeSlot6;
    private EditText timeSlot7;
    private EditText timeSlot8;
    private Button confirmButton;

    private DayRoutine mDayRoutine;

    public static NewDayRoutineFragment newInstance(String doThis){
        Bundle args = new Bundle();
        args.putSerializable(ADD_UPDATE_ARG, doThis);
        NewDayRoutineFragment fragment = new NewDayRoutineFragment();
        fragment.setArguments(args);

        return fragment;
    }

@Override
    public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    doThis = getArguments().getSerializable(ADD_UPDATE_ARG).toString();
}

@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    View view = inflater.inflate(R.layout.new_day_routine_fragment,container,false);

    mDayRoutine = new DayRoutine();

    day = (EditText) view.findViewById(R.id.edit_day);
    timeSlot1 = (EditText) view.findViewById(R.id.time_edit_slot_1);
    timeSlot2 = (EditText) view.findViewById(R.id.time_edit_slot_2);
    timeSlot3 = (EditText) view.findViewById(R.id.time_edit_slot_3);
    timeSlot4 = (EditText) view.findViewById(R.id.time_edit_slot_4);
    timeSlot5 = (EditText) view.findViewById(R.id.time_edit_slot_5);
    timeSlot6 = (EditText) view.findViewById(R.id.time_edit_slot_6);
    timeSlot7 = (EditText) view.findViewById(R.id.time_edit_slot_7);
    timeSlot8 = (EditText) view.findViewById(R.id.time_edit_slot_8);
    confirmButton = (Button) view.findViewById(R.id.confirm_button);
    if(!doThis.equals("add")){
        day.setText(doThis);
    }
    confirmButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            updateRoutine();
        }
    });
    return view;

}
    private void updateRoutine(){
        mDayRoutine.setDay(day.getText().toString());
        mDayRoutine.setTimeSlot1(timeSlot1.getText().toString());
        mDayRoutine.setTimeSlot2(timeSlot2.getText().toString());
        mDayRoutine.setTimeSlot3(timeSlot3.getText().toString());
        mDayRoutine.setTimeSlot4(timeSlot4.getText().toString());
        mDayRoutine.setTimeSlot5(timeSlot5.getText().toString());
        mDayRoutine.setTimeSlot6(timeSlot6.getText().toString());
        mDayRoutine.setTimeSlot7(timeSlot7.getText().toString());
        mDayRoutine.setTimeSlot8(timeSlot8.getText().toString());

        if(doThis.equals("add")){
            Log.v(TAG,"adding new Routine");
            TimeTableWrapper.get(getActivity()).addDayRoutine(mDayRoutine);

        }else{
            TimeTableWrapper.get(getActivity()).updateDayRoutine(mDayRoutine);
        }

        Intent intent = DayPagerActivity.newIntent(getActivity(), day.toString());
        startActivity(intent);
    }

}
