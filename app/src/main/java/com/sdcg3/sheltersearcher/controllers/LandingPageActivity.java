package com.sdcg3.sheltersearcher.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;

public class LandingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
    }
    public void logOut(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void showShelters(View view){
        Log.d("why?","why");
        ((MyApp)getApplication()).readCSV();
        Intent intent = new Intent(this, ListSheltersActivity.class);
        startActivity(intent);

    }
    public void searchShelters(View view){
        Intent intent = new Intent(this, SearchSheltersActivity.class);
        startActivity(intent);
    }
}
