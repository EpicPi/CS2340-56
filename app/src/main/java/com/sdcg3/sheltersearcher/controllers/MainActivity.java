package com.sdcg3.sheltersearcher.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;

/**
 * main activity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApp)getApplication()).readPpl();
        ((MyApp)getApplication()).readShelters();
//        if(((MyApp)getApplication()).getFiltered().size()==0){
//            ((MyApp)getApplication()).readCSV();
//            ((MyApp)getApplication()).writeShelters();
//            ((MyApp)getApplication()).writePpl();
//        }
        ((MyApp)getApplication()).writeLog("App opened");
    }

    /**
     * login intent
     * @param view view
     */
    public void login(View view) {
        view.clearFocus();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * registration intent
     * @param view view
     */
    public void registration(View view) {
        view.clearFocus();
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

}
