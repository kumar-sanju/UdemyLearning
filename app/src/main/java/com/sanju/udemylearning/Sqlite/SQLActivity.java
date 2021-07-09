package com.sanju.udemylearning.Sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sanju.udemylearning.R;

public class SQLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_l);

        ListView listView = findViewById(R.id.list_view);

        String[] menu = getResources().getStringArray(R.array.menu);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menu);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        startActivity(new Intent(SQLActivity.this,LevelActivity.class));
                        break;
                    }
                    case 1: {
                        startActivity(new Intent(SQLActivity.this,GradeActivity.class));
                        break;
                    }
                }
            }
        });

    }
}