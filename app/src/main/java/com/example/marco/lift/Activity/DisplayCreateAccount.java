package com.example.marco.lift.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import com.example.marco.lift.Interface.IHttpCallbackListener;
import com.example.marco.lift.Model.GymSearchModel;
import com.example.marco.lift.Model.UserModel;
import com.example.marco.lift.R;
import com.example.marco.lift.Service.UserDataManager;
import com.example.marco.lift.Service.loginRequestArgs;
import com.example.marco.lift.Utility.URLFormatUtility;
import com.google.gson.GsonBuilder;
import com.example.marco.lift.Utility.VolleyQueue;


public class DisplayCreateAccount extends ActionBarActivity{
    private UserDataManager dataManager;
    private Button create;
    private EditText inputUsername;
    private EditText inputPassword;
    private EditText inputConfirm;
    private EditText inputEmail;
    private EditText inputGym;
    private TextView Response;
    private boolean valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_display_create_account);
        inputUsername = (EditText) findViewById(R.id.username_input);
        inputPassword = (EditText) findViewById(R.id.password_input);
        inputConfirm = (EditText) findViewById(R.id.confirm_password_input);
        inputEmail = (EditText) findViewById(R.id.email_input);
        inputGym = (EditText) findViewById(R.id.Preferred_Gym_input);
        create = (Button) findViewById(R.id.create_button);
        Response = (TextView) findViewById(R.id.Response);
/*
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataManager = new UserDataManager();
                loginRequestArgs args = new loginRequestArgs();
                if ((inputPassword.getText().toString()).equals((inputConfirm.getText().toString()))) {

                    Response.setText("Passwords match");
                } else {
                    Response.setText(inputPassword.getText().toString() + ":" + inputConfirm.getText().toString());
                }
            }
        });
        */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if (android.R.id.home == item.getItemId()) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendAccount(View v) {
        if((inputPassword.getText().toString()).equals(inputConfirm.getText().toString())) {
            UserModel u = new UserModel();
            u.Username = inputUsername.getText().toString();
            u.Password = inputPassword.getText().toString();
            u.Email = inputEmail.getText().toString();
            u.PreferredGym = inputGym.getText().toString();
            try {
                JSONObject submission = new JSONObject(new GsonBuilder().create().toJson(u));

                Log.d("OP_STRING", submission.toString());
                Log.d("JSON", "FORMING REQUEST");
                Response.Listener<JSONObject> responseListener = new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("OP_SUBMISSION", "success?");
                    }
                };
                Response.ErrorListener errorListener = new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("OP_SUBMISSION", "JSON FAIL");
                        Log.d("SERVER_ERROR", error.toString());

                    }
                };

                String url = URLFormatUtility.submitAccount();

                JsonObjectRequest request = new JsonObjectRequest(url, submission, responseListener, errorListener);
                VolleyQueue.getRequestQueue(getApplicationContext()).add(request);
                Log.d("JSON", submission.toString());
                Log.d("URL", url.toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }


            Intent i = new Intent(getApplicationContext(), Login.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
        else{
            Response.setText("Passwords do not match...");
        }
    }

}
