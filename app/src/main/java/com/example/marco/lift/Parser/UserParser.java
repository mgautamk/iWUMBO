package com.example.marco.lift.Parser;

import com.example.marco.lift.Model.UserModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import com.google.gson.Gson;
/**
 * Created by kting_000 on 3/26/2015.
 */
public class UserParser {
    static public UserModel JSONtoModel(String input){
        UserModel model = new UserModel();
        Gson gson = new Gson();
        String json = "";

        UserModel obj = gson.fromJson(json, UserModel.class);
        System.out.println(model);

        return model;
    }
}


