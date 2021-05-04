package com.sanju.udemylearning.JSON;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sanju.udemylearning.R;

public class JsonActivity extends AppCompatActivity {

    Button btn;
    TextView text;
    String url = "http://www.json-generator.com/api/json/get/cgzxGfyxXC?indent=2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        btn = findViewById(R.id.btn);
        text = findViewById(R.id.text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}