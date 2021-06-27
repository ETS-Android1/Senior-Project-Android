package com.example.seniorproject.Views.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.seniorproject.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class SingleFragmentActivity extends FragmentActivity implements OnMapReadyCallback {


    private MaterialToolbar materialToolbar;
    private DrawerLayout drawerLayout;
    public static String SINGLE_FRAGMENT_ACTIVITY = "Single Fragment Activity";
    private GoogleMap googleMap;
    private PlacesClient placesClient;
    private boolean locationPermissionsGranted;
    private boolean lastKnowLocation;
    private SupportMapFragment supportMapFragment;
    private LocationRequest locationRequest;
    private Location lastKnownLocation;
    private Marker myMarker;
    private FusedLocationProviderClient mFusedLocationClient;
    private int PERMISSION_ID = 44;
    private static final int DEFAULT_ZOOM = 15;
    private final LatLng defaultLocation = new LatLng(-33.8523341, 151.2106085);



    // Static Variables
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlefragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment startingFragment = fragmentManager.findFragmentById(R.id.fragment_container);

        //Construct a PlacesClient
        Places.initialize(getApplicationContext(), getString(R.string.maps_api_key));
        placesClient = Places.createClient(this);

        // Construct a FusedLocationProviderClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        /** Check if Fragment is empty **/
        if (startingFragment == null) {
            startingFragment = createFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, startingFragment).commit();
        }

    }

//    private void getLocationPermission() {
//        /**
//         * Request location permission, so that we can get the location of the device.
//         * The result of the permission request is handled by the callback,
//         * onRequestPermissionResult
//         * **/
//
//        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            locationPermissionsGranted = true;
//        } else {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        locationPermissionsGranted = false;
//
//        switch (requestCode) {
//            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
//                // If request is cancelled, the result arrays are empty
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    locationPermissionsGranted = true;
//                }
//            }
//        }
//        updateLocationUI();
//    }
//
//    @SuppressLint("MissingPermission")
//    private void updateLocationUI() {
//        if (googleMap == null) {
//            return;
//        }
//        try {
//            if (locationPermissionsGranted) {
//                googleMap.setMyLocationEnabled(true);
//            } else {
//                googleMap.setMyLocationEnabled(false);
//                googleMap.getUiSettings().setMyLocationButtonEnabled(false);
//                lastKnownLocation = null;
//                getLocationPermission();
//            }
//        } catch (SecurityException e){
//            Log.e("Exception: %s", e.getMessage());
//        }
//    }
//
//    private void getDeviceLocation() {
//        /*
//         * Get the best and most recent location of the device, which may be null in rare
//         * cases when a location is not available.
//         */
//        try {
//            if (locationPermissionsGranted) {
//                Task<Location> locationResult = mFusedLocationClient.getLastLocation();
//                locationResult.addOnCompleteListener(this, new OnCompleteListener<Location>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Location> task) {
//                        if (task.isSuccessful()) {
//                            // Set the map's camera position to the current location of the device.
//                            lastKnownLocation = task.getResult();
//                            if (lastKnownLocation != null) {
//                                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
//                                        new LatLng(lastKnownLocation.getLatitude(),
//                                                lastKnownLocation.getLongitude()), DEFAULT_ZOOM));
//                            }
//                        } else {
//                            Log.d(SINGLE_FRAGMENT_ACTIVITY, "Current location is null. Using defaults.");
//                            Log.e(SINGLE_FRAGMENT_ACTIVITY, "Exception: %s", task.getException());
//                            googleMap.moveCamera(CameraUpdateFactory
//                                    .newLatLngZoom(defaultLocation, DEFAULT_ZOOM));
//                            googleMap.getUiSettings().setMyLocationButtonEnabled(false);
//                        }
//                    }
//                });
//            }
//        } catch (SecurityException e)  {
//            Log.e("Exception: %s", e.getMessage(), e);
//        }
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        this.googleMap = googleMap;
//
//        getLocationPermission();
//        // [END_EXCLUDE]
//
//        // Turn on the My Location layer and the related control on the map.
//        updateLocationUI();
//
//        // Get the current location of the device and set the position of the map.
//        getDeviceLocation();
//    }

    protected abstract Fragment createFragment();

}
