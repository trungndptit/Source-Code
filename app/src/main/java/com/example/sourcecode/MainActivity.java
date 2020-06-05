package com.example.sourcecode;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import static com.example.sourcecode.App.CHANNEL_ID;
import static com.example.sourcecode.App.CHANNEL_ID2;

public class MainActivity extends AppCompatActivity {

    Button mButton;

    private static boolean isNotiShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isNotiShowing){
                    showNotification(MainActivity.this);
                }
                else {
                    removeNotification(MainActivity.this);
                }
            }
        });
    }

    public static RemoteViews notificationLayout;
    public static NotificationCompat.Builder builderNoti;
    public static Notification notification;
    public static NotificationManager notificationManager;
    public static final int ID_NOTIFICATION = 240197;

    public static void showNotification(Context context) {
        isNotiShowing = true;
        notificationLayout = new RemoteViews(context.getPackageName(), R.layout.layout_custom_notification);

        builderNoti = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setCustomContentView(notificationLayout)
                .setSmallIcon(R.drawable.logo)
                .setPriority(Notification.PRIORITY_MAX);

        Intent mainActivityIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                context, 0, mainActivityIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builderNoti.setContentIntent(pendingIntent);

        notification = builderNoti.build();
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notification.flags |= Notification.FLAG_NO_CLEAR;
        notificationManager.notify(ID_NOTIFICATION, notification);

    }

    public static void removeNotification(Context context) {
        isNotiShowing = false;
        NotificationManager notificationManager =
                (NotificationManager) context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(ID_NOTIFICATION);
    }

    public static void updateNotification(Context context){
        if (!isNotiShowing){
            return;
        }
        int currentPercent = 150;
        notificationLayout.setTextViewText(R.id.tv_current, "Current font size : " + currentPercent + "%");
    }
}
