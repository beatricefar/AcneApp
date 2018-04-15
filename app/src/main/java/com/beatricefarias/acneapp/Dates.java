package com.beatricefarias.acneapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dates {
    private SimpleDateFormat dateFormat;

    /**
     * Constructor which constructs simpleDateFormat
     */
    public Dates(){
        dateFormat = new SimpleDateFormat(Constants.DATA_FORMAT);
    }

    /**
     * Method which calculates today's date
     * @return int today'd date
     */
    private int calculateTodayDate(){
        Calendar todayDate = Calendar.getInstance();
        String todayDateString = dateFormat.format(todayDate.getTime());
        int today = Integer.parseInt(todayDateString);
        return today;
    }

    /**
     * Method which calculates yesterday's date
     * @return int yesterday's date
     */
    private int calculateYesterdayDate(){
        Calendar yesterdayDate = Calendar.getInstance();
        yesterdayDate.add(Calendar.DATE, -1);
        String yesterdayDateString = dateFormat.format(yesterdayDate.getTime());
        int yesterday = Integer.parseInt(yesterdayDateString);
        return yesterday;
    }

    /**
     * Method which gets today's date
     * @return today's date integer
     */
    public int getTodayDate(){
        return calculateTodayDate();
    }

    /**
     * Method which gets yesterday's date
     * @return yesterday's date integer
     */
    public int getYesterdayDate(){
        return calculateYesterdayDate();
    }

}