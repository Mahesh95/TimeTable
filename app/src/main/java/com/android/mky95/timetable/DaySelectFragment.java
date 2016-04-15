package com.android.mky95.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.android.mky95.timetable.R;

import java.util.zip.Inflater;

/**
 * Created by mahesh on 9/4/16.
 */
public class DaySelectFragment extends Fragment {

    private TextView mMonTextview;
    private TextView mTueTextView;
    private TextView mWedTextView;
    private TextView mThuTextView;
    private TextView mFriTextView;


    private void goToPagerView(String day){
        Intent intent = DayPagerActivity.newIntent(getActivity(), day);
        startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.day_select_fragment, container, false);

        mMonTextview = (TextView) v.findViewById(R.id.monday_text_view);
        mTueTextView = (TextView) v.findViewById(R.id.tuesday_text_view);
        mWedTextView = (TextView) v.findViewById(R.id.wednesday_text_view);
        mThuTextView = (TextView) v.findViewById(R.id.thursday_text_view);
        mFriTextView = (TextView) v.findViewById(R.id.friday_text_view);

        mMonTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPagerView("monday");
            }
        });

        mTueTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToPagerView("tuesday");
            }
        });

        mWedTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToPagerView("wednesday");
            }
        });

        mThuTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToPagerView("thursday");
            }
        });

        mFriTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToPagerView("friday");
            }
        });
        return v;
    }


}
