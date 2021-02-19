package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FadingAnimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fadinganim);

        ImageView image8 = (ImageView) findViewById(R.id.image8);

        image8.setTranslationX(-1000f);
        image8.setTranslationY(-1000f);

    }

    public void fade(View view) {

        ImageView yellowImage = (ImageView) findViewById(R.id.yellowImage);
        ImageView blueImage = (ImageView) findViewById(R.id.blueImage);

        yellowImage.animate().alpha(0).setDuration(2000);
        blueImage.animate().alpha(1f).setDuration(2000);

    }

    public void fade2(View view) {

        ImageView yellowImage1 = (ImageView) findViewById(R.id.image1);
        ImageView image2 = (ImageView) findViewById(R.id.image2);
        ImageView image3 = (ImageView) findViewById(R.id.image3);

        yellowImage1.animate().translationXBy(-1000f).setDuration(2000);
        image2.animate().translationXBy(1000f).setDuration(2000);
        image2.animate().alpha(1f).setDuration(2000);
        image3.animate().alpha(1f).setDuration(2000);
    }

    public void fade3(View view) {
        ImageView image5 = (ImageView) findViewById(R.id.image5);

        image5.animate().rotation(180f).setDuration(2000);
    }

    public void fade4(View view) {
        ImageView image6 = (ImageView) findViewById(R.id.image6);

        image6.animate().rotation(1800f).setDuration(2000);
    }

    public void fade5(View view) {
        ImageView image7 = (ImageView) findViewById(R.id.image7);

        image7.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
    }

    public void fade6(View view) {
        ImageView image8 = (ImageView) findViewById(R.id.image8);

        image8.animate().translationXBy(1000f).translationYBy(1000f).rotationBy(3600).setDuration(2000);
    }
}