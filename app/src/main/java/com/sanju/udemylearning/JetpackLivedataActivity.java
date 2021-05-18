package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class JetpackLivedataActivity extends AppCompatActivity {

    EditText etText;
    ModelViewModel modelViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jetpack_livedata);

        etText = findViewById(R.id.et_text);

        modelViewModel = ViewModelProviders.of(JetpackLivedataActivity.this)
                .get(ModelViewModel.class);

        etText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                modelViewModel.setText(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        Fragment fragment = new LivedataFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();

    }
}