package com.fitnesslog.macbookpro.fitnessapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

import java.util.ArrayList;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
/**
 * Created by admin on 4/15/16.
 */
public class DisplayFitnessLogActivity extends AppCompatActivity
        //implements View.OnClickListener
{


    DatabaseHelper myDB;
    ListView lvDisplayFitnessLog ;
    Button btnDisplay;


    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.displayfitness_log);
        myDB = new DatabaseHelper(this);
//        Bundle gt=getIntent().getExtras();
//        myDB = new DatabaseHelper(this);
//        String userName=gt.getString("name");

//        btnDisplay = (Button)findViewById(R.id.btnDisplayMeasure);
//        btnDisplay.setOnClickListener(this);

        lvDisplayFitnessLog = (ListView) findViewById(R.id.lvDisplayFitness);

        ArrayList<String> alDateList = getFitness_Measures(ActiveUserSession.ActiveUserId);

        System.out.println("ArrayList Values : " + alDateList.toString() );


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alDateList);


        // Assign adapter to ListView
        lvDisplayFitnessLog.setAdapter(adapter);

        lvDisplayFitnessLog.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) lvDisplayFitnessLog.getItemAtPosition(position);

                // Show Alert
                System.out.println("Click on : " + itemValue);

                ActiveUserSession.CurrentDateSelected = itemValue;

                Intent DisplayDailyLog = new Intent("com.fitnesslog.macbookpro.fitnessapp.DisplayCurrentLog");
                startActivity(DisplayDailyLog);


            }
        });





    }



    public void FM_ADD_OnClick(View v) {

//        Toast.makeText(DisplayFitnessLogActivity.this,"View Display Activity", Toast.LENGTH_LONG).show();

        Intent FetchFitnessMeasure = new Intent("com.fitnesslog.macbookpro.fitnessapp.FetchFitnessMeasure");
        startActivity(FetchFitnessMeasure);
        

    }

    public ArrayList<String> getFitness_Measures(String uName){

        ArrayList<String> alDateList = new ArrayList<>();
        Cursor result = myDB.getUserFitness_measures(uName);
        while (result.moveToNext())
        {
            alDateList.add(result.getString(0));
        }
        return alDateList;
    }
}
