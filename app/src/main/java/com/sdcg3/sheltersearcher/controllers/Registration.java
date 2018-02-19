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
import com.sdcg3.sheltersearcher.model.AccountType;

/**
 * Created by aballari on 2/19/18.
 */

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ArrayAdapter<String> adapterAccountType = new ArrayAdapter(this, R.id.editAccountTypeSpinner, AccountType.values());
        adapterAccountType.setDropDownViewResource(R.id.editAccountTypeSpinner);
        AccountType.setAdapter(adapterAccountType);
    }
    public void register(View view){

        Intent intent = new Intent(this, LandingPage.class);
        EditText firstName = (EditText) findViewById(R.id.editFirstName);
        EditText lastName = (EditText) findViewById(R.id.editLastName);
        EditText user = (EditText) findViewById(R.id.editNewUsername);
        EditText pass = (EditText) findViewById(R.id.editNewPassword);
        Spinner accountTypeSpinner = (Spinner) findViewById(R.id.editAccountTypeSpinner);

        if(user.getText().toString().equals("user") && pass.getText().toString().equals("pass")){
            startActivity(intent);
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
