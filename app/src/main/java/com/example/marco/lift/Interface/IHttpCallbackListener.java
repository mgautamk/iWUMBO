package com.example.marco.lift.Interface;

import com.example.marco.lift.Model.UserModel;
import com.example.marco.lift.Model.GymSearchModel;

/**
 * Created by kting_000 on 3/13/2015.
 * Edited by Marco on 4/1/2015 added gym search stuff
 */
public interface IHttpCallbackListener {
    public void onUserCallback(UserModel model);
    public void onGymCallback(GymSearchModel model);
}
