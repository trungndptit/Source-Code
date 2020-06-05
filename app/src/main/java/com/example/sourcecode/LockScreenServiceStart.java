package com.example.sourcecode;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import static com.example.sourcecode.App.CHANNEL_ID;

public class LockScreenServiceStart extends Service {

    private BroadcastReceiver mReceiver;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        mReceiver = new LockScreenIntentReceiver();
        registerReceiver(mReceiver, filter);
        startForeground();
        return START_STICKY;
    }

    private static final int ID_NOTIFICATION = 230197;

    private void startForeground() {
        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(),
                11111, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

//        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.layout_custom_notification);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setContentTitle("Been Love Memory")
                .setContentText("Screen Lock ready to run")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(Notification.PRIORITY_MAX);
        builder.setContentIntent(contentIntent);

        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.flags |= Notification.FLAG_NO_CLEAR;

        System.out.println("Debug startForeground");
        startForeground(ID_NOTIFICATION, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mReceiver != null) {
            unregisterReceiver(mReceiver);
        }
    }
}
