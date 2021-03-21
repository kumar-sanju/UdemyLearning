package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class GridlayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridlayout);
    }

    public void buttonTapped(View view) {

        int id = view.getId();
        String ourId = "";

        ourId = view.getResources().getResourceEntryName(id);
//         int resourceId = getResources().getIdentifier(ourId, "raw","com.sanju.udemylearning");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sizzling);
        mediaPlayer.start();

        Log.i("Button Pressed", ourId);
//        Log.i("Button Pressed", Integer.toString(view.getId()));

    }
}