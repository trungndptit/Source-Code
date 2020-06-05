package com.example.sourcecode;

import android.content.Context;
import android.text.format.DateFormat;

import java.util.Date;

public class MyTimeSingleton {

    private int mYear = 0;
    private int mMonth = 0;
    private int mWeek = 0;
    private int mDay = 0;
    private int mHour = 0;
    private int mMinute = 0;
    private int mSecond = 0;

    private static MyTimeSingleton INSTANCE;

    private Context mContext;

    private MyTimeSingleton(Context context) {
        mContext = context;
    }

    public static MyTimeSingleton getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new MyTimeSingleton(context);
        }
        return INSTANCE;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int year) {
        mYear = year;
    }

    public int getMonth() {
        return mMonth;
    }

    public void setMonth(int month) {
        mMonth = month;
    }

    public int getWeek() {
        return mWeek;
    }

    public void setWeek(int week) {
        mWeek = week;
    }

    public int getDay() {
        return mDay;
    }

    public void setDay(int day) {
        mDay = day;
    }

    public int getHour() {
        return mHour;
    }

    public void setHour(int hour) {
        mHour = hour;
    }

    public int getMinute() {
        return mMinute;
    }

    public void setMinute(int minute) {
        mMinute = minute;
    }

    public int getSecond() {
        return mSecond;
    }

    public void setSecond(int second) {
        mSecond = second;
    }

    public static void destroyInstance() {
        if (INSTANCE != null) {
            INSTANCE = null;
        }
    }
}
