package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.InputStream;
import java.net.URL;

public class imageProgressBarActivity extends AppCompatActivity {

    Button ImageLoadButton;
    ImageView SetImageViewHolder;
    Bitmap bitmap;
    String ImageUrl = "https://www.android-examples.com/wp-content/uploads/2016/01/image_view_check.png";
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_progress_bar);

        ImageLoadButton = (Button)findViewById(R.id.button1);
        SetImageViewHolder = (ImageView)findViewById(R.id.imageView1);
        progressBar = (ProgressBar)findViewById(R.id.progressBar1);

        progressBar.setVisibility(View.GONE);

        ImageLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                new ImageLoaderClass().execute(ImageUrl);
            }
        });
    }
    private class ImageLoaderClass extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap image) {
            if(image != null){
                SetImageViewHolder.setImageBitmap(image);
                progressBar.setVisibility(View.GONE);
            }
        }
    }

}