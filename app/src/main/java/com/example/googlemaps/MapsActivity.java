package com.example.googlemaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        List<LatitudeLongitude>latLngs = new ArrayList<>();
        latLngs.add(new LatitudeLongitude(27.706318, 85.330147, "Softwarica College")) ;
        latLngs.add(new LatitudeLongitude(27.705609, 85.325701, " AT Burger Point")) ;
        latLngs.add(new LatitudeLongitude(27.708950, 85.325945, " Islington College")) ;
        latLngs.add(new LatitudeLongitude(27.693938, 83.468412, " Bhatbhateni Butwal")) ;
        latLngs.add(new LatitudeLongitude(31.764355, -85.339030, " Burger King Alabama")) ;


        CameraUpdate center, Zoom;
        for (int i = 0; i<latLngs.size();i++){
            center = CameraUpdateFactory.newLatLng(new LatLng(latLngs.get(i).getLat(),latLngs.get(i).getLon()));
            Zoom = CameraUpdateFactory.zoomTo(20);
            mMap.addMarker(new MarkerOptions().position(new LatLng(latLngs.get(i).getLat(),latLngs.get(i).getLon())).title(latLngs.get(i).getMarker()));

            mMap.moveCamera(center);
            mMap.animateCamera(Zoom);
            mMap.getUiSettings().setZoomControlsEnabled(true);
        }
    }
}
