package com.beatricefarias.acneapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakout);
        ButterKnife.bind(this);
        setTitle(R.string.breakout_activity);
    }

    @OnClick(R.id.breakout_0)
    public void setBreakoutTo0(Button breakout1) {
        breakoutWasLoggedToday();
        startHomeActivity();
    }

    @OnClick(R.id.breakout_1)
    public void setBreakoutTo1(Button breakout1) {
        breakoutWasLoggedToday();
        startHomeActivity();
    }

    @OnClick(R.id.breakout_2)
    public void setBreakoutTo2(Button breakout2) {
        breakoutWasLoggedToday();
        startHomeActivity();
    }

    @OnClick(R.id.breakout_3)
    public void setBreakoutTo3(Button breakout3) {
        breakoutWasLoggedToday();
        startHomeActivity();
    }

    @OnClick(R.id.breakout_4)
    public void setBreakoutTo4(Button breakout4) {
        breakoutWasLoggedToday();
        startHomeActivity();
    }

    @OnClick(R.id.breakout_5)
    public void setBreakoutTo5(Button breakout5) {
        breakoutWasLoggedToday();
        startHomeActivity();
    }

    /**
     * Method which starts home activity and finishes breakout activity.
     */
    public void startHomeActivity() {
        Intent homeActivity = new Intent(BreakoutActivity.this, HomeActivity.class);
        finish();
        startActivity(homeActivity);
    }

    /**
     * Method which updates shared preferences with the date of the breakout.
     */
    public void breakoutWasLoggedToday() {
        SharedPreferences preferences = getSharedPreferences(Constants.SHARED_PREFERENCES, MODE_PRIVATE);

        int todayInt = new Dates().getTodayDate();
        String currentDate = Integer.toString(todayInt);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.BREAKOUT_DATE, currentDate);
        editor.apply();
    }
}
