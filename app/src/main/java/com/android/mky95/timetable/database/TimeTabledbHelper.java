package com.android.mky95.timetable.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mahesh on 9/4/16.
 */
public class TimeTabledbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "TimeTableWrapper.db";
    private static final int VERSION = 1;

    public TimeTabledbHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TIME_TABLE = "CREATE TABLE " + TimeTableSchema.TimeTable.NAME +
                "(" + TimeTableSchema.TimeTable.Cols.DAY + " TEXT PRIMARY KEY," +
                TimeTableSchema.TimeTable.Cols.TIME_SLOT_1 + " TEXT," +
                TimeTableSchema.TimeTable.Cols.TIME_SLOT_2 + " TEXT," +
                TimeTableSchema.TimeTable.Cols.TIME_SLOT_3 + " TEXT," +
                TimeTableSchema.TimeTable.Cols.TIME_SLOT_4 + " TEXT," +
                TimeTableSchema.TimeTable.Cols.TIME_SLOT_5 + " TEXT," +
                TimeTableSchema.TimeTable.Cols.TIME_SLOT_6 + " TEXT," +
                TimeTableSchema.TimeTable.Cols.TIME_SLOT_7 + " TEXT," +
                TimeTableSchema.TimeTable.Cols.TIME_SLOT_8 + " TEXT )";
        db.execSQL(CREATE_TIME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
