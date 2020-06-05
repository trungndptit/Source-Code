package com.example.sourcecode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;

public class LockScreenIntentReceiver extends BroadcastReceiver {
    Context mContext;
    Handler handler = new Handler();
    private boolean isRunning = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;

        if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            System.out.println("Debug Action on");
            // Do something here
//            start_lockscreen(context);
//            if (isRunning){
//            handler.removeCallbacks(StopServiceRun);
//            }
        }
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            System.out.println("Debug Action off");
            // Do something here
//            start_lockscreen(context);
//            handler.postDelayed(StopServiceRun, 60000);
//            isRunning = true;

        }
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            // Do something here
//                context.startService(new Intent(context, LockscreenServiceStart.class));
//                start_lockscreen(context);

        }
    }

//    public Runnable StopServiceRun = new Runnable() {
//        @Override
//        public void run() {
//            // TODO Auto-generated method stub
//            isRunning = false;
//            stop_lockscreen(mContext);
//        }
//    };

//    private void start_lockscreen(Context context) {
//        if (Build.VERSION.SDK_INT >= 23) {
//            if (android.provider.Settings.canDrawOverlays(context)) {
//                context.startService(new Intent(context, LockscreenService.class));
//            }
//        } else {
//            context.startService(new Intent(context, LockscreenService.class));
//        }
//    }
//
//    private void stop_lockscreen(Context context) {
//        mContext.stopService(new Intent(mContext, LockscreenService.class));
//    }

}
