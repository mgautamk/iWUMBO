package com.example.marco.lift;

import android.app.Application;

import com.example.marco.lift.Model.UserModel;
import com.example.marco.lift.Model.LocationModel;

/**
 * Created by kting_000 on 5/5/2015.
 */
public class lift extends Application {
    private static lift instance;
    private static int userid;
    private static String locationid;

    public lift(){
        super();
        instance = this;
    }

    public static lift getInstance(){
        return instance;
    }

    public void setUserid(int id){
        userid = id;
    }

    public int getUserid(){
        return userid;
    }

    public void setLocationid(String id){
        locationid = id;
    }

    public String getLocationid(){
        return locationid;
    }
}
