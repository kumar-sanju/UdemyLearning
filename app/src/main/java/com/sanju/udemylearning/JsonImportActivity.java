package com.sanju.udemylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

public class JsonImportActivity extends AppCompatActivity {

    ListView listView,listView1;
    JSONObject object,jsonObject;
    JSONArray array,array1;
    ArrayList<HashMap<String,String>> arrayList,arrayList1;
    String formula,url;
    ListAdapter listAdapter,listAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_import);

        listView = findViewById(R.id.listView);
        listView1 = findViewById(R.id.listView1);

        try {
            object = new JSONObject(LoadJsonFromAsset());
            array = object.getJSONArray("formulas");
            array1 = object.getJSONArray("value");
            HashMap<String,String> list;
            HashMap<String,String> list1;
            arrayList = new ArrayList<>();
            arrayList1 = new ArrayList<>();
            for (int i = 0; i<array.length(); i++){
                jsonObject = array.getJSONObject(i);
                formula = jsonObject.getString("formula");
                url = jsonObject.getString("url");
                list = new HashMap<>();
                list.put("formula",formula);
                list.put("url",url);
                arrayList.add(list);
            }
            for (int i = 0; i<array1.length(); i++){
                jsonObject = array1.getJSONObject(i);
                formula = jsonObject.getString("formula");
                url = jsonObject.getString("url");
                list1 = new HashMap<>();
                list1.put("formula",formula);
                list1.put("url",url);
                arrayList1.add(list1);
            }
            listAdapter = new SimpleAdapter(this,arrayList,R.layout.list_design,
                    new String[]{"formula","url"},new int[]{R.id.formula,R.id.url});
            listAdapter1 = new SimpleAdapter(this,arrayList1,R.layout.list_design,
                    new String[]{"formula","url"},new int[]{R.id.formula,R.id.url});
            listView.setAdapter(listAdapter);
            listView1.setAdapter(listAdapter1);

        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String LoadJsonFromAsset(){
        String json = null;
        try {
            InputStream inputStream = this.getAssets().open("json_test.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer,"UTF-8");
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }

}