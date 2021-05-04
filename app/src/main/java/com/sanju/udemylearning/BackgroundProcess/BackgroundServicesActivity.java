package com.sanju.udemylearning.BackgroundProcess;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sanju.udemylearning.R;

public class BackgroundServicesActivity extends AppCompatActivity {

    public static final String ACTION_CHECK_STATUS = "action_check_status";
    public static final String ACTION_DO_STAFF = "action_do_staff";
    Button startBtn;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_services);

        progressBar = findViewById(R.id.progressBar);
        startBtn = findViewById(R.id.startBtn);
        textView = findViewById(R.id.textView);

        registerReceiver(myBroadcastReciever, new IntentFilter(ACTION_CHECK_STATUS));

    }

    public void startBtn(View view) {
        SimpleJobIntentService.enqueueWork(this, new Intent().setAction(ACTION_DO_STAFF));
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myBroadcastReciever, new IntentFilter(ACTION_CHECK_STATUS));
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(myBroadcastReciever);
        } catch (Exception e){

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(myBroadcastReciever);
        } catch (Exception e){

        }
    }

    private BroadcastReceiver myBroadcastReciever = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getExtras() != null){
                int status = intent.getExtras().getInt("status",0);
                textView.setText(String.valueOf(status+"%"));
                progressBar.setProgress(status,true);

            }
        }
    };

}