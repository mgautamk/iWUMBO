package com.example.marco.lift.Activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import com.example.marco.lift.Interface.IHttpCallbackListener;
import com.example.marco.lift.Model.GymSearchModel;
import com.example.marco.lift.Model.UserModel;
import com.example.marco.lift.R;
import com.example.marco.lift.Service.UserDataManager;
import com.example.marco.lift.Service.loginRequestArgs;
import com.example.marco.lift.Utility.URLFormatUtility;


public class DisplayCreateAccount extends ActionBarActivity implements IHttpCallbackListener {
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
        setContentView(R.layout.activity_display_create_account);

        inputUsername = (EditText)findViewById(R.id.username_input);
        inputPassword = (EditText)findViewById(R.id.password_input);
        inputConfirm = (EditText)findViewById(R.id.confirm_password_input);
        inputEmail = (EditText)findViewById(R.id.email_input);
        inputGym = (EditText)findViewById(R.id.Preferred_Gym_input);
        create = (Button)findViewById(R.id.create_button);
        Response = (TextView)findViewById(R.id.Response);

        create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dataManager = new UserDataManager();
                loginRequestArgs args = new loginRequestArgs();
                if (inputPassword.equals(inputConfirm)) {
                    args.setUrl(URLFormatUtility.formatApiUrl(inputUsername.getText().toString()));
                    args.setUrl(URLFormatUtility.formatApiUrl(inputPassword.getText().toString()));
                    args.setUrl(URLFormatUtility.formatApiUrl(inputEmail.getText().toString()));
                    args.setUrl(URLFormatUtility.formatApiUrl(inputGym.getText().toString()));
                    args.setListener(DisplayCreateAccount.this);

                    dataManager.execute(args);
                    valid = true;
                }
                else{
                    Response.setText(inputPassword.getText().toString() + ":" + inputConfirm.getText().toString());
                }
            }
        });
    }

    @Override
    public void onUserCallback(UserModel model){
        Response.setText("Successful insertion");
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
    public void onGymCallback(GymSearchModel model){
        System.out.print("--------------- onGymCallBack function is empty ---------------");
    }




}
