package com.fitnesslog.macbookpro.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.fitnesslog.macbookpro.fitnessapp.ActiveUserSession;

/**
 * Created by macbookpro on 4/7/16.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper myDB;
    Button btnAdd;
    EditText etName, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        myDB = new DatabaseHelper(this);

        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);

        // DatabaseHelper dbr = new DatabaseHelper();


        btnAdd = (Button) findViewById(R.id.btnAddFtMeasure);
        btnAdd.setOnClickListener(this);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        boolean isSuccess = myDB.Login_Validation(etName.toString());
        String Username = etName.toString();
        String user = "admin";
        if (isSuccess = true) {

            Toast.makeText(LoginActivity.this, "Validation Success", Toast.LENGTH_LONG).show();
            //myDB.ActiveUser = Username;
            ActiveUserSession.ActiveUserId = etName.getText().toString();

            if (etName.toString().equals(user)) {

                Intent createUser = new Intent("com.fitnesslog.macbookpro.fitnessapp.createUserActivity");
                startActivity(createUser);

            } else {

//            Bundle basket= new Bundle();
//            basket.putString("abc", Username);
                Intent DisplayFitnessLog = new Intent("com.fitnesslog.macbookpro.fitnessapp.DisplayFitnessLogActivity");
                // DisplayFitnessLog.putExtras(basket);
                startActivity(DisplayFitnessLog);
            }


//            Intent intentBundle = new Intent(LoginActivity.this,
//                    DisplayFitnessLogActivity.class);

//            intentBundle.putExtra(Username,"name");
//            startActivity(intentBundle);
//            Intent DisplayFitnessLog = new Intent("com.fitnesslog.mackbookpro,fitnessapp.DisplayFitnessLogActivity");
//            DisplayFitnessLog.putExtra("String",Username);
//            startActivity(DisplayFitnessLog);

//            Intent FetchFitnessMeasure = new Intent("com.fitnesslog.macbookpro.fitnessapp.FetchFitnessMeasure");
//           // FetchFitnessMeasure.setData(Uri.parse("tel:"+phone));
//            FetchFitnessMeasure.putExtra(etName.toString(),"UserName");
//            startActivity(FetchFitnessMeasure);

        }


    }
}

