package com.beatricefarias.acneapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences();
    }

    /**
     * Method starts right activity depending on user shared preferences state
     */
    @Override
    protected void onResume() {
        super.onResume();
        Class activity = new DecisionMaker(preferences).run();
        Intent goToBreakout = new Intent(getBaseContext(), activity);
        finish();
        startActivity(goToBreakout);
    }

    /**
     * Method which gets shared preferences object
     * @return shared preferences object
     */
    private SharedPreferences getSharedPreferences() {
        return getSharedPreferences(Constants.SHARED_PREFERENCES, MODE_PRIVATE);
    }
}
