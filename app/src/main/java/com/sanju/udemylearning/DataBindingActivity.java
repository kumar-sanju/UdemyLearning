package com.sanju.udemylearning;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sanju.udemylearning.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding);

        ActivityDataBindingBinding activityDataBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        // or
//        ActivityDataBindingBinding activityDataBindingBinding = ActivityDataBindingBinding.inflate(getLayoutInflater());
//        setContentView(activityDataBindingBinding.getRoot());

//        activityDataBindingBinding.setMyVariable("Hello databinding....");

        DataBindingUser dataBindingUser = new DataBindingUser("Manju", 24, true, "https://picsum.photos/200/300");

        activityDataBindingBinding.setUser(dataBindingUser);

//        activityDataBindingBinding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }
}