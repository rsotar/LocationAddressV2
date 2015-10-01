package com.rober.locationaddressv2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends FragmentActivity {
    private static final LatLng LOWER_MANHATTAN = new LatLng(40.722543, -73.998585);
    private static final LatLng TIMES_SQUARE = new LatLng(40.7577, -73.9857);
    private static final LatLng BROOKLYN_BRIDGE = new LatLng(40.7057, -73.9964);
    /*Av Mate de Luna 3524-3598
    San Miguel de Tucuman, Tucumán
    -26.820991, -65.250796*/
    /*
    * Av Mate de Luna 2902
San Miguel de Tucuman, Tucumán
-26.823136, -65.241205*/
    /*Lavalle 2903-2999
T4000AZG San Miguel de Tucuman, Tucumán
-26.832155, -65.243715*/
    private static final LatLng Mate_1 = new LatLng(-26.820991, -65.250796);
    private static final LatLng Mate_2 = new LatLng(-26.823136, -65.241205);
    private static final LatLng Mate_3 = new LatLng(-26.832155, -65.243715);

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // check if we have got the googleMap already
        if (googleMap == null) {
            googleMap = ((SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map)).getMap();
            if (googleMap != null) {

                addLines();
            }
        }
    }

    private void addLines() {

        googleMap.addPolyline((new PolylineOptions()).add(Mate_1, Mate_2, Mate_3).width(5).
                color(Color.BLUE).geodesic(true));

        // move camera to zoom on map
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Mate_1, 13));

    }
}