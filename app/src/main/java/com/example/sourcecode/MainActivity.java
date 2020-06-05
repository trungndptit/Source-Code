package com.example.sourcecode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String MY_SHARED_PREFERENCES = "my_shared_preferences";

    private static String PERCENTS = "percents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void savePercentList(Context context, List<Integer> percents) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String jsonLockedApp = gson.toJson(percents);
        editor.putString(PERCENTS, jsonLockedApp);
        editor.apply();
    }

    public static ArrayList<Integer> getPercentList(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        List<Integer> percentList = null;
        ArrayList<Integer> percents = new ArrayList<>();

        Gson gson = new Gson();
        String jsonLocked = sharedPref.getString(PERCENTS, null);
        Integer[] percentItems = gson.fromJson(jsonLocked,
                Integer[].class);

        if (percentItems != null) {
            percentList = Arrays.asList(percentItems);
        } else {
            percentList = new ArrayList<>();
        }
        percents = new ArrayList<Integer>(percentList);

        return percents;
    }

    public static void addPercent(Context context, int percent) {
        List<Integer> percents = getPercentList(context);
        percents.add(percent);
        savePercentList(context, percents);
    }

    public static void removePercent(Context context, int percent) {
        ArrayList<Integer> percentList = getPercentList(context);
        percentList.remove(percent);
        savePercentList(context, percentList);
    }

    public static void removeAllLocked(Context context){
        ArrayList<Integer> percentList = getPercentList(context);
        percentList.clear();
        savePercentList(context, percentList);
    }
}
