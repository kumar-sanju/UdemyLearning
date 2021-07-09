package com.sanju.udemylearning.Sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.sanju.udemylearning.R;

public class GradeActivity extends AppCompatActivity {

    private database db = new database(this);
    private EditText txt_grade;
    private Spinner spnr_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
    }

    public void add(View view) {
    }
}