package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SharedAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_animation);

        final ArrayList<String[]> values = new ArrayList<String[]>();
        values.add(new String[]{"Android", "Java", getString(R.string.android),'#' + Integer.toHexString(getResources().getColor(R.color.md_light_green_900))});
        values.add(new String[]{"iOS", "Swift", getString(R.string.ios),'#' + Integer.toHexString(getResources().getColor(R.color.md_amber_A700))});
        values.add(new String[]{"Xamarin", "C#",getString(R.string.xamarin),'#' + Integer.toHexString(getResources().getColor(R.color.md_pink_A700))});
        values.add(new String[]{"PhoneGap", "HTML CSS and JScript",getString(R.string.phonegap),'#' + Integer.toHexString(getResources().getColor(R.color.md_brown_800))});

        ListView listView = (ListView) findViewById(R.id.list_view);
        CustomAdapter adapter = new CustomAdapter(this, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SharedAnimationActivity.this, DetailsActivity.class);
                intent.putExtra("array",values.get(position));
                // Get the transition name from the string
                String transitionName = getString(R.string.transition);

                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(SharedAnimationActivity.this,
                                view,   // Starting view
                                transitionName    // The String
                        );
                ActivityCompat.startActivity(SharedAnimationActivity.this, intent, options.toBundle());
            }
        });
    }
}