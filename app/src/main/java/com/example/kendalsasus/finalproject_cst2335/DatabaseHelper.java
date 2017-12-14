package com.example.kendalsasus.finalproject_cst2335;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Kendal's Asus on 2017-11-28.
 * Creates a database and the auto table of the database
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = " myDatabase.db";
    public static int VERSION_NUM = 1;
    public final static String ID = "_id";

    public final static String AUTO_TABLE = "automobile";
    public final static String GAS = "GAS";
    public final static String GAS_PRICE = "PRICE";
    public final static String ODOMETER = "ODOMETER";
    public final static String GAS_DATE = "DATE";

    // Added by Chris on 2017-12-09
    public final static String NUTRITION_TABLE = "nutrition_tracker";
    public final static String NUTRITION_ITEM = "item";
    public final static String NUTRITION_CALORIES = "calories";
    public final static String NUTRITION_FAT = "fat";
    public final static String NUTRITION_CARBS = "carbohydrates";
    public final static String NUTRITION_DATE = "date";

    //Added by Melissa on 2017-12-13
    public final static String ACTIVITY_TABLE = "activities";
    public final static String ACTIVITY_TYPE = "Activity Type";
    public final static String ACTIVITY_DURATION = "Duration";
    public final static String ACTIVITY_DATE = "Date";
    public final static String ACTIVITY_COMMENT = "Comments";

    public DatabaseHelper(Context ctx){
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        //Automobile Table
        String sql = "CREATE TABLE " + AUTO_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GAS + " INT, " + GAS_PRICE + " INT, " + ODOMETER + " INT, " + GAS_DATE + " INT);";
        db.execSQL(sql);
        Log.i("DataBase Helper", "Creating automobile table");

        //Nutrition Table
        String sqlNutrition = "CREATE TABLE " + NUTRITION_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NUTRITION_ITEM + " TEXT, " + NUTRITION_CALORIES + " INT, " + NUTRITION_FAT + " INT, " + NUTRITION_CARBS + " INT, " + NUTRITION_DATE + " INT);";
        db.execSQL(sqlNutrition);
        Log.i("DataBase Helper", "Creating nutrition tracker table");

        //Activity Table
        String sqlActivity = "CREATE TABLE " + ACTIVITY_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ACTIVITY_TYPE + " TEXT, " + ACTIVITY_DURATION + " INT, " + ACTIVITY_COMMENT + " TEXT, " + ACTIVITY_DATE + " INT);";
        db.execSQL(sqlActivity);
        Log.i("DataBase Helper", "Creating activity tracker table");

        /*
            toDo:
            STEVE:
            PUT YOUR CREATE TABLE STATEMENTS HERE AND YOUR REQUIRED COLUMN NAMES AS FIELDS UP ABOVE
         */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + AUTO_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + NUTRITION_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ACTIVITY_TABLE);
        onCreate(db);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + AUTO_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + NUTRITION_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ACTIVITY_TABLE);
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db){
        Log.i("Database", "onOpen called");
    }
}