package com.sanju.udemylearning.Retrofit;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sanju.udemylearning.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitStudyActivity extends AppCompatActivity {

    TextView tv;
    String url = "http://jsonplaceholder.typicode.com/";

    // website http://jsonplaceholder.typicode.com/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_study);

        tv = findViewById(R.id.tv);

        tv.setText("");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myAPI api = retrofit.create(myAPI.class);

        Call<List<RetrofitModel>> call = api.getModels();

        call.enqueue(new Callback<List<RetrofitModel>>() {
            @Override
            public void onResponse(Call<List<RetrofitModel>> call, Response<List<RetrofitModel>> response) {
                List<RetrofitModel> data = response.body();
                for (int i = 0; i<data.size(); i++){
                    tv.append("SL No: "+data.get(i).getId()+"\n Title: "+data.get(i).getTitle()+"\n\n\n");
                }
            }

            @Override
            public void onFailure(Call<List<RetrofitModel>> call, Throwable t) {

            }
        });

    }
}