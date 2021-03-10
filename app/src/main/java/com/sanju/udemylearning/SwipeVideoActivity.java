package com.sanju.udemylearning;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class SwipeVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        final ViewPager2 videosViewPager = findViewById(R.id.viewPagerVideos);
        List<SwipeVideoItem> swipeVideoItems = new ArrayList<>();

        SwipeVideoItem item = new SwipeVideoItem();
        item.videoURL = "https://www.radiantmediaplayer.com/media/big-buck-bunny-360p.mp4";
        item.videoTitle = "Women In Tech";
        item.videoDesc = "International Women's Day 2019";
        swipeVideoItems.add(item);

        SwipeVideoItem item2 = new SwipeVideoItem();
        item2.videoURL = "https://www.radiantmediaplayer.com/media/big-buck-bunny-360p.mp4";
        item2.videoTitle = "Sasha Solomon";
        item2.videoDesc = "How Sasha Solomon Became a Software Developer at Twitter";
        swipeVideoItems.add(item2);

        SwipeVideoItem item3 = new SwipeVideoItem();
        item3.videoURL = "https://www.radiantmediaplayer.com/media/big-buck-bunny-360p.mp4";
        item3.videoTitle = "Happy Hour Wednesday";
        item3.videoDesc = " Depth-First Search Algorithm";
        swipeVideoItems.add(item3);

        videosViewPager.setAdapter(new SwipeVideosAdapter(swipeVideoItems));
    }
}