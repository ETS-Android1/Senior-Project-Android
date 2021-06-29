package com.example.seniorproject.Views.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.seniorproject.R;
import com.google.android.gms.common.GoogleApiAvailability;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.concurrent.Executor;


public class HomePageFragment extends Fragment implements OnMapReadyCallback {


    private DrawerLayout drawerLayout;
    private MaterialToolbar materialToolbar;

    public static String HOMEPAGE_FRAGMENT_ACTIVITY = "Home Page Activity";
    private GoogleMap googleMap;
    MapView mapView;
    private PlacesClient placesClient;
    private boolean locationPermissionsGranted;
    private Location lastKnownLocation;
    private SupportMapFragment supportMapFragment;
    private LocationRequest locationRequest;
    private Marker myMarker;
    private FusedLocationProviderClient mFusedLocationClient;
    private int PERMISSION_ID = 44;
    private static final int DEFAULT_ZOOM = 15;
    private final LatLng defaultLocation = new LatLng(-33.8523341, 151.2106085);
    // Static Variables
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    SupportMapFragment mapFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Places.initialize(getContext(), getString(R.string.maps_api_key));
        placesClient = Places.createClient(getContext());

        // Construct a FusedLocationProviderClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Inflate the Sign Up Fragment **/
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        materialToolbar = (MaterialToolbar) view.findViewById(R.id.topAppBar);

        materialToolbar.setNavigationOnClickListener(e -> {
            drawerLayout.openDrawer(Gravity.LEFT);
        });

        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;


                getLocationPermission();
                getDeviceLocation();
                // For dropping a marker at a point on the Map
//                LatLng sydney = new LatLng(-34, 151);
//                LatLng sydney = new LatLng(lastKnownLocation.getLatitude(),lastKnownLocation.getLongitude());
//                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));
//
//                // For zooming automatically to the location of the marker
//                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
//                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });


        return view;
    }

    private void getLocationPermission() {
        /**
         * Request location permission, so that we can get the location of the device.
         * The result of the permission request is handled by the callback,
         * onRequestPermissionResult
         * **/

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationPermissionsGranted = true;
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        locationPermissionsGranted = false;

        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    locationPermissionsGranted = true;
                }
            }
        }
        updateLocationUI();
    }

    @SuppressLint("MissingPermission")
    private void updateLocationUI() {
        if (googleMap == null) {
            return;
        }
        try {
            if (locationPermissionsGranted) {
                googleMap.setMyLocationEnabled(true);
            } else {
                googleMap.setMyLocationEnabled(false);
                googleMap.getUiSettings().setMyLocationButtonEnabled(false);
                lastKnownLocation = null;
                getLocationPermission();
            }
        } catch (SecurityException e) {
            Log.e("Exception: %s", e.getMessage());
        }
    }

    private void getDeviceLocation() {
        /*
         * Get the best and most recent location of the device, which may be null in rare
         * cases when a location is not available.
         */
        try {
            if (locationPermissionsGranted) {
                Task<Location> locationResult = mFusedLocationClient.getLastLocation();
                locationResult.addOnCompleteListener(getActivity(), new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful()) {
                            // Set the map's camera position to the current location of the device.
                            lastKnownLocation = task.getResult();
                            if (lastKnownLocation != null) {
                                // For dropping a marker at a point on the Map
//                LatLng sydney = new LatLng(-34, 151);
//                LatLng sydney = new LatLng(lastKnownLocation.getLatitude(),lastKnownLocation.getLongitude());
//                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));
//
//                // For zooming automatically to the location of the marker
//                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
//                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                                LatLng currentLocation = new LatLng(lastKnownLocation.getLatitude(),lastKnownLocation.getLongitude());
                                googleMap.addMarker(new MarkerOptions().position(currentLocation).title("Marker Title").snippet("Marker Description"));
                                CameraPosition cameraPosition = new CameraPosition.Builder().target(currentLocation).zoom(12).build();
                                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//                                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
//                                        new LatLng(lastKnownLocation.getLatitude(),
//                                                lastKnownLocation.getLongitude()), DEFAULT_ZOOM));
                            }
                        } else {
                            Log.d(HOMEPAGE_FRAGMENT_ACTIVITY, "Current location is null. Using defaults.");
                            Log.e(HOMEPAGE_FRAGMENT_ACTIVITY, "Exception: %s", task.getException());
                            googleMap.moveCamera(CameraUpdateFactory
                                    .newLatLngZoom(defaultLocation, DEFAULT_ZOOM));
                            googleMap.getUiSettings().setMyLocationButtonEnabled(false);
                        }
                    }
                });
            }
        } catch (SecurityException e) {
            Log.e("Exception: %s", e.getMessage(), e);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        getLocationPermission();
        // [END_EXCLUDE]

        // Turn on the My Location layer and the related control on the map.
        updateLocationUI();

        // Get the current location of the device and set the position of the map.
        getDeviceLocation();
    }
}
