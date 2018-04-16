package com.beatricefarias.acneapp;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.beatricefarias.acneapp.Database.DataContract;
import com.beatricefarias.acneapp.Database.DataContract.BreakoutEntry;
import com.beatricefarias.acneapp.Database.DataDbHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BreakoutActivity extends AppCompatActivity {

    @BindView(R.id.breakout_0)
    Button breakout0;
    @BindView(R.id.breakout_1)
    Button breakout1;
    @BindView(R.id.breakout_2)
    Button breakout2;
    @BindView(R.id.breakout_3)
    Button breakout3;
    @BindView(R.id.breakout_4)
    Button breakout4;
    @BindView(R.id.breakout_5)
    Button breakout5;

    private DataDbHelper dataDbHelper;
    private int breakoutLevel = 0;
    private int today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakout);
        ButterKnife.bind(this);
        setTitle(R.string.breakout_activity);

        dataDbHelper = new DataDbHelper(this);
        today = new Dates().getTodayDate();
    }

    @OnClick(R.id.breakout_0)
    public void setBreakoutTo0(Button breakout1) {
        breakoutWasLoggedToday();
        breakoutLevel = BreakoutEntry.BREAKOUT_LEVEL_0;
        insertBreakoutData();
        startHomeActivity();
    }

    @OnClick(R.id.breakout_1)
    public void setBreakoutTo1(Button breakout1) {
        breakoutWasLoggedToday();
        breakoutLevel = BreakoutEntry.BREAKOUT_LEVEL_1;
        insertBreakoutData();
        startHomeActivity();
    }

    @OnClick(R.id.breakout_2)
    public void setBreakoutTo2(Button breakout2) {
        breakoutWasLoggedToday();
        breakoutLevel = BreakoutEntry.BREAKOUT_LEVEL_2;
        insertBreakoutData();
        startHomeActivity();
    }

    @OnClick(R.id.breakout_3)
    public void setBreakoutTo3(Button breakout3) {
        breakoutWasLoggedToday();
        breakoutLevel = BreakoutEntry.BREAKOUT_LEVEL_3;
        insertBreakoutData();
        startHomeActivity();
    }

    @OnClick(R.id.breakout_4)
    public void setBreakoutTo4(Button breakout4) {
        breakoutWasLoggedToday();
        breakoutLevel = BreakoutEntry.BREAKOUT_LEVEL_4;
        insertBreakoutData();
        startHomeActivity();
    }

    @OnClick(R.id.breakout_5)
    public void setBreakoutTo5(Button breakout5) {
        breakoutWasLoggedToday();
        breakoutLevel = BreakoutEntry.BREAKOUT_LEVEL_5;
        insertBreakoutData();
        startHomeActivity();
    }

    /**
     * Method which inserts Breakout data in breakout_data table
     */
    public void insertBreakoutData() {

        SQLiteDatabase breakoutDb = dataDbHelper.getWritableDatabase();
        ContentValues breakoutValues = new ContentValues();

        breakoutValues.put(BreakoutEntry.COLUMN_BREAKOUT_DATE, today);
        breakoutValues.put(BreakoutEntry.COLUMN_BREAKOUT_LEVEL, breakoutLevel);

        long newRowId = breakoutDb.insert(DataContract.BreakoutEntry.TABLE_NAME, null, breakoutValues);
        Log.v("New row id", "New row id breakout" + newRowId);
    }

    /**
     * Method which starts home activity and finishes breakout activity.
     */
    private void startHomeActivity() {
        Intent homeActivity = new Intent(BreakoutActivity.this, HomeActivity.class);
        finish();
        startActivity(homeActivity);
    }

    /**
     * Method which updates shared preferences with the date of the breakout.
     */
    private void breakoutWasLoggedToday() {
        SharedPreferences preferences = getSharedPreferences(Constants.SHARED_PREFERENCES, MODE_PRIVATE);

        int todayInt = new Dates().getTodayDate();
        String currentDate = Integer.toString(todayInt);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.BREAKOUT_DATE, currentDate);
        editor.apply();
    }
}
