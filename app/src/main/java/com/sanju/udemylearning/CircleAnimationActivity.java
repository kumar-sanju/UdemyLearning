package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class CircleAnimationActivity extends AppCompatActivity {

    private View viewLayout;
    private ImageView animation2, animation1;
    private Handler handlerAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_animation);

//        final CircleMenuView circleMenu = findViewById(R.id.circleMenu);

        init();

//        Glide.with(getBaseContext()).load(R.drawable.sleep)
//                .apply(new RequestOptions().centerCrop()).into(imgMiniFotus);

        findViewById(R.id.startBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTask();
            }
        });
        findViewById(R.id.stopBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTask();
            }
        });

//        WaveLoadingView mWaveLoadingView = (WaveLoadingView) findViewById(R.id.waveLoadingView);
//        mWaveLoadingView.setShapeType(WaveLoadingView.ShapeType.CIRCLE);
////        mWaveLoadingView.setTopTitle("Top Title");
//        mWaveLoadingView.setCenterTitleColor(Color.GRAY);
//        mWaveLoadingView.setBottomTitleSize(18);
//        mWaveLoadingView.setProgressValue(80);
//        mWaveLoadingView.setBorderWidth(10);
//        mWaveLoadingView.setAmplitudeRatio(60);
//        mWaveLoadingView.setWaveColor(Color.GRAY);
//        mWaveLoadingView.setBorderColor(Color.GRAY);
//        mWaveLoadingView.setTopTitleStrokeColor(Color.BLUE);
//        mWaveLoadingView.setTopTitleStrokeWidth(3);
//        mWaveLoadingView.setAnimDuration(3000);
//        mWaveLoadingView.pauseAnimation();
//        mWaveLoadingView.resumeAnimation();
//        mWaveLoadingView.cancelAnimation();
//        mWaveLoadingView.startAnimation();
//
//        circleMenu.setEventListener(new CircleMenuView.EventListener(){
//            @Override
//            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
//                super.onMenuOpenAnimationStart(view);
//            }
//
//            @Override
//            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int buttonIndex) {
//                super.onButtonClickAnimationStart(view, buttonIndex);
//                switch (buttonIndex){
//                    case 0:
//                        Toast.makeText(CircleAnimationActivity.this,"Clicked1",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 1:
//                        Toast.makeText(CircleAnimationActivity.this,"Clicked2",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 2:
//                        Toast.makeText(CircleAnimationActivity.this,"Clicked3",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 3:
//                        Toast.makeText(CircleAnimationActivity.this,"Clicked4",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 4:
//                        Toast.makeText(CircleAnimationActivity.this,"Clicked5",Toast.LENGTH_SHORT).show();
//                        break;
//
//                }
//            }
//        });

    }

    private void init() {
        this.handlerAnimation = new Handler();
        this.viewLayout = findViewById(R.id.viewLayout);
        this.animation2 = findViewById(R.id.animation2);
        this.animation1 = findViewById(R.id.animation1);
    }

    private void startTask(){
        this.runnable.run();
        this.viewLayout.setVisibility(View.VISIBLE);
    }
    private void stopTask(){
        this.handlerAnimation.removeCallbacks(runnable);
        this.viewLayout.setVisibility(View.GONE);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            animation2.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(1000).withEndAction(new Runnable() {
                @Override
                public void run() {
                    animation2.setScaleX(1f);
                    animation2.setScaleY(1f);
                    animation2.setAlpha(1f);
                }
            });
            animation1.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(700).withEndAction(new Runnable() {
                @Override
                public void run() {
                    animation1.setScaleX(1f);
                    animation1.setScaleY(1f);
                    animation1.setAlpha(1f);
                }
            });
            handlerAnimation.postDelayed(runnable,1500);
        }
    };

}