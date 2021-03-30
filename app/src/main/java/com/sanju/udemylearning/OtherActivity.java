package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.shrikanthravi.library.NightModeButton;

public class OtherActivity extends AppCompatActivity {

    NightModeButton nightModeButton;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        relativeLayout = findViewById(R.id.rootLayout);
        nightModeButton = findViewById(R.id.nightModeButton);

        Button theButton = (Button)findViewById(R.id.thebutton);
        ShapeDrawable.ShaderFactory sf = new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                LinearGradient lg = new LinearGradient(height, width, width, height,
                        new int[] {
                                Color.parseColor("#000000"),
                                Color.parseColor("#777777"),
                                Color.parseColor("#FFFFFF")
                        },
                        new float[] {
                                0, 0.45f, 1 },
                        Shader.TileMode.REPEAT);
                return lg;
            }
        };
        PaintDrawable p = new PaintDrawable();
        p.setShape(new RectShape());
        p.setShaderFactory(sf);
        theButton.setBackground(p);

        final int colorFrom = getResources().getColor(R.color.white);
        final int colorTo = getResources().getColor(R.color.dark);

        nightModeButton.setOnSwitchListener(new NightModeButton.OnSwitchListener() {
            @Override
            public void onSwitchListener(boolean isNight) {
                if(isNight){
                    //Function to change color
                    animateBackground(colorFrom,colorTo);
                    animateStatusActionBar(getResources().getColor(R.color.colorPrimary),colorTo);
                    Toast.makeText(getApplicationContext(),"Night Mode On",Toast.LENGTH_SHORT).show();
                }else {
                    animateBackground(colorTo,colorFrom);
                    animateStatusActionBar(colorTo,getResources().getColor(R.color.colorPrimary));
                    Toast.makeText(getApplicationContext(),"Night Mode Off", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void animateBackground(int colorFrom,int colorTo){
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                relativeLayout.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();
    }

    public void animateStatusActionBar(int colorFrom,int colorTo){
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                getWindow().setStatusBarColor((int) animator.getAnimatedValue());
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable((int) animator.getAnimatedValue()));
            }

        });
        colorAnimation.start();
    }
}