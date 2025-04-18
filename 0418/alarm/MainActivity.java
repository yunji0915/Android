package com.example.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText timeInput;
    Button startButton;
    int lastMinutes = 1; // 기본값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeInput = findViewById(R.id.timeInput);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(v -> {
            String input = timeInput.getText().toString().trim();
            if (!input.isEmpty()) {
                lastMinutes = Integer.parseInt(input);
                setAlarm(lastMinutes);
                Toast.makeText(this, lastMinutes + "분 뒤 알림 설정됨", Toast.LENGTH_SHORT).show();
            }
        });

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

    }

    void setAlarm(int minutes) {
        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.putExtra("minutes", minutes);  // 다음에 반복하려고 저장
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long triggerTime = System.currentTimeMillis() + minutes * 60 * 1000;
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
    }
}
