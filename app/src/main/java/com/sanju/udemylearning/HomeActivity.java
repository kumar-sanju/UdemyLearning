package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sanju.udemylearning.BackgroundProcess.BackgroundProcessActivity;
import com.sanju.udemylearning.BackgroundProcess.BackgroundServicesActivity;
import com.sanju.udemylearning.NoteApp.NoteUsingSharedPrefrenceActivity;
import com.sanju.udemylearning.RecyclerView.GridRecyclerViewStudyActivity;
import com.sanju.udemylearning.RecyclerView.SimpleRecyclerViewStudyActivity;
import com.sanju.udemylearning.Retrofit.RetrofitStudyActivity;
import com.sanju.udemylearning.androidxCamera.CameraxActivity;
import com.sanju.udemylearning.sharedPrefrence.SharedPrefrenceActivity;

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
        Button imageProgressBar = (Button) findViewById(R.id.imageProgressBar);
        Button emailSend = (Button) findViewById(R.id.emailSend);
        Button jsonRecieve = (Button) findViewById(R.id.jsonRecieve);
        Button jsonRecycler = (Button) findViewById(R.id.jsonRecycler);
        Button jeoLoaction = (Button) findViewById(R.id.jeoLoaction);
        Button stopWatch = (Button) findViewById(R.id.stopWatch);
        Button timeTable = (Button) findViewById(R.id.timeTable);
        Button shaePrerence = (Button) findViewById(R.id.shaePrerence);
        Button noteApp = (Button) findViewById(R.id.noteApp);
        Button backgroundProcess = (Button) findViewById(R.id.backgroundProcess);
        Button backgroundService = (Button) findViewById(R.id.backgroundService);
        Button androidxCamera = (Button) findViewById(R.id.androidxCamera);
        Button dataBinding = (Button) findViewById(R.id.dataBinding);
        Button jetpactLivedata = (Button) findViewById(R.id.jetpactLivedata);
        Button espressoUITesing = (Button) findViewById(R.id.espressoUITesing);
        Button useOfRetrofit = (Button) findViewById(R.id.useOfRetrofit);
        Button simpleRecyclerView = (Button) findViewById(R.id.simpleRecyclerView);
        Button gridRecyclerView = (Button) findViewById(R.id.gridRecyclerView);

        gridRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, GridRecyclerViewStudyActivity.class));
            }
        });
        simpleRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SimpleRecyclerViewStudyActivity.class));
            }
        });
        useOfRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, RetrofitStudyActivity.class));
            }
        });
        espressoUITesing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, EspressoTestingUiActivity.class));
            }
        });
        jetpactLivedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, JetpackLivedataActivity.class));
            }
        });
        dataBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DataBindingActivity.class));
            }
        });
        androidxCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CameraxActivity.class));
            }
        });
        backgroundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, BackgroundServicesActivity.class));
            }
        });
        backgroundProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, BackgroundProcessActivity.class));
            }
        });
        noteApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, NoteUsingSharedPrefrenceActivity.class));
            }
        });
        shaePrerence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SharedPrefrenceActivity.class));
            }
        });
        timeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, TimeTableActivity.class));
            }
        });
        stopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, StopwatchActivity.class));
            }
        });
        jeoLoaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, GeoLocationActivity.class));
            }
        });
        jsonRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, RecyclerJsonActivity.class));
            }
        });
        jsonRecieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, JsonImportActivity.class));
            }
        });
        emailSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, EmailSendOptionActivity.class));
            }
        });
        imageProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, imageProgressBarActivity.class));
            }
        });
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