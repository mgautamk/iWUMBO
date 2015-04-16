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

public class Login extends Activity implements IHttpCallbackListener {
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

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dataManager = new UserDataManager();
                loginRequestArgs args = new loginRequestArgs();
               // locate = new LocationModel();
              //  ReturnLocation location = new ReturnLocation();
                //location.onConnected(Bundle.EMPTY);
                //ReturnLocation location = new ReturnLocation();
                //LatLong = location.onConnected();
                args.setUrl(URLFormatUtility.formatApiUrl(inputUsername.getText().toString()));
                args.setUrl(URLFormatUtility.formatApiUrl(inputPassword.getText().toString()));
                args.setListener(Login.this);
                dataManager.execute(args);
            }
        });
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

    @Override
    public void onUserCallback(UserModel model){
        String Username = model.Username;
        String Password = model.Password;
        String inputUser = inputUsername.getText().toString();
        String inputPass = inputPassword.getText().toString();
        if ( (inputUser.equals(Username)) &&
                (inputPass.equals(Password)) )
        {
         //   LoginResponse.setText("sad OR Happy face");
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        }
        else
        {
            LoginResponse.setText(Username + ' ' + Password + " : " + inputUser + ' ' + inputPass);
        }
     }

    @Override
    public void onGymCallback(GymSearchModel model){
        System.out.print("--------------- onGymCallBack function is empty ---------------");
    }
}

