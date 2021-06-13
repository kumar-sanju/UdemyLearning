package com.sanju.udemylearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    private static final int REQUEST_LOCATION = 1;
    Button btnGetLocation;
    TextView showLocation;
    LocationManager locationManager;
    String geoLatitude, geoLongitude;

    double latitude, longitude;
    private TextView tvLocation, distanceKM, distanceInM;
    private Button btnGetLocation2;
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

        ActivityCompat.requestPermissions( this,
                new String[] {ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        showLocation = findViewById(R.id.showLocation);
        btnGetLocation = findViewById(R.id.btnGetLocation);
        distanceInM = findViewById(R.id.distanceInM);
        distanceKM = findViewById(R.id.distanceKM);

        requestPermission();

        locationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        tvLocation = findViewById(R.id.showLocation2);
        geocoder = new Geocoder(GeoLocationActivity.this, Locale.getDefault());

        btnGetLocation2 = findViewById(R.id.btnGetLocation2);
        btnGetLocation2.setOnClickListener(new View.OnClickListener() {
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
//                            tvLocation.setText(location.toString());
                            latitude = location.getLatitude();
                            Log.e("sanju", String.valueOf(latitude));
                            longitude = location.getLongitude();
                            Log.e("sanju", String.valueOf(longitude));
                            // subhanju 61km
//                            latitude2 = (float) 20.23161327;
//                            longitude2 = (float) 85.84128057;
                            // balabhadra bhai 318km
                            latitude2 = 22.23802996;
                            longitude2 = 84.76950389;

                            double earthRadius = 6371000; //meters
                            double dLat = Math.toRadians(latitude2-latitude);
                            double dLng = Math.toRadians(longitude2-longitude);
                            double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                                    Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(latitude2)) *
                                            Math.sin(dLng/2) * Math.sin(dLng/2);
                            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
                            float dist = (float) (earthRadius * c);

                            Log.d("sanju", String.valueOf(dist));

//                            double Rad = 6372.8; //Earth's Radius In kilometers
//                            // TODO Auto-generated method stub
//                            double dLat = Math.toRadians(latitude2 - latitude);
//                            double dLon = Math.toRadians(longitude2 - longitude);
//                            latitude = Math.toRadians(latitude);
//                            latitude2 = Math.toRadians(latitude2);
//                            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(latitude) * Math.cos(latitude2);
//                            double c = 2 * Math.asin(Math.sqrt(a));
//                            double haverdistanceKM = Rad * c;
//
//                            Log.e("sanju", String.valueOf(haverdistanceKM));
//
                            Location startPoint = new Location("locationA");
                            startPoint.setLatitude(latitude);
                            startPoint.setLongitude(longitude);
                            Location endPoint = new Location("locationB");
                            endPoint.setLatitude(latitude2);
                            endPoint.setLongitude(longitude2);

                            double distance = startPoint.distanceTo(endPoint);
                            distanceInM.setText(String.valueOf(distance));
                            Log.e("sanju", String.valueOf(distance));
                            double distance2 = (startPoint.distanceTo(endPoint))/1000;
                            distanceKM.setText(String.valueOf(distance2));
                            Log.e("sanju", String.valueOf(distance2));

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

                                String fullAddress = addressLine1 + ",  " + city + ",  " + state + ",  " + pinCode;
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

        btnGetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    OnGPS();
                } else {
                    getLocation();
                }
            }
        });
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
    }

    private void OnGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                GeoLocationActivity.this, ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                GeoLocationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this, new String[]{ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (locationGPS != null) {
                double lat = locationGPS.getLatitude();
                double longi = locationGPS.getLongitude();
                geoLatitude = String.valueOf(lat);
                geoLongitude = String.valueOf(longi);
                showLocation.setText("Your Location: " + "\n" + "Latitude: " + geoLatitude + "\n" + "Longitude: " + geoLongitude);
            } else {
                Toast.makeText(this, "Unable to find location.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}