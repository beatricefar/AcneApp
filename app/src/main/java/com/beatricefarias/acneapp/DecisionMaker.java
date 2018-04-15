package com.beatricefarias.acneapp;

import android.content.SharedPreferences;

/**
 * Class which makes a decision to which activity user should be taken to
 */
public class DecisionMaker {
    private SharedPreferences preferences;

    /**
     * Constructor which assigns shared preferences object
     *
     * @param preferences
     */
    DecisionMaker(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    /**
     * Method
     *
     * @return HomeActivity class if user had selected breakout level that day already
     * BreakoutActivity class if user did not select breakout level earlier that day
     */
    Class run() {
        if (checkIfProgramRanBefore(preferences)) {
            makeBreakoutDatePreference(preferences);
            return BreakoutActivity.class;

        } else if (!checkIfProgramRanBefore(preferences)) {
            int todayInt = new Dates().getTodayDate();
            String today = Integer.toString(todayInt);

            String lastBreakoutDate = getLastBreakout(preferences);
            if (breakoutHappenedToday(lastBreakoutDate, today)) {
                return HomeActivity.class;
            } else if (!(breakoutHappenedToday(lastBreakoutDate, today))) {
                return BreakoutActivity.class;
            }
        }
        return null;
    }

    /**
     * Method which checks if program ran before
     *
     * @param preferences
     * @return boolean which indicates if program was ran for the first time
     */
    private boolean checkIfProgramRanBefore(SharedPreferences preferences) {
        return preferences.getBoolean(Constants.FIRST_RUN, true);
    }

    /**
     * Method which makes breakout date shared preference and sets a default value
     *
     * @param preferences
     */
    private void makeBreakoutDatePreference(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.BREAKOUT_DATE, Constants.FIRST_RUN_DEFAULT_BREAKOUT_DATE);
        editor.putBoolean(Constants.FIRST_RUN, false);
        editor.apply();
    }

    /**
     * Method which checks if breakout happened today or yesterday
     *
     * @param lastBreakoutDate takes in last breakout date from shared preferences
     * @param today            date
     * @return boolean if breakout information was already put in today
     */
    private boolean breakoutHappenedToday(String lastBreakoutDate, String today) {
        return lastBreakoutDate.equals(today);
    }

    /**
     * Gets shared preferences of last known breakout information which was entered by the user
     *
     * @param preferences
     * @return String date of last breakout
     */
    private String getLastBreakout(SharedPreferences preferences) {
        return preferences.getString(Constants.BREAKOUT_DATE, "");
    }
}
