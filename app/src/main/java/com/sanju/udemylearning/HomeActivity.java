package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button other = (Button) findViewById(R.id.other);
        Button btn = (Button) findViewById(R.id.fadebtn);
        Button video = (Button) findViewById(R.id.video);
        Button audio = (Button) findViewById(R.id.audio);
        Button gridLayout = (Button) findViewById(R.id.gridLayout);
        Button swipeVideo = (Button) findViewById(R.id.swipeVideo);
        Button listView = (Button) findViewById(R.id.listView);
        Button sharedAnimation = (Button) findViewById(R.id.sharedAnimation);
        Button downloadWebConntent = (Button) findViewById(R.id.downloadWebConntent);
        Button neumerphic = (Button) findViewById(R.id.neumerphic);
        Button buttonNavigation = (Button) findViewById(R.id.buttonNavigation);
        Button collapsingToolbar = (Button) findViewById(R.id.collapsingToolbar);
        Button animateTransitions = (Button) findViewById(R.id.animateTransitions);
        Button otherAnimation = (Button) findViewById(R.id.otherAnimation);
        Button newLook = (Button) findViewById(R.id.newLook);
        Button circleAnimation = (Button) findViewById(R.id.circleAnimation);
        Button progressBar = (Button) findViewById(R.id.progressBar);
        Button progressButton = (Button) findViewById(R.id.progressButton);
        Button multipleImagePicker = (Button) findViewById(R.id.multipleImagePicker);

        multipleImagePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ImagePickerActivity.class));
            }
        });
        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ProgressButtonActivity.class));
            }
        });
        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CircularProgressBarActivity.class));
            }
        });
        circleAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CircleAnimationActivity.class));
            }
        });
        newLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, NewLookActivity.class));
            }
        });
        otherAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, OtherActivity.class));
            }
        });
        animateTransitions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AnimateTransitionsActivity.class));
            }
        });
        collapsingToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CollapsingToolbarActivity.class));
            }
        });
        buttonNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ButtonNaviagtionActivity.class));
            }
        });
        neumerphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, NeumorphicAnimationActivity.class));
            }
        });
        downloadWebConntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DownloadWebcontentActivity.class));
            }
        });
        sharedAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SharedAnimationActivity.class));
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ListviewActivity.class));
            }
        });
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ListviewActivity.class));
            }
        });
        swipeVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SwipeVideoActivity.class));
            }
        });
        gridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, GridlayoutActivity.class));
            }
        });
        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AudioActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, FadingAnimActivity.class));
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, VideoActivity.class));
            }
        });



    }
}