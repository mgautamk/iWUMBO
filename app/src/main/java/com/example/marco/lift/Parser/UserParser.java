package com.example.marco.lift.Parser;

import com.example.marco.lift.Model.UserModel;

import com.google.gson.Gson;

/**
 * Created by kting_000 on 3/26/2015.
 */
public class UserParser {

    static public UserModel JSONtoModel(String input){
        /*
        UserModel model = new UserModel();
        Gson gson = new Gson();
        String json = "";
        UserModel obj = gson.fromJson(json, UserModel.class);
        System.out.println(model);
        return model;
        */
        UserModel model = new UserModel();
        model.Username = "kting";
        model.Password = "123";
        model.Email = "stuff@gmail.com";
        model.PreferredGym = "Gym";
        return model;
    }
}
