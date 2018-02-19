package com.sdcg3.sheltersearcher.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;

import com.sdcg3.sheltersearcher.R;
/**
 * Created by aballari on 2/19/18.
 */

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void register(View view){


    }

    public void cancel(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
