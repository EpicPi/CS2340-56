package com.sdcg3.sheltersearcher.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;

/**
 * Landing Page
 */
public class LandingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

    }

    /**
     *
     */
    public void logOut(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * shows Shelters in view
     */
    public void showShelters(){
        ((MyApp)getApplication()).resetFiltered();
        Intent intent = new Intent(this, ListSheltersActivity.class);
        startActivity(intent);
    }

    /**
     * search Shelters in view
     */
    public void searchShelters(){
        Intent intent = new Intent(this, SearchSheltersActivity.class);
        startActivity(intent);
    }

    /**
     * Show details in view
     */
    public void showDetail(){
        Intent intent = new Intent(this, UserDetailActivity.class);
        startActivity(intent);
    }

}
