package com.example.marco.lift.Service;

import android.os.AsyncTask;

import com.example.marco.lift.Interface.IHttpCallbackListener;
import com.example.marco.lift.Model.GymSearchModel;
import com.example.marco.lift.Parser.GymParser;

import java.net.URL;

/**
 * Created by Marco on 4/1/15.
 */
public class GymSearchDataManager extends AsyncTask<loginRequestArgs, String, GymSearchModel> {
    private IHttpCallbackListener callback;

    @Override
    protected GymSearchModel doInBackground(loginRequestArgs... params){
        loginRequestArgs args = params[0];

        callback = args.getListener();
        String urlString = args.getUrl();

        HttpRequestManager hrm = new HttpRequestManager();
        String response ="";

        try{
            URL url = new URL(urlString);
            response = hrm.initiateHttpGet(url.toURI());
        }
        catch(Exception exception){}

        GymSearchModel model = GymParser.JSONtoModel(response);

        return model;
    }
    @Override
    protected void onPostExecute(GymSearchModel GymSearchModel){
        super.onPostExecute(GymSearchModel);
        callback.onGymCallback(GymSearchModel);
    }
}
