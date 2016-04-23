package com.fitnesslog.macbookpro.fitnessapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by admin on 4/13/16.
 */
public class FetchFitnessMeasure extends AppCompatActivity implements View.OnClickListener {


    DatabaseHelper myDB;
    Button btnSave;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDB = new DatabaseHelper(this);
        setContentView(R.layout.fitnessmeasures);

        btnSave = (Button)findViewById(R.id.btnFMAddSave);
        btnSave.setOnClickListener(this);

//        TextView viewTxt = (TextView)findViewById(R.id.txtView);
//        LinearLayout linLayout = new LinearLayout(this);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        setContentView(linLayout,layoutParams);
//
//        LinearLayout.LayoutParams ipView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//
//
////        GridLayout fmGridLayout = new GridLayout(this);
////        fmGridLayout.setOrientation(GridLayout.VERTICAL);
//        Cursor cFitness_Measure =myDB.fetchFitness_measure();
//
//        if (cFitness_Measure.getCount() > 0)
//        {
//            while (cFitness_Measure.moveToNext())
//            {
//                TextView fmView = new TextView(this);
//                fmView.setText(cFitness_Measure.getString(1));
//                fmView.setLayoutParams(ipView);
//                linLayout.addView(fmView);
//
//                System.out.println("values" + fmView.getText());
//                Toast.makeText(FetchFitnessMeasure.this, "GridValues", Toast.LENGTH_LONG).show();
//            }
//
//        }

//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String FmQuery = "SELECT * FROM " +myDB.TABLE_NAME ;
//
//        Cursor cQuery =("")



    //return


}

    @Override
    public void onClick(View v) {

        String etBust = (String)findViewById(R.id.etFMAddBust).toString();
        String etUBust =(String)findViewById(R.id.etFMAddUBust).toString();
        String etWaist =(String)findViewById(R.id.etFMAddWaist).toString();
        String etStomach =(String)findViewById(R.id.etFMAddStomach).toString();
        String etFMAddUArmL =(String)findViewById(R.id.etFMAddUArmL).toString();
        String etFMAddUArmR =(String)findViewById(R.id.etFMAddUArmR).toString();
        String etFMAddKneeL =(String)findViewById(R.id.etFMAddKneeL).toString();
        String etFMAddKneeR =(String)findViewById(R.id.etFMAddKneeR).toString();
        String etFMAddThighL =(String)findViewById(R.id.etFMAddThighL).toString();
        String etFMAddThighR =(String)findViewById(R.id.etFMAddThighR).toString();
        String etFMAddHips =(String)findViewById(R.id.etFMAddHips).toString();
        String etFMAddCalfL =(String)findViewById(R.id.etFMAddCalfL).toString();
        String etFMAddCalfR =(String)findViewById(R.id.etFMAddCalfR).toString();
        String etFMAddWeight =(String)findViewById(R.id.etFMAddWeight).toString();

        TextView tvBust = (TextView)findViewById(R.id.tFMAddBust);


        String tBust = tvBust.getText().toString();

        System.out.println("Text : " + tBust);

        int iFMIdBust = myDB.fetchFitness_measureID(tBust);

        System.out.println("Bust in Inches : " + iFMIdBust);

        ArrayList<EditText> myEditTextList = new ArrayList<EditText>();
        ArrayList<TextView> myTextViewList = new ArrayList<TextView>();
        ArrayList<Button> ButtonList = new ArrayList<Button>();

        System.out.println("EDITtext size" +myEditTextList.size());
        System.out.println("TEXTVIEW" +myTextViewList.size());

        GridLayout glFMAddSave = (GridLayout) findViewById(R.id.glFitnessMeasure);
        GridLayout gridLayout = new GridLayout(this);
        System.out.println("GridLayout ChildCount"+gridLayout.getChildCount());

        System.out.println("Child size : " + glFMAddSave.getChildCount());

        for( int i = 0; i < glFMAddSave.getChildCount(); i++ ) {
            if(!(glFMAddSave.getChildAt(i) instanceof Button)) {


                if (glFMAddSave.getChildAt(i) instanceof EditText) {
                    myEditTextList.add((EditText) glFMAddSave.getChildAt(i));
                } else if (glFMAddSave.getChildAt(i) instanceof TextView) {
                    myTextViewList.add((TextView) glFMAddSave.getChildAt(i));
                }
            }
        }

        System.out.println("myEditTextList List : " + myEditTextList.size());
        System.out.println("myTextViewList List : " + myTextViewList.size());
        String userId = ActiveUserSession.ActiveUserId;
        //String date = (DateFormat.format(.toString());
        String dateTime = myDB.getDateTime();
        //Date datetime = Date
        //String date = dateFo

        System.out.println("List size : " + myEditTextList.size());
        System.out.println("TextView List" +myTextViewList.size());

        for (int i = 0; i < myEditTextList.size(); i ++)
        {
            System.out.println("Values : " + myEditTextList.get(i).getText().toString());
            System.out.println("Labels : " + myTextViewList.get(i).getText().toString());
            Boolean FitnessMeasureVal =myDB.InsertData(userId,
                    myDB.fetchFitness_measureID(myTextViewList.get(i).getText().toString()),
            myEditTextList.get(i).getText().toString(), dateTime);
           }
        Intent DisplayFitness_Measure = new Intent("com.fitnesslog.macbookpro.fitnessapp.DisplayFitnessLogActivity");
        startActivity(DisplayFitness_Measure);

    }
}
