package com.fitnesslog.macbookpro.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.widget.Toast;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Stack;

/**
 * Created by macbookpro on 4/8/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //Create - TABLE FITNESS_MEASURES
    public static final String DATABASE_NAME ="Fitness_DB";
    public static final String TABLE_NAME ="Fitness_Measures";
    public static final String COL_1 ="FitnessMeasures_Id";
    public static final String COL_2="FitnessMeasuresName";
    public String ActiveUser = "";

    //Create - TABLE SAVEFITTNESMEASURES

    public static final String TABLE_NAME1 ="SaveFitnessMeasures_Table";
    public static final String COLUMN1 ="ClientId";
    public static final String COLUMN2 ="DateTime";
    public static final String COLUMN3 ="FitnessMeasures_Id";
    public static final String COLUMN4 ="Value";
    public static final String COLUMN5 ="FitnessLogId";

    //Create - TABLE LOGIN
    public static final String TABLE_NAME2 ="Login_Table";
    public static final String LCOL1 ="ID";
    public static final String LCOL2 ="UserName";
    //public static final String LCOL3 ="Password";

    //Create - TABLE USER
    public static final String TABLE_NAME3 ="User";
    public static final String COL_ID="ID";
    public static final String COL_Name="userName";
    public static final String COL_password ="Password";
    public static final String COL_DOB ="DOB";
    public static final String COL_Phone="Phone";
    public static final String COL_Email="Email";




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


        String Create_Login_Table = "CREATE TABLE " +
                TABLE_NAME2 + "("
                + LCOL1 + " INTEGER PRIMARY KEY," + LCOL2 + " TEXT" +")";
        db.execSQL(Create_Login_Table);
        System.out.println("Login  :: TABLE CREATED");

        String text ="shyam";
        String text1="subha";


        String Create_user = "CREATE TABLE" + TABLE_NAME3 + "(" + COL_ID + "INTEGER PRIMARY KEY," + COL_Name + " TEXT,"
                +COL_password+ " TEXT," +COL_DOB+ " TEXT," +COL_Phone+ " TEXT," +COL_Email+ " TEXT" + ")";
        db.execSQL(Create_user);
        System.out.println("USER : TABLE Created");

        ArrayList<String> alUnameList = new ArrayList<String>();
        ContentValues userNameList = new ContentValues();

        alUnameList.add("shyam");
        alUnameList.add("sriram");
        alUnameList.add("admin");

        //values.put(LCOL3,"Subha");LCOL2
        //db.insert(TABLE_NAME2, null, values);

        for(int i =0; i<alUnameList.size(); i++){
            userNameList.put(COL_2, alUnameList.get(i));
            db.insert(TABLE_NAME, null, userNameList);
        }

        System.out.println("Login ::VALUES INSERTED");


        ArrayList<String> alValList = new ArrayList<String>();

        alValList.add("Bust in Inches");
        alValList.add("Under Bust in Inches");
        alValList.add("Waist in Inches");
        alValList.add("Stomach in Inches");
        alValList.add("Upperarm L in Inches");
        alValList.add("Upperarm R in Inches");
        alValList.add("Knee L in Inches");
        alValList.add("Knee R in Inches");
        alValList.add("Thigh L in Inches");
        alValList.add("Thigh R in Inches");
        alValList.add("Hips in Inches");
        alValList.add("Calf L in Inches");
        alValList.add("Calf R in Inches");
        alValList.add("Weight in Kgs");

        ContentValues contentValues = new ContentValues();
        for(int i =0; i<alValList.size(); i++){
            contentValues.put(COL_2, alValList.get(i));
            db.insert(TABLE_NAME, null, contentValues);
        }

        System.out.println("Fitness_Measures ::VALUES INSERTED");


        String Create_SaveFitnessmeasure_Table ="CREATE TABLE " +
                TABLE_NAME1+ "("
                + COLUMN5 + " INTEGER PRIMARY KEY," + COLUMN1 + " TEXT," + COLUMN2 +
                " TEXT," + COLUMN3 + " TEXT,"
                + COLUMN4 + " TEXT" +")";
        db.execSQL(Create_SaveFitnessmeasure_Table);
        System.out.println("Save Fitness Measure :: TABLE CREATED");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME2);
        onCreate(db);

    }

    public boolean Login_Validation(String Name){

        String query = "Select * FROM " + TABLE_NAME2 + " WHERE "
                + LCOL2 + " =  \"" + Name + "\" ";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if( cursor.getCount() > 0 ){
            return true;
        }
        return false;
    }


    public int fetchFitness_measureID(String fmString){
        String query = "Select FitnessMeasures_Id FROM " + DatabaseHelper.TABLE_NAME
                + " WHERE "
                + COL_2 + " =  \"" + fmString + "\" ";

        System.out.println("SQL To fetch Fitness Measure : "
        + query);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(0);
            return id;
        }
        return 0;
    }

    public String fetchFitnessMeasureFromId(String fmString){
        String query = "Select "+COL_2+" FROM " + TABLE_NAME
                + " WHERE "
                + COL_1 + " =  \"" + fmString + "\" ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String name = cursor.getString(0);
            System.out.println("Name"+name);
            return name;
        }
        return "";
    }

    public String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }


    public boolean InsertData(String username, int MeasureId,
            String Value, String dateTime){

        System.out.println("Values to be inserted" + username + "-" +
        MeasureId + "-" + Value  + "-" + dateTime);

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN1, username);
        values.put(COLUMN2, dateTime);
        values.put(COLUMN3, ""+MeasureId);
        values.put(COLUMN4, Value);
        db.insert(TABLE_NAME1, null, values);
        return true;

    }

    public Cursor getCurrentLog(String FtUserName, String sDate){

        System.out.println("GetUserFitness_Measures" +FtUserName);
        SQLiteDatabase db = this.getWritableDatabase();

        String query ="Select "+COLUMN3+", " + COLUMN4+ " FROM " + TABLE_NAME1 + " WHERE "
                + COLUMN1 + " =  \"" + FtUserName + "\" AND "
                + COLUMN2 + " =  \"" + sDate + "\" ";

        System.out.println("SQL To fetch Current Log : "
                + query);

        Cursor result = db.rawQuery(query,null);

        System.out.println("RESULT" + result);

        return result;
    }

    public Cursor getUserFitness_measures(String FtUserName){

        System.out.println("GetUserFitness_Measures : " +FtUserName);

        SQLiteDatabase db = this.getWritableDatabase();

        String query ="Select DISTINCT "+COLUMN2+" FROM " + TABLE_NAME1 + " WHERE "
                + COLUMN1 + " =  \"" + FtUserName + "\" ";

        System.out.println("SQL To fetch Fitness Measure : "
                + query);

        Cursor result = db.rawQuery(query,null);

        System.out.println("RESULT from User Log : "
                + result.toString());

        return result;
    }
}
