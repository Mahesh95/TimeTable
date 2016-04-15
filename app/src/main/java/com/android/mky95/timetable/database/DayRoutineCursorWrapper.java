package com.android.mky95.timetable.database;

import android.database.CursorWrapper;
import android.database.Cursor;

import com.android.mky95.timetable.DayRoutine;

/**
 * Created by mahesh on 9/4/16.
 */
public class DayRoutineCursorWrapper extends CursorWrapper {

    public DayRoutineCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public DayRoutine getDayRoutine(){
        String day = getString(getColumnIndex(TimeTableSchema.TimeTable.Cols.DAY));
        String timeSlot1 = getString(getColumnIndex(TimeTableSchema.TimeTable.Cols.TIME_SLOT_1));
        String timeSlot2 = getString(getColumnIndex(TimeTableSchema.TimeTable.Cols.TIME_SLOT_2));
        String timeSlot3 = getString(getColumnIndex(TimeTableSchema.TimeTable.Cols.TIME_SLOT_3));
        String timeSlot4 = getString(getColumnIndex(TimeTableSchema.TimeTable.Cols.TIME_SLOT_4));
        String timeSlot5 = getString(getColumnIndex(TimeTableSchema.TimeTable.Cols.TIME_SLOT_5));
        String timeSlot6 = getString(getColumnIndex(TimeTableSchema.TimeTable.Cols.TIME_SLOT_6));
        String timeSlot7 = getString(getColumnIndex(TimeTableSchema.TimeTable.Cols.TIME_SLOT_7));
        String timeSlot8 = getString(getColumnIndex(TimeTableSchema.TimeTable.Cols.TIME_SLOT_8));

        DayRoutine dayRoutine = new DayRoutine();
        dayRoutine.setDay(day);
        dayRoutine.setTimeSlot1(timeSlot1);
        dayRoutine.setTimeSlot2(timeSlot2);
        dayRoutine.setTimeSlot3(timeSlot3);
        dayRoutine.setTimeSlot4(timeSlot4);
        dayRoutine.setTimeSlot5(timeSlot5);
        dayRoutine.setTimeSlot6(timeSlot6);
        dayRoutine.setTimeSlot7(timeSlot7);
        dayRoutine.setTimeSlot8(timeSlot8);

        return dayRoutine;
    }
}
