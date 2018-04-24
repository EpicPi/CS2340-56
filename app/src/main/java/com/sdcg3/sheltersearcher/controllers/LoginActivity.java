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
     * @param view view
     */
    public void login(View view){
        view.clearFocus();
        EditText user = findViewById(R.id.editUname);
        EditText pass = findViewById(R.id.editPass);
        Editable a = user.getText();
        Editable b = pass.getText();
        String res = ((MyApp)getApplication()).isCorrect(a.toString(),               b.toString());
        if(res.equals("yes")){
            Intent intent = new Intent(this, LandingPageActivity.class);
            startActivity(intent);
        }else{
            Toast toast;
            if(res.equals("no")){
                toast = Toast.makeText(this, "incorrect username/password combo",
                        Toast.LENGTH_SHORT);
            }else {
                toast = Toast.makeText(this, "You are locked out please contact an admin",
                        Toast.LENGTH_SHORT);
            }
            toast.show();
        }
    }

    /**
     * cancels login
     * @param  view view
     */
    public void cancel(View view){
        view.clearFocus();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
