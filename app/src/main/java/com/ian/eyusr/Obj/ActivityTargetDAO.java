package com.ian.eyusr.Obj;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ActivityTargetDAO {

    public static final String  TABLE_NAME = "ACTIVITY_TARGET" ;
    public static String id_column = "_id";
    public static String activity_column = "activity";
    public static String finish_column = "finish";
    public static String nonfinish_column = "non_finish";
    public SQLiteDatabase db;

    public static final String  CREATE_TABLE = " CREATE TABLE " + TABLE_NAME +"("+
            id_column + " Integer primary key autoincrement, " +
            activity_column+" TEXT, "+
            finish_column+" INTEGER,"+
            nonfinish_column+" INTEGER "+
            ")"  ;

    public ActivityTargetDAO(Context context) {
        db = DBHelp.getDatabse(context);
    }

    public ActivityTarget insert(ActivityTarget target){
        ContentValues cv = new ContentValues();
//        cv.put(id_column,target.getId());
        cv.put(activity_column,target.getActivity_target());
        cv.put(finish_column,target.getActivity_finish());
        cv.put(nonfinish_column,target.getNonactivity_finish());
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

    public List<ActivityTarget> getAll(){
        List<ActivityTarget> activityTargets = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME,null,null
                ,null,null,null,null);
        while (cursor.moveToNext()){
            activityTargets.add(getRecord(cursor));
        }
        return activityTargets;
    }

    @SuppressLint("Range")
    public ActivityTarget getRecord(Cursor cursor){
        ActivityTarget activityTarget = new ActivityTarget();
        activityTarget.setActivity_target(cursor.getString(cursor.getColumnIndex(activity_column)));
        activityTarget.setActivity_finish(cursor.getInt(cursor.getColumnIndex(finish_column)));
        activityTarget.setActivity_finish(cursor.getInt(cursor.getColumnIndex(nonfinish_column)));
        return activityTarget;
    }

    public void  sample(){
        List<ActivityTarget> targets = new ArrayList<>();
         targets.add(new ActivityTarget("雙腳平放於地上，站起來再坐下來\n（10 次）\n",2,1));
         targets.add(new ActivityTarget("雙腳平放於地上，一腳先伸直再把腳板翹起來，再往下踩\n（10 次）\n",2,1));
         targets.add(new ActivityTarget("雙腳平放於地上，站起來且雙腳微開，屈膝撐一下\n（10 次）\n",2,1));
         targets.add(new ActivityTarget("雙腳平放於地上，一腳先伸直，撐個幾秒再放下\n（10 次）\n",2,1));
         targets.add(new ActivityTarget("雙手放置於胸前，站起來再坐下來\n（10 次）\n",2,1));

        targets.add(new ActivityTarget("雙腳平放於地上，手拿裝水的寶特瓶，手肘屈曲再放下\n（10 次）\n",2,1));
        targets.add(new ActivityTarget("雙腳平放於地上，一腳抬起來再換另一腳\n（10 次）\n",2,1));
        targets.add(new ActivityTarget("雙腳平放於地上，手側舉裝水的寶特瓶至旁邊再回來\n（10 次）\n",2,1));
        targets.add(new ActivityTarget("一腳抬起來，再換另一腳\n（10 次）\n",2,1));
        targets.add(new ActivityTarget("站於椅子後面，踮起腳尖撐一下再回來\n（10 次）\n",2,1));

        targets.add(new ActivityTarget("站在椅子後面，手扶在椅子上，一側腳從側邊抬離地面撐一下\n（10 次）\n",2,1));
        targets.add(new ActivityTarget("站於椅子後面，一腳先彎起來，手抓在彎起來的那一腳，撐一下\n（10 次）\n",2,1));
        targets.add(new ActivityTarget("雙腳平放於地上，站起來再坐下來\n（10 次）\n",2,1));
        targets.add(new ActivityTarget("雙腳平放於地上，一腳先伸直，撐個幾秒再放下\n（10 次）\n",2,1));
        targets.add(new ActivityTarget("雙腳平放於地上，一腳抬起來再換另一腳\n（10 次）\n",2,1));
        for (ActivityTarget a :targets)
        {
            insert(a);
        }

    }

}
