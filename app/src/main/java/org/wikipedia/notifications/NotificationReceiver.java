package org.wikipedia.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import org.wikipedia.R;
import org.wikipedia.random.RandomActivity;

/* This class will display a Notification of a Random Article */

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String CHANNEL_ID = "channel_01";
        PendingIntent notificationIntent = PendingIntent.getActivity(context,0,new Intent(context, RandomActivity.class),0);

        NotificationManager manager =( NotificationManager ) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Create a channel for our random article notifications
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            CharSequence name = "notification_channel";
            String Description = "This is the notification channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mChannel.setDescription(Description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mChannel.setShowBadge(false);
            manager.createNotificationChannel(mChannel);
        }

        Intent resultIntent = new Intent(context, RandomActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(NotificationSchedulerActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        // Build the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_wikipedia)
                .setContentTitle("Hey! Want to read something interesting?")
                .setContentText("Click here to read a random article on Wikipedia.");
        builder.addAction(R.drawable.ic_wikipedia, "Check it out", notificationIntent);
        builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        builder.setAutoCancel(true);
        builder.setContentIntent(resultPendingIntent);

        manager.notify(1, builder.build());
        //mm.cancel(1);
    }

}