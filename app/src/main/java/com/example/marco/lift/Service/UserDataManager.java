package com.example.marco.lift.Service;

import android.os.AsyncTask;

import com.example.marco.lift.Interface.IHttpCallbackListener;
import com.example.marco.lift.Model.UserModel;
import com.example.marco.lift.Parser.UserParser;

import java.net.URL;


/**
 * Created by kting_000 on 3/24/2015.
 */
public class UserDataManager extends AsyncTask<loginRequestArgs, String, UserModel> {
    private IHttpCallbackListener callback;

    @Override
    protected UserModel doInBackground(loginRequestArgs... params){
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

        UserModel model = UserParser.JSONtoModel(response);

        return model;
    }
    @Override
    protected void onPostExecute(UserModel userModel){
        super.onPostExecute(userModel);
        callback.onUserCallback(userModel);
    }
}
