package com.sanju.udemylearning;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RoadmapActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    Button btn_distance;
    TextView text_distance;

//    EditText etSource, etDestination;
//    TextView textView;
//    String sType;
//    double lat1 = 0, long1 = 0, lat2 = 0, long2 = 0;
//    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadmap);

        btn_distance = findViewById(R.id.btn_distance);
        text_distance = findViewById(R.id.text_distance);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://maps.gppgleapis.com/")
                .build();
        apiInterface = retrofit.create(ApiInterface.class);

        btn_distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDistance("30.7333" + ","+ "", ""+","+"");
            }
        });

//        etSource = findViewById(R.id.et_source);
//        etDestination = findViewById(R.id.et_destination);
//        textView = findViewById(R.id.text_view);

//        Places.initialize(getApplicationContext(),"d0b58f8d1a35ad30c25b78ddbe67d86a");
////        Places.initialize(getApplicationContext(),"AIzaSyCYd9DNtP8fAnic_H5XwgCef7dmqj_7vB0");
//
//        etSource.setFocusable(false);
//        etSource.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sType = "source";
//
//                List<Place.Field> fields = Arrays.asList(Place.Field.ADDRESS
//                ,Place.Field.LAT_LNG);
//
//                Intent intent = new Autocomplete.IntentBuilder(
//                        AutocompleteActivityMode.OVERLAY,fields
//                ).build(RoadmapActivity.this);
//                startActivityForResult(intent,100);
//            }
//        });
//
//        etDestination.setFocusable(false);
//        etDestination.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sType = "destination";
//
//                List<Place.Field> fields = Arrays.asList(Place.Field.ADDRESS
//                        ,Place.Field.LAT_LNG);
//
//                Intent intent = new Autocomplete.IntentBuilder(
//                        AutocompleteActivityMode.OVERLAY,fields
//                ).build(RoadmapActivity.this);
//                startActivityForResult(intent,100);
//            }
//        });
//        textView.setText("0.0 Kilometers");
    }

    private void getDistance(String origin, String dest){
        apiInterface.getDistance(getString(R.string.google_maps_key),origin,dest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Result>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Result result) {
                        Toast.makeText(RoadmapActivity.this, "Result success.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 100 && resultCode == RESULT_OK){
//            Place place = Autocomplete.getPlaceFromIntent(data);
//            if (sType.equals("source")){
//                flag++;
//                etSource.setText(place.getAddress());
//                String sSource = String.valueOf(place.getLatLng());
//                sSource = sSource.replaceAll("lat/lng","");
//                sSource = sSource.replace("(","");
//                sSource = sSource.replace(")","");
//                String[] split = sSource.split(",");
//                lat1 = Double.parseDouble(split[0]);
//                long1 = Double.parseDouble(split[1]);
//            } else {
//                flag++;
//                etDestination.setText(place.getAddress());
//                String sDestination = String.valueOf(place.getLatLng());
//                sDestination = sDestination.replaceAll("lat/lng","");
//                sDestination = sDestination.replace("(","");
//                sDestination = sDestination.replace(")","");
//                String[] split = sDestination.split(",");
//                lat2 = Double.parseDouble(split[0]);
//                long2 = Double.parseDouble(split[1]);
//            }
//
//            if (flag >= 2){
//                distance(lat1,long1,lat2,long2);
//            }
//        } else if (requestCode == AutocompleteActivity.RESULT_ERROR){
//            Status status = Autocomplete.getStatusFromIntent(data);
//            Toast.makeText(getApplicationContext(),status.getStatusMessage()
//            ,Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void distance(double lat1, double long1, double lat2, double long2) {
//        double longDiff = long1 - long2;
//
//        double distance = Math.sin(deg2rad(lat1))
//                * Math.sin(deg2rad(lat2))
//                + Math.cos(deg2rad(lat1))
//                * Math.cos(deg2rad(lat2))
//                * Math.cos(deg2rad(longDiff));
//        distance = Math.acos(distance);
//        distance = rad2deg(distance);
//        distance = distance * 60 * 1.1515;
//        distance = distance * 1.609344;
//        textView.setText(String.format(Locale.US, "%2f Kilometers",distance));
//    }
//
//    private double rad2deg(double distance) {
//        return (distance*180.0 / Math.PI);
//    }
//
//    private double deg2rad(double lat1) {
//        return (lat1*Math.PI/180.0);
//    }
}