package com.beatricefarias.acneapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.beatricefarias.acneapp.Database.DataContract.MealEntry;
import com.beatricefarias.acneapp.Database.DataContract.BreakoutEntry;

public class DataDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = DataDbHelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "acne.db";

    /**
     * Database version. If database schema changes, database version increments.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link DataDbHelper}.
     * @param context of the app
     */

    public DataDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Creates new database with meal and breakout tables, if it's already created, upgrades it.
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_MEAL_TABLE = "CREATE TABLE " + MealEntry.TABLE_NAME + " ("
                + MealEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MealEntry.COLUMN_MEAL_DATE + " INTEGER NOT NULL, "
                + MealEntry.COLUMN_MEAL_TYPE + " TEXT NOT NULL, "
                + MealEntry.COLUMN_FOOD + " TEXT NOT NULL, "
                + MealEntry.COLUMN_FOOD_CATEGORY + " TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_MEAL_TABLE);

        String SQL_CREATE_BREAKOUT_TABLE = "CREATE TABLE " + BreakoutEntry.TABLE_NAME + " ("
                + BreakoutEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BreakoutEntry.COLUMN_BREAKOUT_DATE + " INTEGER NOT NULL, "
                + BreakoutEntry.COLUMN_BREAKOUT_LEVEL + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_BREAKOUT_TABLE);

        Log.v(LOG_TAG, SQL_CREATE_MEAL_TABLE);
        Log.v(LOG_TAG, SQL_CREATE_BREAKOUT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

}
