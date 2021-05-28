package com.sanju.udemylearning.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sanju.udemylearning.R;

public class RecyclerViewStudyActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] programeNameList = {"C", "C++", "Java"};
    String[] programeDescriptionList = {"C Description", "C++ Description", "Java Description"};
    int[] programeImages = {R.drawable.a2, R.drawable.a5, R.drawable.a8};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_study);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }
}