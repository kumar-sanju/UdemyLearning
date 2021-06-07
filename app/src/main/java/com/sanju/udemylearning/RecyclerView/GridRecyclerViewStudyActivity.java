package com.sanju.udemylearning.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sanju.udemylearning.R;

public class GridRecyclerViewStudyActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String[] programeNameList = {"C", "C++", "Java"};
    String[] programeDescriptionList = {"C Description", "C++ Description", "Java Description"};
    int[] programeImages = {R.drawable.a2, R.drawable.a5, R.drawable.a8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view_study);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SimpleRecyclerAdapter(this, programeNameList, programeDescriptionList, programeImages);
        recyclerView.setAdapter(adapter);

    }
}