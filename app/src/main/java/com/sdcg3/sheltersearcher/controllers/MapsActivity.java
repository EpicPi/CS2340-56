package com.sdcg3.sheltersearcher.controllers;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;

import java.util.List;

import com.sdcg3.sheltersearcher.model.DataElement;
import com.sdcg3.sheltersearcher.model.DataServiceFacade;
import com.sdcg3.sheltersearcher.model.Shelter;


/**
 * Displays a map of all the filtered shelters
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        FragmentManager m = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) m.findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //reference to our GRASP Controller interface to the model
        final DataServiceFacade dataService = DataServiceFacade.getInstance();
        List<Shelter> filteredAppResults = ((MyApp) getApplication()).getFiltered();
        dataService.setData(filteredAppResults);

        //get the data to display
        List<DataElement> dataList;
        dataList = dataService.getData();

        //iterate through the list and add a pin for each element in the model
        for (DataElement de : dataList) {
            googleMap.addMarker(de.getMO());
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(de.getLatitudeLongitude()));
        }

        //Use a custom layout for the pin data
        googleMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());
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
            LayoutInflater inf = getLayoutInflater();
            myContentsView = inf.inflate(R.layout.custom_map_pin_layout, null);
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