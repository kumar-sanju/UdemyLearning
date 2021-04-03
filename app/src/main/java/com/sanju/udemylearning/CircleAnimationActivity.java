package com.sanju.udemylearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.ramotion.circlemenu.CircleMenuView;

import me.itangqi.waveloadingview.WaveLoadingView;

public class CircleAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_animation);

        final CircleMenuView circleMenu = findViewById(R.id.circleMenu);

        WaveLoadingView mWaveLoadingView = (WaveLoadingView) findViewById(R.id.waveLoadingView);
        mWaveLoadingView.setShapeType(WaveLoadingView.ShapeType.CIRCLE);
//        mWaveLoadingView.setTopTitle("Top Title");
        mWaveLoadingView.setCenterTitleColor(Color.GRAY);
        mWaveLoadingView.setBottomTitleSize(18);
        mWaveLoadingView.setProgressValue(80);
        mWaveLoadingView.setBorderWidth(10);
        mWaveLoadingView.setAmplitudeRatio(60);
        mWaveLoadingView.setWaveColor(Color.GRAY);
        mWaveLoadingView.setBorderColor(Color.GRAY);
        mWaveLoadingView.setTopTitleStrokeColor(Color.BLUE);
        mWaveLoadingView.setTopTitleStrokeWidth(3);
        mWaveLoadingView.setAnimDuration(3000);
        mWaveLoadingView.pauseAnimation();
        mWaveLoadingView.resumeAnimation();
        mWaveLoadingView.cancelAnimation();
        mWaveLoadingView.startAnimation();

        circleMenu.setEventListener(new CircleMenuView.EventListener(){
            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
                super.onMenuOpenAnimationStart(view);
            }

            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int buttonIndex) {
                super.onButtonClickAnimationStart(view, buttonIndex);
                switch (buttonIndex){
                    case 0:
                        Toast.makeText(CircleAnimationActivity.this,"Clicked1",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(CircleAnimationActivity.this,"Clicked2",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(CircleAnimationActivity.this,"Clicked3",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(CircleAnimationActivity.this,"Clicked4",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(CircleAnimationActivity.this,"Clicked5",Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });

    }
}