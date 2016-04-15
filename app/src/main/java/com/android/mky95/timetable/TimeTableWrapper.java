package com.android.mky95.timetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.mky95.timetable.database.DayRoutineCursorWrapper;
import com.android.mky95.timetable.database.TimeTableSchema;
import com.android.mky95.timetable.database.TimeTabledbHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahesh on 10/4/16.
 */
public class TimeTableWrapper {

    private static TimeTableWrapper sTimeTableWrapper;
    private SQLiteDatabase mDatabase;
    private Context mContext;
    private static final String TAG ="TimeTableWrapper";


    private TimeTableWrapper(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new TimeTabledbHelper(context).getWritableDatabase();

        Log.d(TAG, "TimeTableWrapper created");
        DayRoutine dayRoutine = new DayRoutine();
        dayRoutine.setDay("monday");
        dayRoutine.setTimeSlot1("TCS");
        dayRoutine.setTimeSlot2("TCS");
        dayRoutine.setTimeSlot3("CS");
        dayRoutine.setTimeSlot4("MATHS");
        dayRoutine.setTimeSlot5("FREE");
        dayRoutine.setTimeSlot6("FREE");
        dayRoutine.setTimeSlot7("FREE");
        dayRoutine.setTimeSlot8("FREE");

        addDayRoutine(dayRoutine);
    }

    public List<DayRoutine> getDayRoutines(){
        List<DayRoutine> dayRoutines = new ArrayList<DayRoutine>();

        DayRoutineCursorWrapper cursor = queryDayRoutines(null, null);

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                dayRoutines.add(cursor.getDayRoutine());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }

        return dayRoutines;
    }

    public static TimeTableWrapper get(Context context){
        if(sTimeTableWrapper == null){
            sTimeTableWrapper = new TimeTableWrapper(context);
        }

        return sTimeTableWrapper;
    }

    public DayRoutine getDayRoutine(String day){

        DayRoutineCursorWrapper cursor = queryDayRoutines(TimeTableSchema.TimeTable.Cols.DAY
                + "=?", new String[]{day});
        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getDayRoutine();
        } finally {
            cursor.close();
        }
    }

    public void addDayRoutine(DayRoutine dayRoutine){

        ContentValues values = getContentValues(dayRoutine);
        mDatabase.insert(TimeTableSchema.TimeTable.NAME, null, values);
    }

    public void updateDayRoutine(DayRoutine dayRoutine){
        String day = dayRoutine.getDay();

        ContentValues values = getContentValues(dayRoutine);
        mDatabase.update(TimeTableSchema.TimeTable.NAME, values, TimeTableSchema.TimeTable.Cols.DAY +
    "=?", new String[]{day});

    }


    private static ContentValues getContentValues(DayRoutine dayRoutine){
        ContentValues values = new ContentValues();

        values.put(TimeTableSchema.TimeTable.Cols.DAY, dayRoutine.getDay());
        values.put(TimeTableSchema.TimeTable.Cols.TIME_SLOT_1, dayRoutine.getTimeSlot1());
        values.put(TimeTableSchema.TimeTable.Cols.TIME_SLOT_2, dayRoutine.getTimeSlot2());
        values.put(TimeTableSchema.TimeTable.Cols.TIME_SLOT_3, dayRoutine.getTimeSlot3());
        values.put(TimeTableSchema.TimeTable.Cols.TIME_SLOT_4, dayRoutine.getTimeSlot4());
        values.put(TimeTableSchema.TimeTable.Cols.TIME_SLOT_5, dayRoutine.getTimeSlot5());
        values.put(TimeTableSchema.TimeTable.Cols.TIME_SLOT_6, dayRoutine.getTimeSlot6());
        values.put(TimeTableSchema.TimeTable.Cols.TIME_SLOT_7, dayRoutine.getTimeSlot7());
        values.put(TimeTableSchema.TimeTable.Cols.TIME_SLOT_8, dayRoutine.getTimeSlot8());

        return values;
    }


    private DayRoutineCursorWrapper queryDayRoutines(String whereClause, String[] whereArg){
        Cursor cursor = mDatabase.query(TimeTableSchema.TimeTable.NAME,
                null,       //All columns are selected
                whereClause,
                whereArg,
                null,       // Group by
                null,       // Having
                null);      // Order by

        return new DayRoutineCursorWrapper(cursor);
    }
}

