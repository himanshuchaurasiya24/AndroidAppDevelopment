package com.chaurasiya.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "My Channel ID";
    private static final int  NOTIFICATION_ID = 100;
    private static final int  REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Convert image to bitmap --> Code
        // 1. use png here no svg or jpeg if you don't want your app to crash
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.pngwing, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        assert bitmapDrawable != null;
        Bitmap largeIcon = bitmapDrawable.getBitmap();
        // Code ends here
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE); // to get notification service active;
        Intent iNotify = new Intent(getApplicationContext(), MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // to clear multiple stack of an app if user has opened notification many time;
        PendingIntent pi = PendingIntent.getActivity(this,REQ_CODE,  iNotify,PendingIntent.FLAG_IMMUTABLE);
        // Big picture Style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(), R.drawable.sample, null))).getBitmap())
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Image seen by Himanshu")
                .setSummaryText("Image Message");
        // Inbox Style
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("A")
                .addLine("B")
                .addLine("A")
                .addLine("A")
                .addLine("C")
                .addLine("A")
                .addLine("A")
                .addLine("D")
                .setBigContentTitle("Full Message")
                .setSummaryText("Message from Himanshu"); // not applicable after android 11;


        Notification notification = new Notification.Builder(this)
                .setLargeIcon(largeIcon)
                .setSmallIcon(R.drawable.pngwing)
                .setContentText("New Message")
                .setContentIntent(pi)
                .setStyle(inboxStyle)
//                .setAutoCancel(false)
                .setOngoing(true)
//                .setSubText("New message from Himanshu Chaurasiya")
                .setChannelId(CHANNEL_ID)
                .build();
        nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "Himanshu's Channel", NotificationManager.IMPORTANCE_HIGH));
        // keep priority high always ;
        nm.notify(NOTIFICATION_ID,notification );
        // id in notify() if it's different from previous one then new tab of notification will be thrown else previous notification will be updated;
        // use notification channel to throw personalised notification;

    }
}