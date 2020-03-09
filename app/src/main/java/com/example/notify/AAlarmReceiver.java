package com.example.notify;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.widget.Toast;

public class AAlarmReceiver extends BroadcastReceiver {
    MediaPlayer mmp;
    @Override
    public void onReceive(Context context, Intent intent) {
        int notification=intent.getIntExtra("Notification",0);
        String message=intent.getStringExtra("todo");
        Intent mainIntent=new Intent(context,Alarm.class);
        PendingIntent contentIntent=PendingIntent.getActivity(context,0,mainIntent,0);

        NotificationManager my=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder=new Notification.Builder(context);
        builder.setSmallIcon(android.R.drawable.ic_menu_camera)
                .setContentTitle("its Time")
                .setContentText(message)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contentIntent);
        my.notify(notification,builder.build());
        mmp=MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mmp.start();
        Toast.makeText(context,"Alarm is on",Toast.LENGTH_SHORT).show();
    }
}
