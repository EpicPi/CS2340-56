package com.sdcg3.sheltersearcher.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;
import com.sdcg3.sheltersearcher.Enums.AccountType;

/**
 * Allows people to register for an account
 */

public class RegistrationActivity extends AppCompatActivity {

    private Spinner accountTypeSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        accountTypeSpinner = findViewById(R.id.editAccountTypeSpinner);
        ArrayAdapter<String> adapterAccountType = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, AccountType.values());
        adapterAccountType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountTypeSpinner.setAdapter(adapterAccountType);
    }

    public void register(View view) {

        EditText firstName = findViewById(R.id.editFirstName);
        EditText lastName = findViewById(R.id.editLastName);
        EditText user = findViewById(R.id.editNewUsername);
        EditText pass = findViewById(R.id.editNewPassword);

        Editable a = firstName.getText();
        String firstNameStr = a.toString();
        Editable b = lastName.getText();
        String lastNameStr = b.toString();
        Editable c = user.getText();
        String userStr = c.toString();
        Editable d = pass.getText();
        String passStr = d.toString();
        Object o = accountTypeSpinner.getSelectedItem();
        String accountTypeStr = o.toString();

        if (firstNameStr.equals("") || lastNameStr.equals("") || userStr.equals("")
                || passStr.equals("") || (accountTypeStr == null)) {
            Toast toast = Toast.makeText(this, "Please enter valid information",
                    Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Editable f = user.getText();
            Editable g = pass.getText();
            ((MyApp) getApplication()).addUser(f.toString(), g.toString());
            Intent intent = new Intent(this, LandingPageActivity.class);
            startActivity(intent);
        }
    }

    public void cancel(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
