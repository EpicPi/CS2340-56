package com.sdcg3.sheltersearcher.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view){

        EditText user = findViewById(R.id.editUname);
        EditText pass = findViewById(R.id.editPass);
        if(((MyApp)getApplication()).isCorrect(user.getText().toString(), pass.getText().toString())){
            Intent intent = new Intent(this, LandingPageActivity.class);
            startActivity(intent);
            ((MyApp)getApplication()).readCSV();
        }else{
            Toast toast = Toast.makeText(this, "incorrect username/password combo", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void cancel(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
