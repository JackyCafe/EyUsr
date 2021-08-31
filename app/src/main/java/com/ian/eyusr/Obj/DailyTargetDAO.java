package com.ian.eyusr.Obj;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DailyTargetDAO {

    public static final String  TABLE_NAME = "DAILY_TARGET" ;
    public static String id_column = "_id";
    public static String activity_id_column = "activity_id";
    public static String activity_column = "activity";
    public static String date_column = "date";
    public static String score_column = "finish";
    public SQLiteDatabase db;

    public static final String  CREATE_TABLE = " CREATE TABLE " + TABLE_NAME +"("+
            id_column + " Integer primary key autoincrement, " +
            activity_id_column +" INTEGER,"+
            activity_column+" TEXT, "+
            date_column+" TEXT,"+
            score_column+" INTEGER "+
            ")"  ;

    public DailyTargetDAO(Context context) {
        db = DBHelp.getDatabse(context);
    }

    public DailyTarget insert(DailyTarget target){
        ContentValues cv = new ContentValues();
        cv.put(activity_id_column,target.getActivity_target());
        cv.put(activity_column,target.getActivity_target());
        cv.put(date_column,target.getDate());
        cv.put(score_column,target.getScore());
        long id = db.insert(TABLE_NAME,null,cv);
        target.setId(id);
        return  target;
    }

    public boolean delete(long id)
    {
        String where = id_column+" = "+id;
        db.delete(TABLE_NAME,where,null);
        return true;
    }

    public List<DailyTarget> getAll(){
        List<DailyTarget> dailyTargets = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null
                ,null,null,null,null);
        while (cursor.moveToNext()){
            dailyTargets.add(getRecord(cursor));
        }
        return dailyTargets;
    }

    @SuppressLint("Range")
    public int getScore(){
        int score = 0;
        List<DailyTarget> activityTargets = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null
                ,null,null,null,null);
        while (cursor.moveToNext()){
            score += cursor.getInt(cursor.getColumnIndex(score_column));
        }
        return score;
    }

    @SuppressLint("Range")
    public DailyTarget getRecord(Cursor cursor){
        DailyTarget dailyTarget = new DailyTarget();
        dailyTarget.setActivity_id(cursor.getInt(cursor.getColumnIndex(activity_id_column)));
        dailyTarget.setActivity_target(cursor.getString(cursor.getColumnIndex(activity_column)));
        dailyTarget.setDate(cursor.getString(cursor.getColumnIndex(date_column)));
        dailyTarget.setScore(cursor.getInt(cursor.getColumnIndex(score_column)));
        return dailyTarget;
    }



}
