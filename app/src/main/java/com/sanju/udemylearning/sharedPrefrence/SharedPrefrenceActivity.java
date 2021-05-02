package com.sanju.udemylearning.sharedPrefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.sanju.udemylearning.R;

import java.io.IOException;
import java.util.ArrayList;

public class SharedPrefrenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefrence);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.sanju.udemylearning", Context.MODE_PRIVATE);
/*
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Abc");
        friends.add("xyz");

        try {
            sharedPreferences.edit().putString("friends", ObjectSerializer.serialize(friends)).apply();

        } catch (IOException e) {
            e.printStackTrace();
        }

 */

        ArrayList<String> newFriends = new ArrayList<>();
        try {
            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends", ObjectSerializer.serialize(new ArrayList<String>())));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("new", newFriends.toString());

//        sharedPreferences.edit().putString("username", "sanju").apply();
//        String username = sharedPreferences.getString("username","");
//        Log.i("sanju", username);

    }
}