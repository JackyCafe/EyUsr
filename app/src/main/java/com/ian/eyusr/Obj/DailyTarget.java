package com.ian.eyusr.Obj;

import java.io.Serializable;

public class DailyTarget implements Serializable {
    private long id ;
    private long activity_id;
    private String activity_target;
    private String date;
    private int score;

    public DailyTarget(){

    }

    public DailyTarget(long activity_id, String activity_target, String date, int score) {
        this.activity_id = activity_id;
        this.activity_target = activity_target;
        this.date = date;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(long activity_id) {
        this.activity_id = activity_id;
    }

    public String getActivity_target() {
        return activity_target;
    }

    public void setActivity_target(String activity_target) {
        this.activity_target = activity_target;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "DailyTarget{" +
                "id=" + id +
                ", activity_id=" + activity_id +
                ", activity_target='" + activity_target + '\'' +
                ", date='" + date + '\'' +
                ", score=" + score +
                '}';
    }
}
