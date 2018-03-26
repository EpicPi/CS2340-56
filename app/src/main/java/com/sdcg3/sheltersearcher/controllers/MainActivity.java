package com.sdcg3.sheltersearcher.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;

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
    }
    public void login(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void registration(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

}
