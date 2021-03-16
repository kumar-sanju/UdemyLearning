package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OtherActivity extends AppCompatActivity {

    int clcik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Button start = (Button) findViewById(R.id.start);
        Button end = (Button) findViewById(R.id.end);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end.setVisibility(View.VISIBLE);
                clcik = 1;
            }
        });

        if (clcik == 1){
            end.setVisibility(View.INVISIBLE);
            clcik = 0;
        }


    }
}