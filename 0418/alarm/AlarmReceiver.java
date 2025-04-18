package com.example.alarm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int minutes = intent.getIntExtra("minutes", 1);

        Intent repeatIntent = new Intent(context, MainActivity.class);
        repeatIntent.putExtra("repeat", true);
        repeatIntent.putExtra("minutes", minutes);
        PendingIntent repeatPending = PendingIntent.getActivity(context, 1, repeatIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = "timer_channel";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, "Timer Alerts", NotificationManager.IMPORTANCE_HIGH);
            channel.enableLights(true);
            channel.setLightColor(Color.BLUE);
            channel.enableVibration(true);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("타이머 종료")
                .setContentText("설정한 시간이 끝났습니다!")
                .addAction(android.R.drawable.ic_media_play, "계속", repeatPending)
                .setAutoCancel(true);

        manager.notify(1001, builder.build());
    }
}
