package com.ian.eyusr.Obj;

import java.io.Serializable;

public class ActivityTarget implements Serializable {
    private long id ;
    private String activity_target;
    private int activity_finish;
    private int nonactivity_finish;

    public ActivityTarget(){

    }
    public ActivityTarget( String activity_target, int activity_finish, int nonactivity_finish) {

        this.activity_target = activity_target;
        this.activity_finish = activity_finish;
        this.nonactivity_finish = nonactivity_finish;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActivity_target() {
        return activity_target;
    }

    public void setActivity_target(String activity_target) {
        this.activity_target = activity_target;
    }

    public int getActivity_finish() {
        return activity_finish;
    }

    public void setActivity_finish(int activity_finish) {
        this.activity_finish = activity_finish;
    }

    public int getNonactivity_finish() {
        return nonactivity_finish;
    }

    public void setNonactivity_finish(int nonactivity_finish) {
        this.nonactivity_finish = nonactivity_finish;
    }

    @Override
    public String toString() {
        return "ActivityTarget{" +
                "id=" + id +
                ", activity_target='" + activity_target + '\'' +
                ", activity_finish=" + activity_finish +
                ", nonactivity_finish=" + nonactivity_finish +
                '}';
    }
}
