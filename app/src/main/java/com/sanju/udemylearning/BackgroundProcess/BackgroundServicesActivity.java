package com.sanju.udemylearning.BackgroundProcess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sanju.udemylearning.R;

public class BackgroundServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_services);

        final TextView text = findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("Started")) {
                    text.setText("Stoped");
                    stopService(new Intent(BackgroundServicesActivity.this,service.class));
                } else {
                    text.setText("Started");
                    startService(new Intent(BackgroundServicesActivity.this,service.class));
                }
            }
        });
    }
}