package com.sdcg3.sheltersearcher.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.sdcg3.sheltersearcher.Enums.AGE;
import com.sdcg3.sheltersearcher.Enums.GENDER;
import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;

import java.util.stream.Stream;

public class SearchSheltersActivity extends AppCompatActivity {
    private Spinner GenderSpinner;
    private Spinner AgeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_shelters);

        GenderSpinner = findViewById(R.id.gender);

        ArrayAdapter<String> genderAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                Stream.of(GENDER.values()).map(GENDER::name).toArray(String[]::new));
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        GenderSpinner.setAdapter(genderAdapter);

        AgeSpinner = findViewById(R.id.age);
        ArrayAdapter<String> ageAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                Stream.of(AGE.values()).map(AGE::name).toArray(String[]::new));
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AgeSpinner.setAdapter(ageAdapter);
    }

    public void search(View view) {
        Object g = GenderSpinner.getSelectedItem();
        GENDER gen = GENDER.valueOf(g.toString());
        Object a = AgeSpinner.getSelectedItem();
        AGE ag = AGE.valueOf(a.toString());
        Editable et = ((EditText) findViewById(R.id.name)).getText();
        ((MyApp) getApplication()).filter(gen.toString(), ag.toString(), et.toString());
        Intent intent = new Intent(this, ListSheltersActivity.class);
        startActivity(intent);
    }
}
