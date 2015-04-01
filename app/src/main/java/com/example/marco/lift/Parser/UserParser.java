package com.example.marco.lift.Parser;

import com.example.marco.lift.Model.UserModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Created by kting_000 on 3/26/2015.
 */
public class UserParser {
    static public UserModel JSONtoModel(String input){
            UserModel model = new UserModel();
            //JSONObject json;
            /*try {

                json = (JSONObject) new JSONTokener(input).nextValue();
                JSONArray array = json.getJSONArray("results");
                JSONObject user = array.getJSONObject(0);
                */

                model.setUsername("kting");
                model.setPassword("123");
                model.setEmail("stuff@gmail.com");
                model.setPreferredGym("Gym");/*
            }
            catch(JSONException exception) {
                exception.getCause();
            }*/
        return model;

    }
}
