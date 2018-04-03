package com.sdcg3.sheltersearcher.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
     * @param view view
     */
    public void logOut(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * shows Shelters in view
     * @param view view
     */
    public void showShelters(View view){
        ((MyApp)getApplication()).resetFiltered();
        Intent intent = new Intent(this, ListSheltersActivity.class);
        startActivity(intent);
    }

    /**
     * search Shelters in view
     * @param view view
     */
    public void searchShelters(View view){
        Intent intent = new Intent(this, SearchSheltersActivity.class);
        startActivity(intent);
    }

    /**
     * Show details in view
     * @param view view
     */
    public void showDetail(View view){
        Intent intent = new Intent(this, UserDetailActivity.class);
        startActivity(intent);
    }

}
