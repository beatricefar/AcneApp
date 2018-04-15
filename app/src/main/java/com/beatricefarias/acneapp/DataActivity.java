package com.beatricefarias.acneapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        setTitle(R.string.data_activity);
    }
}
