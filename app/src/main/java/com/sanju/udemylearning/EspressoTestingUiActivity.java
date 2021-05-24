package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EspressoTestingUiActivity extends AppCompatActivity {


    // Click the cursor on activity and click (alt + enter)
    // click on generate setUp & tearDown method
    // make sure your android class is in android test Package not on test package


    private Button btnChange ;
    private EditText etTextToChange;
    private TextView tvChangedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_testing_ui);

        btnChange = (Button) findViewById(R.id.btnChange);
        etTextToChange = (EditText) findViewById(R.id.etTextToChange);
        tvChangedText = (TextView) findViewById(R.id.tvChangedText);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvChangedText.setText(etTextToChange.getText());
            }
        });
    }
}