package com.sanju.udemylearning.Sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sanju.udemylearning.R;

public class LevelActivity extends AppCompatActivity {

    EditText text_level;
    database db = new database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        text_level = findViewById(R.id.text_level);

    }

    public void add(View view) {
        String level = text_level.getText().toString().trim();
        if (!level.isEmpty()){
            boolean result = db.insertLevel(level);
            if (result){
                Toast.makeText(this,"Saved successfully.", Toast.LENGTH_SHORT).show();
                text_level.setText("");
            }
        }
    }
}