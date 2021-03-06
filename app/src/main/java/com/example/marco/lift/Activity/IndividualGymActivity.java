package com.example.marco.lift.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.marco.lift.R;

/**
 * Created by marco on 4/27/2015.
 */

public class IndividualGymActivity extends Activity {
    String PlaceID;
    String PlaceName;
    String PlaceAddress;
    public TextView name;
    public TextView address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_gym);
         Intent i = getIntent();
        //Log.d("String Passed", getIntent().getStringExtras("dataBundle"));
//        Position = (TextView)findViewById(R.id.Position);
        PlaceID = i.getExtras().getString("PlaceID");
        PlaceName = i.getExtras().getString("Name");
        PlaceAddress = i.getExtras().getString("Address");
        Log.d("Passed String", PlaceName);
        Log.d("Passed Address", PlaceAddress);
        name = (TextView)findViewById(R.id.name);
        address = (TextView)findViewById(R.id.address);
        name.setText(PlaceName);
        address.setText(PlaceAddress);

  //      Position.setText(getIntent().getExtras().getString("position"));
//        Id = getIntent().getExtras().getString("Id");
//        Position.setText(position);
//        TextId.setText(Id);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_individual_gym, menu);
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

    public void sendCreateEvent(View view) {
        Intent intent = new Intent(this, Create_Event.class);
        startActivity(intent);
    }
}
