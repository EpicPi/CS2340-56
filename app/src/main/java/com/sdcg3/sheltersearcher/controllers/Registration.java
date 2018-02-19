package com.sdcg3.sheltersearcher.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;
import com.sdcg3.sheltersearcher.model.AccountType;

/**
 * Created by aballari on 2/19/18.
 */

public class Registration extends AppCompatActivity {
    private EditText firstName;
    private EditText lastName;
    private EditText user;
    private EditText pass;
    private Spinner accountTypeSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        accountTypeSpinner = (Spinner) findViewById(R.id.editAccountTypeSpinner);
        ArrayAdapter<String> adapterAccountType = new ArrayAdapter(this, android.R.layout.simple_spinner_item, AccountType.values());
        adapterAccountType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountTypeSpinner.setAdapter(adapterAccountType);
    }

    public void register(View view){


        firstName = (EditText) findViewById(R.id.editFirstName);
        lastName = (EditText) findViewById(R.id.editLastName);
        user = (EditText) findViewById(R.id.editNewUsername);
        pass = (EditText) findViewById(R.id.editNewPassword);

        String firstNameStr = firstName.getText().toString();
        String lastNameStr = lastName.getText().toString();
        String userStr = user.getText().toString();
        String passStr = pass.getText().toString();
        String accountTypeStr = accountTypeSpinner.getSelectedItem().toString();

        if (firstNameStr == null || lastNameStr == null || userStr == null || passStr == null || accountTypeStr == null) {
            Toast toast = Toast.makeText(this, "Please enter valid information", Toast.LENGTH_SHORT);
            toast.show();

        } else {
            ((MyApp)getApplication()).addUser(user.getText().toString(),pass.getText().toString());
            Intent intent = new Intent(this, LandingPage.class);
            startActivity(intent);
        }

    }

    public void cancel(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
