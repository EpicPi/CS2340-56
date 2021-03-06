package com.sdcg3.sheltersearcher.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;
import com.sdcg3.sheltersearcher.model.Shelter;

import java.util.List;

/**
 * Lists the filtered shelters
 */
public class ListSheltersActivity extends AppCompatActivity {
    private List<Shelter> shelters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView listView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_shelters);
        shelters = ((MyApp) getApplication()).getFiltered();
        listView = findViewById(R.id.list);
        ListAdapter adapter = new ShelterAdapter(shelters, getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> parent, View view,
                                         int position, long id) -> {
            Shelter shelter = shelters.get(position);
            ((MyApp) getApplication()).setSelected(shelter);
            Intent intent = new Intent(getApplicationContext(), ShelterDetailActivity.class);
            startActivity(intent);
        });

        Button mapButton = findViewById(R.id.mapButton);
        mapButton.setOnClickListener(view -> {

            Intent intent = new Intent(getBaseContext(), MapsActivity.class);
            startActivity(intent);
        });
    }

}