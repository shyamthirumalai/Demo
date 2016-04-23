package com.fitnesslog.macbookpro.fitnessapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormatSymbols;

/**
 * Created by admin on 4/21/16.
 */
public class createUserActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    Button btnsaveUser;
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.register_user);
        showDialogOnclick();


    }

    public void showDialogOnclick() {
        EditText etDob = (EditText) findViewById(R.id.etdob);

        etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialog(DIALOG_ID);
            }
        });

    }



    protected Dialog onDialog(int id){

        if(id == DIALOG_ID)
            return new DatePickerDialog(this, dPickerListener, year_x,month_x,day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dPickerListener
            = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            year_x = year;
            month_x = monthOfYear;
            day_x= dayOfMonth;
            Toast.makeText(createUserActivity.this, year_x +"/n" +month_x + "/n" +day_x,Toast.LENGTH_LONG).show();
        }
    };
}
