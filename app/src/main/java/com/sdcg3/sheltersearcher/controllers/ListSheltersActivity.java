package com.sdcg3.sheltersearcher.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;
import com.sdcg3.sheltersearcher.model.Shelter;

import java.util.List;

public class ListSheltersActivity extends AppCompatActivity {

    ListView listView;
    private static ShelterAdapter adapter;
    private List<Shelter> shelters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_shelters);
        shelters = ((MyApp) getApplication()).getFiltered();
        Log.e("idc", shelters.size()+"");
        listView = findViewById(R.id.list);
        adapter = new ShelterAdapter(shelters, getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Shelter shelter = shelters.get(position);
            ((MyApp) getApplication()).setSelected(shelter);
            Intent intent = new Intent(getApplicationContext(), ShelterDetailActivity.class);
            startActivity(intent);
        });
    }
}