package com.sdcg3.sheltersearcher.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;

/**
 * Displays the login username and password fields
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    /**
     * Login activity
     */
    public void login(View view){
        view.clearFocus();
        EditText user = findViewById(R.id.editUname);
        EditText pass = findViewById(R.id.editPass);
        Editable a = user.getText();
        Editable b = pass.getText();
        if(((MyApp)getApplication()).isCorrect(a.toString(),
                b.toString())){
            Intent intent = new Intent(this, LandingPageActivity.class);
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(this, "incorrect username/password combo",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * cancels login
     */
    public void cancel(View view){
        view.clearFocus();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
