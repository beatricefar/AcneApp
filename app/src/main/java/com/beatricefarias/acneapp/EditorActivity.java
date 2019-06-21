package com.beatricefarias.acneapp;

import com.beatricefarias.acneapp.Database.DataContract;
import com.beatricefarias.acneapp.Database.DataContract.MealEntry;
import com.beatricefarias.acneapp.Database.DataDbHelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class EditorActivity extends AppCompatActivity {

    private EditText foodEditText;
    private EditText categoryEditText;
    private Spinner mealSpinner;
    private int meal;
    private int today;
    private DataDbHelper dataDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        foodEditText = (EditText) findViewById(R.id.edit_food_info);
        categoryEditText = (EditText) findViewById(R.id.edit_food_category);
        mealSpinner = (Spinner) findViewById(R.id.spinner_meal);

        setupSpinner();

        today = new Dates().getTodayDate();
        dataDbHelper = new DataDbHelper(this);
    }

    /**
     * Gets user input from the entries and adds them into Meal database
     */

    public void insertMealData() {

        String foodInput = foodEditText.getText().toString().trim();
        String foodCategoryInput = categoryEditText.getText().toString().trim();

        SQLiteDatabase mealDb = dataDbHelper.getWritableDatabase();

        ContentValues mealValues = new ContentValues();

        mealValues.put(DataContract.MealEntry.COLUMN_MEAL_DATE, today);
        mealValues.put(DataContract.MealEntry.COLUMN_MEAL_TYPE, meal);
        mealValues.put(DataContract.MealEntry.COLUMN_FOOD, foodInput);
        mealValues.put(DataContract.MealEntry.COLUMN_FOOD_CATEGORY, foodCategoryInput);

        long newRowId = mealDb.insert(DataContract.MealEntry.TABLE_NAME, null, mealValues);
        Log.v("New row id", "New row id" + newRowId);
    }

    /**
     * Method which sets up a spinner by creating an adapter and applying it to spinner
     * Sets up onItemSelected listener for click events
     */
    private void setupSpinner() {
        ArrayAdapter mealSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_meal_options, android.R.layout.simple_spinner_item);

        mealSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mealSpinner.setAdapter(mealSpinnerAdapter);

        mealSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.option_spinner_breakfast))) {
                        meal = MealEntry.MEAL_BREAKFAST; // Breakfast
                    } else if (selection.equals(getString(R.string.option_spinner_lunch))) {
                        meal = MealEntry.MEAL_LUNCH; // Lunch
                    } else if (selection.equals(getString(R.string.option_spinner_dinner))) {
                        meal = MealEntry.MEAL_DINNER; // Dinner
                    } else {
                        meal = MealEntry.MEAL_SNACK; // Snack
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                meal = 0; // Unknown
            }
        });
    }

    /**
     * Inflates menu options from menu_editor.xml file and adds them to app bar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
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
            case R.id.action_save_meal:
                insertMealData();
                finish();
                return true;
            case R.id.action_delete_all_entries:
                // WIP
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
