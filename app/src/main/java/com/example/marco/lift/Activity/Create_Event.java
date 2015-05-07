package com.example.marco.lift.Activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.DatePicker;

import com.example.marco.lift.R;

import java.util.Calendar;

public class Create_Event extends ActionBarActivity {
    final Calendar c = Calendar.getInstance();

    int maxYear = c.get(Calendar.YEAR)  +  01; // this year ( 2011 ) - 20 = 1991
    int maxMonth = c.get(Calendar.MONTH);
    int maxDay = c.get(Calendar.DAY_OF_MONTH);

    int minYear = 2015;
    int minMonth = 01; // january
    int minDay = 01;

    DatePicker EventDatePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__event);

        EventDatePicker = (DatePicker) findViewById(R.id.EventDatePicker);
        EventDatePicker.init(maxYear - 10, maxMonth, maxDay, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                if (year < minYear)
                    view.updateDate(minYear, minMonth, minDay);

                if (monthOfYear < minMonth && year == minYear)
                    view.updateDate(minYear, minMonth, minDay);

                if (dayOfMonth < minDay && year == minYear && monthOfYear == minMonth)
                    view.updateDate(minYear, minMonth, minDay);


                if (year > maxYear)
                    view.updateDate(maxYear, maxMonth, maxDay);

                if (monthOfYear > maxMonth && year == maxYear)
                    view.updateDate(maxYear, maxMonth, maxDay);

                if (dayOfMonth > maxDay && year == maxYear && monthOfYear == maxMonth)
                    view.updateDate(maxYear, maxMonth, maxDay);
            }
        }); // BirthDateDP.init()
    } // activity




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create__event, menu);
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

}
