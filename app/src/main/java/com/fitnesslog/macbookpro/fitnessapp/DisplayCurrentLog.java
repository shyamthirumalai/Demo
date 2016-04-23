package com.fitnesslog.macbookpro.fitnessapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by admin on 4/15/16.
 */
public class DisplayCurrentLog extends AppCompatActivity
        //implements View.OnClickListener
{


    DatabaseHelper myDB;
    ListView lvDisplayCurrentLog ;
    Button btnDisplay;


    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.displaycurrentlog);
        myDB = new DatabaseHelper(this);
//        Bundle gt=getIntent().getExtras();
//        myDB = new DatabaseHelper(this);
//        String userName=gt.getString("name");

//        btnDisplay = (Button)findViewById(R.id.btnDisplayMeasure);
//        btnDisplay.setOnClickListener(this);

        lvDisplayCurrentLog = (ListView) findViewById(R.id.lvDisplayCurrent);

        ArrayList<String> alDateList = getCurrentLog(ActiveUserSession.ActiveUserId,
                ActiveUserSession.CurrentDateSelected);

        System.out.println("ArrayList Values : " + alDateList.toString() );


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alDateList);


        // Assign adapter to ListView
        lvDisplayCurrentLog.setAdapter(adapter);

//        lvDisplayCurrentLog.setOnItemClickListener(new OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//                // ListView Clicked item index
//                int itemPosition     = position;
//
//                // ListView Clicked item value
//                String  itemValue    = (String) lvDisplayCurrentLog.getItemAtPosition(position);
//
//                // Show Alert
//                System.out.println("Click on : " + itemValue);
//
//                ActiveUserSession.CurrentDateSelected = itemValue;
//
//            }
//        });





    }



    public void FM_ADD_OnClick(View v) {

        Toast.makeText(DisplayCurrentLog.this,"View Display Activity", Toast.LENGTH_LONG).show();

        Intent FetchFitnessMeasure = new Intent("com.fitnesslog.macbookpro.fitnessapp.FetchFitnessMeasure");
        startActivity(FetchFitnessMeasure);


    }

    public ArrayList<String> getCurrentLog(String uName, String sCDate){
        System.out.println("Get Current log "+uName
                +" Current Date "+sCDate);

        ArrayList<String> alDateList = new ArrayList<>();
        Cursor result = myDB.getCurrentLog(uName, sCDate);
        while (result.moveToNext())
        {
            alDateList.add(myDB.fetchFitnessMeasureFromId(result.getString(0))
                    + " - "+ result.getString(1) );
        }

        System.out.println("Current log : "+alDateList.toString());

        return alDateList;
    }
}
