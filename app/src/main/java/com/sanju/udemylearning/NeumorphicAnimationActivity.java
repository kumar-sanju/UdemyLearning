package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.borutsky.neumorphism.NeumorphicFrameLayout;
import com.github.sshadkany.CircleButton;
import com.github.sshadkany.shapes.PolygonView;
import com.github.sshadkany.shapes.RoundRectView;

public class NeumorphicAnimationActivity extends AppCompatActivity {


    NeumorphicFrameLayout.State[] states = new NeumorphicFrameLayout.State[]{
            NeumorphicFrameLayout.State.CONCAVE,
            NeumorphicFrameLayout.State.CONVEX
    };

    int current = 0;

    NeumorphicFrameLayout playBtn,pauseBtn,previousBtn,nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neumorphic_animation);

        playBtn = findViewById(R.id.playBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        previousBtn = findViewById(R.id.previousBtn);
        nextBtn = findViewById(R.id.nextBtn);
        final PolygonView my_polygon = findViewById(R.id.my_polygon);
        my_polygon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (my_polygon.isShapeContainsPoint(event.getX(), event.getY())) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            // PRESSED
                            int side = my_polygon.getSide();
                            if (side > 12){
                                my_polygon.setSide(3);
                            }else {
                                my_polygon.setSide(side+1);
                            }
                            return true;
                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_CANCEL:
                            // RELEASED
                            return true;
                    }
                } else {
                    // RELEASED
                    return true;
                }
                return false;
            }
        });

        CircleButton circle_button = findViewById(R.id.circle_image_button);
        circle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("1111", "onClick: i am clicked");
            }
        });

//        RoundRectView rectView = findViewById(R.id.roundRectView);
//        findViewById(R.id.backgroundLayout).setBackgroundColor(rectView.background_color);  // set layout background color from neo object.

        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = current < 1 ? current + 1 : 0;
                ((NeumorphicFrameLayout) v).setState(states[current]);
            }
        });
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = current < 1 ? current + 1 : 0;
                ((NeumorphicFrameLayout) v).setState(states[current]);
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = current < 1 ? current + 1 : 0;
                ((NeumorphicFrameLayout) v).setState(states[current]);
            }
        });
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = current < 1 ? current + 1 : 0;
                ((NeumorphicFrameLayout) v).setState(states[current]);
            }
        });

    }
}