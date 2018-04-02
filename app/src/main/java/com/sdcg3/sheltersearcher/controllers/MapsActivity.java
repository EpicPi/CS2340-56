package com.sdcg3.sheltersearcher.controllers;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;

import java.util.List;

import com.sdcg3.sheltersearcher.model.DataElement;
import com.sdcg3.sheltersearcher.model.DataServiceFacade;


/**
 * Displays a map of all the filtered shelters
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //save the map instance returned from Google
        GoogleMap mMap = googleMap;

        //reference to our GRASP Controller interface to the model
        final DataServiceFacade dataService = DataServiceFacade.getInstance();
        dataService.setData(((MyApp) getApplication()).getFiltered());

        //get the data to display
        List<DataElement> dataList = dataService.getData();

        //iterate through the list and add a pin for each element in the model
        for (DataElement de : dataList) {
            LatLng loc = new LatLng(de.getLatitude(), de.getLongitude());
            mMap.addMarker(new MarkerOptions().position(loc).title(de.getName()).snippet(de.getDescription()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
        }

        //Use a custom layout for the pin data
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());
    }

    /**
     * This class implements a custom layout for the pin
     */
    class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        private final View myContentsView;

        /**
         * Make the adapter
         */
        CustomInfoWindowAdapter() {
            // hook up the custom layout view in res/custom_map_pin_layout.xml
            myContentsView = getLayoutInflater().inflate(R.layout.custom_map_pin_layout, null);
        }

        @Override
        public View getInfoContents(Marker marker) {

            TextView tvTitle = myContentsView.findViewById(R.id.title);
            tvTitle.setText(marker.getTitle());
            TextView tvSnippet = myContentsView.findViewById(R.id.snippet);
            tvSnippet.setText(marker.getSnippet());

            return myContentsView;
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }
    }
}