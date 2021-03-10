package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class ListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listView = (ListView) findViewById(R.id.listView);
        ListView listView2 = (ListView) findViewById(R.id.listView2);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Sanju");
        arrayList.add("Manju");
        arrayList.add("Hello");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Sanju", arrayList.get(position));
            }
        });

        ArrayList<String> arrayList2 = new ArrayList<>(asList("Sanju", "Hello", "Manju"));

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList2);

        listView2.setAdapter(arrayAdapter2);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Hello " + arrayList2.get(position), Toast.LENGTH_LONG).show();
            }
        });


    }
}