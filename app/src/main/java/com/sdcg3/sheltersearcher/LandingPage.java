package com.sdcg3.sheltersearcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
    }
    public void logOut(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
