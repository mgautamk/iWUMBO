package com.example.marco.lift.Activity;

import android.app.Activity;
//import android.location.Location;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Base64;
import javax.crypto.*;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;


import com.example.marco.lift.Interface.IHttpCallbackListener;
import com.example.marco.lift.Model.LocationModel;
//import com.example.marco.lift.Utility.ReturnLocation;
import com.example.marco.lift.Model.GymSearchModel;
import com.example.marco.lift.Model.UserModel;
import com.example.marco.lift.R;
import com.example.marco.lift.Service.UserDataManager;
import com.example.marco.lift.Service.loginRequestArgs;
//import com.example.marco.lift.Utility.ReturnLocation;
import com.example.marco.lift.Utility.URLFormatUtility;
import com.example.marco.lift.Utility.VolleyQueue;
import com.example.marco.lift.lift;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;

import static com.example.marco.lift.Utility.EncryptDecrypt.decryptIt;

public class Login extends Activity {
    public LocationModel locate;
    private String LatLong;
    private UserDataManager dataManager;
    private EditText inputUsername;
    private EditText inputPassword;
    private TextView LoginResponse;
    private TextView LocationResponse;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputUsername = (EditText)findViewById(R.id.username_login);
        inputPassword = (EditText)findViewById(R.id.password_login);
        loginButton = (Button)findViewById(R.id.login);
        LoginResponse = (TextView)findViewById(R.id.LoginResponse);
        LocationResponse = (TextView)findViewById(R.id.LocationResponse);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void validLogin(UserModel u, String Username, String Password){
        //Parcelable if you want to send model to the new activity

        String EncryptPass = decryptIt(u.Password);
        if (u.Username.equals(Username) && EncryptPass.equals(Password)){
            Log.d("USERID", String.valueOf(u.UserID));
            //lift.getInstance().setUserid(u.UserID);
            //Log.d("INSTANCE_USERID", String.valueOf(lift.getInstance().getUserid()));
            Intent intent = new Intent(this, HttpTestActivity.class);
            startActivity(intent);
        }
        else{
            LoginResponse.setText("Invalid Login");
        }

    }

    public void sendLogin(View v){
        Log.d("Login Start up", "sendLogin opened");
        final String Username = inputUsername.getText().toString();
        final String Password = inputPassword.getText().toString();
        String url = URLFormatUtility.loginAccount(Username);
        Log.d("URL", url);
            Response.Listener<JSONObject> responseListener = new Response.Listener<JSONObject>(){
                @Override
                public void onResponse(JSONObject response) {
                    //JSONObject profile = new JSONObject(response);
                    Log.d("OP_SUBMISSION", "success?");
                    //Find way use fromJson with jsonObject
                    Log.d("JSON", response.toString());
                    Gson gson = new Gson();
                    UserModel model = gson.fromJson(response.toString(), UserModel.class);
                    validLogin(model, Username, Password);
                }
            };
            Response.ErrorListener errorListener = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("OP_SUBMISSION", "JSON FAIL");
                    Log.d("SERVER_ERROR", error.toString());

                }
            };
            Log.d("URL", url);
            JsonObjectRequest request = new JsonObjectRequest(url,null, responseListener, errorListener);
            VolleyQueue.getRequestQueue(getApplicationContext()).add(request);

    }
}

