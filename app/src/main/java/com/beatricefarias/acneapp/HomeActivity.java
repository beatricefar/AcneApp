package com.beatricefarias.acneapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.beatricefarias.acneapp.Database.DataContract.MealEntry;
import com.beatricefarias.acneapp.Database.DataDbHelper;

public class HomeActivity extends AppCompatActivity {

    FloatingActionButton addMeal;

    private Intent editorActivity;
    private DataDbHelper dataDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle(R.string.home_activity);

        dataDbHelper = new DataDbHelper(this);

        displayDatabaseInfo();
    }

    public void addMeal(FloatingActionButton addMeal) {
        editorActivity = new Intent(HomeActivity.this, EditorActivity.class);
        startActivity(editorActivity);
    }

    /**
     * A method to display info from database.
     * In this case, it will display food name and category of current day,
     * where meal type is set to breakfast.
     */
    private void displayDatabaseInfo() {
        SQLiteDatabase db = dataDbHelper.getReadableDatabase();
        int today = new Dates().getTodayDate();

        String[] projection = {
                MealEntry.COLUMN_FOOD,
                MealEntry.COLUMN_FOOD_CATEGORY
        };

        String selection = MealEntry.COLUMN_MEAL_DATE + " = ?";
        String selectionArgs[] = { Integer.toString(today) };

        String sortOrder = MealEntry.COLUMN_FOOD + " DESC";

        Cursor cursor = db.query(
                MealEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        TextView displayDb = (TextView) findViewById(R.id.display_db_textview);

        try {
            displayDb.setText("Number of rows in meal database table (breakfast): " + cursor.getCount() + "\n");
            displayDb.append(MealEntry.COLUMN_FOOD + " " + MealEntry.COLUMN_FOOD_CATEGORY + "\n");

            int foodColumnIndex = cursor.getColumnIndex(MealEntry.COLUMN_FOOD);
            int foodCategoryColumnIndex = cursor.getColumnIndex(MealEntry.COLUMN_FOOD_CATEGORY);

            while (cursor.moveToNext()) {
                String currentFood = cursor.getString(foodColumnIndex);
                String currentFoodCategory = cursor.getString(foodCategoryColumnIndex);

                displayDb.append(("\n" + currentFood + " - " + currentFoodCategory));
            }
        } finally {
            cursor.close();
        }
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
