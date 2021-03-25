package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.transition.ArcMotion;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeImageTransform;
import androidx.transition.Fade;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.transitionseverywhere.ChangeText;
import com.transitionseverywhere.Recolor;
import com.transitionseverywhere.Rotate;
import com.transitionseverywhere.extra.Scale;

public class AnimateTransitionsActivity extends AppCompatActivity {

    public static final String TEXT_1 = "Hi, i am text. Tap on me!";
    public static final String TEXT_2 = "Thanks! Another tap?";
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_transitions);

        final ViewGroup transitionsContainer = (ViewGroup) findViewById(R.id.transitions_container);
        final TextView text = (TextView) transitionsContainer.findViewById(R.id.text);
        final TextView text1 = (TextView) transitionsContainer.findViewById(R.id.text1);
        final TextView text2 = (TextView) transitionsContainer.findViewById(R.id.text2);
        final TextView text6 = (TextView) transitionsContainer.findViewById(R.id.text6);
        final Button button = (Button) transitionsContainer.findViewById(R.id.button);
        final Button button1 = (Button) transitionsContainer.findViewById(R.id.button1);
        final Button button2 = (Button) transitionsContainer.findViewById(R.id.button2);
        final Button button3 = (Button) transitionsContainer.findViewById(R.id.button3);
        final Button button4 = (Button) transitionsContainer.findViewById(R.id.button4);
        final Button button5 = (Button) transitionsContainer.findViewById(R.id.button5);
        final Button button6 = (Button) transitionsContainer.findViewById(R.id.button6);
        final ImageView icon = (ImageView) transitionsContainer.findViewById(R.id.icon);
        final ImageView image = (ImageView) transitionsContainer.findViewById(R.id.image);
        mProgressBar = findViewById(R.id.progress_bar);

        button.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionsContainer);
                visible = !visible;
                text.setVisibility(visible ? View.VISIBLE : View.GONE);
            }

        });
        button1.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionsContainer, new Slide(Gravity.RIGHT));
                visible = !visible;
                text1.setVisibility(visible ? View.VISIBLE : View.GONE);
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                final ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.setPathMotion(new ArcMotion());
                changeBounds.setDuration(500);
                TransitionManager.beginDelayedTransition(transitionsContainer, changeBounds);

                visible = !visible;
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) button2.getLayoutParams();
                params.gravity = visible ? (Gravity.RIGHT | Gravity.BOTTOM) :
                        (Gravity.LEFT | Gravity.TOP);
                button2.setLayoutParams(params);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionsContainer);

                visible = !visible;
                button3.setTextColor(getResources().getColor(!visible ? R.color.second_accent : R.color.accent));
                button3.setBackgroundDrawable(
                        new ColorDrawable(getResources().getColor(!visible ? R.color.accent : R.color.second_accent)));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgress(mProgressBar.getProgress() - 20);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgress(mProgressBar.getProgress() + 30);
            }
        });

        text2.setText(TEXT_1);
        text2.setOnClickListener(new View.OnClickListener() {

            boolean mSecondText;

            @Override
            public void onClick(View v) {
                mSecondText = !mSecondText;
                TransitionManager.beginDelayedTransition(transitionsContainer);
                text2.setText(mSecondText ? TEXT_2 : TEXT_1);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionsContainer);
                visible = !visible;
                text6.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
            }
        });
        icon.setOnClickListener(new View.OnClickListener() {

            boolean mRotated;

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionsContainer);
                mRotated = !mRotated;
                icon.setRotation(mRotated ? 135 : 0);
            }
        });
        image.setOnClickListener(new View.OnClickListener() {

            boolean mExpanded;

            @Override
            public void onClick(View v) {
                mExpanded = !mExpanded;

                TransitionManager.beginDelayedTransition(transitionsContainer, new TransitionSet()
                        .addTransition(new ChangeBounds())
                        .addTransition(new ChangeImageTransform()));

                ViewGroup.LayoutParams params = image.getLayoutParams();
                params.height = mExpanded ? ViewGroup.LayoutParams.MATCH_PARENT : ViewGroup.LayoutParams.WRAP_CONTENT;
                image.setLayoutParams(params);

                image.setScaleType(mExpanded ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_CENTER);
            }
        });


    }

}