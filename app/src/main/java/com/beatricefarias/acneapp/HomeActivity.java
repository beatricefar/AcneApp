package com.beatricefarias.acneapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.action_add_meal)
    Button addMeal;

    private Intent editorActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setTitle(R.string.home_activity);

    }

    @OnClick(R.id.action_add_meal)
    public void addMeal(Button addMeal) {
        editorActivity = new Intent(HomeActivity.this, EditorActivity.class);
        startActivity(editorActivity);
    }

    /**
     * Inflates menu options from menu_home.xml file and adds them to app bar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    /**
     * Delegates what happens when each option is selected in app menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_insert_dummy_data:
                // WIP
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                // WIP
                return true;

            case R.id.action_open_data_activity:
                Intent dataActivity = new Intent(HomeActivity.this, DataActivity.class);
                startActivity(dataActivity);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
