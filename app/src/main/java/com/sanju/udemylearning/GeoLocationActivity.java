package com.sanju.udemylearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.maps.android.SphericalUtil;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class GeoLocationActivity extends AppCompatActivity implements OnMapReadyCallback {

    double latitude, longitude;
    private TextView tvLocation, distanceKM, distanceInM;
    private Button btnGetLocation;
    private FusedLocationProviderClient locationProviderClient;
    private Geocoder geocoder;
    private List<Address> addresses;
    double latitude1, latitude2, longitude1, longitude2;

    LatLng sanju = new LatLng(20.1714746, 85.33371775);
    LatLng subhanju = new LatLng(20.23161327, 85.84128057);  // 53.39km
    LatLng balabhadra = new LatLng(22.23802996, 84.76950389);  // 237.12km
    LatLng sibhendu = new LatLng(20.35896681, 85.82279312);  // 55.11km
    Double distance, subhanjuDis,  balabhadraDis, sibhenduDis;
    private GoogleMap mMap;
    GoogleMap googleMap;

    @Override
    protected void onStart() {
        super.onStart();
        onMapReady(googleMap);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        // on below line we are calculating the distance between sydney and brisbane
        subhanjuDis = SphericalUtil.computeDistanceBetween(sanju, subhanju);
        balabhadraDis = SphericalUtil.computeDistanceBetween(sanju, balabhadra);
        sibhenduDis = SphericalUtil.computeDistanceBetween(sanju, sibhendu);
        Log.d("subhanju", String.format("%.2f", subhanjuDis / 1000) + "km");
        Log.d("balabhadra", String.format("%.2f", balabhadraDis / 1000) + "km");
        Log.d("sibhendu", String.format("%.2f", sibhenduDis / 1000) + "km");

        // in below line we are displaying a toast
        // message with distance between two locations.
        // in our distance we are dividing it by 1000 to
        // make in km and formatting it to only 2 decimal places.
//        Toast.makeText(this, "Distance between sanju and subhanju is \n " + String.format("%.2f", distance / 1000) + "km", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_location);

        requestPermission();

        distanceKM = findViewById(R.id.distanceKM);
        distanceInM = findViewById(R.id.distanceInM);
        btnGetLocation = findViewById(R.id.btnGetLocation);
        tvLocation = findViewById(R.id.showLocation);
        locationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        geocoder = new Geocoder(GeoLocationActivity.this, Locale.getDefault());

        btnGetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(GeoLocationActivity.this,
                        ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                locationProviderClient.getLastLocation().addOnSuccessListener(GeoLocationActivity.this,
                        new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {

                                if (location != null) {
                                    latitude = location.getLatitude();
                                    Log.e("sanju", String.valueOf(latitude));
                                    longitude = location.getLongitude();
                                    Log.e("sanju", String.valueOf(longitude));
                                    // subhanju 61km
//                                    latitude2 = (float) 20.23161327;
//                                    longitude2 = (float) 85.84128057;
                                    // balabhadra bhai 318km
                                    latitude2 = 20.1714746;
                                    longitude2 = 85.33371775;

                                    double earthRadius = 6371000; //meters
                                    double dLat = Math.toRadians(latitude2-latitude);
                                    double dLng = Math.toRadians(longitude2-longitude);
                                    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                                            Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(latitude2)) *
                                                    Math.sin(dLng/2) * Math.sin(dLng/2);
                                    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
                                    float dist = (float) (earthRadius * c);

                                    Log.d("sanju", String.valueOf(dist));
                                    distanceInM.setText(String.valueOf(dist));

//                                    Location startPoint = new Location("locationA");
//                                    startPoint.setLatitude(latitude);
//                                    startPoint.setLongitude(longitude);
//                                    Location endPoint = new Location("locationB");
//                                    endPoint.setLatitude(latitude2);
//                                    endPoint.setLongitude(longitude2);
//
//                                    double distance = startPoint.distanceTo(endPoint);
//                                    distanceInM.setText(String.valueOf(distance));
//                                    Log.e("sanju", String.valueOf(distance));
//                                    double distance2 = (startPoint.distanceTo(endPoint))/1000;
//                                    distanceKM.setText(String.valueOf(distance2));
//                                    Log.e("sanju", String.valueOf(distance2));

                                    try {
                                        addresses = geocoder.getFromLocation(latitude, longitude, 1);

                                        String addressLine1 = addresses.get(0).getAddressLine(0);
                                        Log.e("line1", addressLine1);

                                        String city = addresses.get(0).getLocality();
                                        Log.e("city", city);

                                        String state = addresses.get(0).getAdminArea();
                                        Log.e("state", state);

                                        String pinCode = addresses.get(0).getPostalCode();
                                        Log.e("pinCode", pinCode);

                                        String fullAddress = latitude + ", " + longitude + ", " + addressLine1 + ",  " + city + ",  " + state + ",  " + pinCode;
                                        tvLocation.setText(fullAddress);

                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        Log.e("MainActivity", e.getMessage());
                                    }
                                }
                            }
                        });
            }
        });
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
    }

}