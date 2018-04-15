package com.beatricefarias.acneapp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dates {

    public Dates(){}

    private int calculateTodayDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar todayDate = Calendar.getInstance();
        String todayDateString = dateFormat.format(todayDate.getTime());
        int today = Integer.parseInt(todayDateString);
        return today;
    }

    private int calculateYesterdayDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar yesterdayDate = Calendar.getInstance();
        yesterdayDate.add(Calendar.DATE, -1);
        String yesterdayDateString = dateFormat.format(yesterdayDate.getTime());
        int yesterday = Integer.parseInt(yesterdayDateString);
        return yesterday;
    }

    public int getTodayDate(){
        return calculateTodayDate();
    }

    public int getYesterdayDate(){
        return calculateYesterdayDate();
    }

}