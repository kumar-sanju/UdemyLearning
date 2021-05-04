package com.sanju.udemylearning.BackgroundProcess;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sanju.udemylearning.R;

public class BackgroundProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_process);
    }

    public void startBackGroundProcessButtonClick(View view) {

        Intent intent = new Intent(this, myBackgroundProcess.class);
        intent.setAction("BackgroundProcess");

        //Set the repeated Task
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, 0, 10, pendingIntent);

        finish();
    }
}