package com.example.marco.lift.Parser;

import com.example.marco.lift.Model.GymSearchModel;

/**
 * Created by Marco on 4/1/15.
 */
public class GymParser {
    static public GymSearchModel JSONtoModel(String input){
        GymSearchModel model = new GymSearchModel();


        model.setGymName("24 Hour Fitness");
        model.setAddress("123 Broadway");
        model.setGymID("testID");
        model.setLatLng("9128390128390128903812");

        return model;

    }
}
