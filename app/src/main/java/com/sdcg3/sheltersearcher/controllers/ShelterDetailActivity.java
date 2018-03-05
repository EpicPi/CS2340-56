package com.sdcg3.sheltersearcher.controllers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;
import com.sdcg3.sheltersearcher.model.Shelter;

public class ShelterDetailActivity extends AppCompatActivity {
    Shelter shelter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);
        shelter = ((MyApp)getApplication()).getSelected();
        ((TextView)findViewById(R.id.name)).setText(shelter.getName());
        ((TextView)findViewById(R.id.capacity)).setText(shelter.capacity);
        ((TextView)findViewById(R.id.restrictions)).setText(shelter.restrictions);
        ((TextView)findViewById(R.id.longitude)).setText(shelter.longi);
        ((TextView)findViewById(R.id.latitude)).setText(shelter.lati);
        ((TextView)findViewById(R.id.address)).setText(shelter.address);
        ((TextView)findViewById(R.id.notes)).setText(shelter.notes);
        ((TextView)findViewById(R.id.phone)).setText(shelter.phone);
    }

}
