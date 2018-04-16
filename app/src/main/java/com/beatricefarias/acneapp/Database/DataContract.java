package com.beatricefarias.acneapp.Database;

import android.provider.BaseColumns;

public class DataContract {

    private DataContract() {}

    public static final class MealEntry implements BaseColumns {

        /**
         *  Name of database for meal and breakout information.
         */
        public final static String TABLE_NAME = "meal_data";

        /**
         * Unique ID for each meal
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Date of the meal
         * Type: INTEGER
         */
        public final static String COLUMN_MEAL_DATE = "meal_date";

        /**
         * Food name
         * Type: TEXT
         */
        public final static String COLUMN_FOOD = "food";

        /**
         * Food category
         * Type: TEXT
         */
        public final static String COLUMN_FOOD_CATEGORY = "food_category";

        /**
         * Meal type
         * Type: TEXT
         */
        public final static String COLUMN_MEAL_TYPE = "meal_type";

        /**
         * Possible values for meal type
         */

        public static final int MEAL_BREAKFAST = 0;

        public static final int MEAL_LUNCH = 1;

        public static final int MEAL_DINNER = 2;

        public static final int MEAL_SNACK = 3;


    }

    public static final class BreakoutEntry implements BaseColumns {

        /**
         *  Name of database for meal and breakout information.
         */
        public final static String TABLE_NAME = "breakout_data";

        /**
         * Unique ID for each breakout
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Date of the breakout
         * Type: INTEGER
         */
        public final static String COLUMN_BREAKOUT_DATE = "breakout_date";

        /**
         * Breakout level of that day
         * Type: INTEGER
         */
        public final static String COLUMN_BREAKOUT_LEVEL = "breakout_level";

        /**
         * Possible values for breakout level
         */

        public static final int BREAKOUT_LEVEL_0 = 0;

        public static final int BREAKOUT_LEVEL_1 = 1;

        public static final int BREAKOUT_LEVEL_2 = 2;

        public static final int BREAKOUT_LEVEL_3 = 3;

        public static final int BREAKOUT_LEVEL_4 = 4;

        public static final int BREAKOUT_LEVEL_5 = 5;

    }
}
