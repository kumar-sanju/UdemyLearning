package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CircularProgressBarActivity extends AppCompatActivity {
    
    private ProgressBar progressBar, progress;
    private int say = 0;
    private TextView value;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_progress_bar);

        progressBar = findViewById(R.id. progress_bar);
        progress = findViewById(R.id. progress);
        btn = findViewById(R.id. btn);
        value = findViewById(R.id. value);

        progress.setMax(100);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                say++;
                progress.setProgress(say);
                value.setText(say+ "%");
            }
        });

        progressBar.setVisibility(View.VISIBLE);
        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        },6000);
        
    }
}