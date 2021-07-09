package com.sanju.udemylearning.RemoveBG;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.github.gabrielbb.cutout.CutOut;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sanju.udemylearning.R;

public class RemoveBgActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_bg);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = findViewById(R.id.imageView);

        final Uri imageIconUri = getUriFromDrawable(R.drawable.image_icon);
        imageView.setImageURI(imageIconUri);
        imageView.setTag(imageIconUri);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(view -> {
            final Uri testImageUri = getUriFromDrawable(R.drawable.sleep);

            CutOut.activity()
                    .src(testImageUri)
                    .bordered()
                    .noCrop()
                    .start(this);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CutOut.CUTOUT_ACTIVITY_REQUEST_CODE) {

            switch (resultCode) {
                case Activity.RESULT_OK:
                    Uri imageUri = CutOut.getUri(data);
                    // Save the image using the returned Uri here
                    imageView.setImageURI(imageUri);
                    imageView.setTag(imageUri);
                    break;
                case CutOut.CUTOUT_ACTIVITY_RESULT_ERROR_CODE:
                    Exception ex = CutOut.getError(data);
                    break;
                default:
                    System.out.print("User cancelled the CutOut screen");
            }
        }
    }

    public Uri getUriFromDrawable(int drawableId) {
        return Uri.parse("android.resource://" + getPackageName() + "/drawable/" + getApplicationContext().getResources().getResourceEntryName(drawableId));
    }
}
