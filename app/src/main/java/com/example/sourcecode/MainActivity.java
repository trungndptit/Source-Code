package com.example.sourcecode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCurrentDate();

    }

    private void getCurrentDate(){
        String pattern = "dd/MM/yyyy HH:mm:ss";
        @SuppressLint("SimpleDateFormat") SimpleDateFormat  df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();  // cach thu nhat de get current date
        String todayAsString = df.format(today);
        System.out.println("Today is: " + todayAsString);

    }

    private long getDateDiffInMinute(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    private long getDayDiff(Context context, String date) {
        Date dateStarted = getDateFromString(context, date);
        Date currentDate = new Date(); // cach thu hai de get current date
        long diffTime = getDateDiffInMinute(dateStarted, currentDate, TimeUnit.MINUTES);
        long diffDays = diffTime / (60 * 24) + 1;

        return diffDays;
    }

    private Date getDateFromString(Context context, String date) {
        Date dateStarted = new Date();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dateStarted = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateStarted;
    }

    Timer timer = new Timer();
    private void showTime() {
        final Handler handler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                final Calendar cali = (Calendar) msg.obj;
                // Update UI here
//                updateView(cali.get(Calendar.HOUR_OF_DAY), cali.get(Calendar.MINUTE), cali.get(Calendar.SECOND));
            }
        };
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    Calendar cali = Calendar.getInstance();
                    cali.getTime();
                    final Message msg = new Message();
                    msg.obj = cali;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
