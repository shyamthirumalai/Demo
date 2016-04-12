package com.fitnesslog.macbookpro.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Timestamp;

/**
 * Created by macbookpro on 4/8/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="Fitness_DB";
    public static final String TABLE_NAME ="Fitness_Measures";
    public static final String COL_1 ="FitnessMeasures_Id";
    public static final String COL_2="FitnessMeasuresName";

    //Table Save Measures

    public static final String TABLE_NAME1 ="SaveFitnessMeasures_Table";
    public static final String COLUMN1 ="ClientId";
    public static final String COLUMN2 ="DateTime";
    public static final String COLUMN3 ="FitnessMeasures_Id";
    public static final String COLUMN4 ="Value";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_FitnessMeasures_Table = "CREATE TABLE " +
                TABLE_NAME + "("
                + COL_1 + " INTEGER PRIMARY KEY," + COL_2 + " TEXT" + ")";
        db.execSQL(Create_FitnessMeasures_Table);
        System.out.println("Fitness Measure :: TABLE CREATED");


        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, "Bust In Inches");
        contentValues.put(COL_2,"Biceps in Inches");
        contentValues.put(COL_2,"Waist in Inches");
        db.insert(TABLE_NAME,null,contentValues);
        System.out.println("Fitness_Measures ::VALUES INSERTED");




        String Create_SaveFitnessmeasure_Table ="CREATE TABLE " +
                TABLE_NAME1+ "("
                + COLUMN1 + " INTEGER PRIMARY KEY," + COLUMN2 + " DATETIME," + COLUMN3 + "TEXT," + COLUMN4 + "TEXT" + ")";
        db.execSQL(Create_SaveFitnessmeasure_Table);
        System.out.println("Save Fitness Measure :: TABLE CREATED");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME1);
        onCreate(db);

    }
}
