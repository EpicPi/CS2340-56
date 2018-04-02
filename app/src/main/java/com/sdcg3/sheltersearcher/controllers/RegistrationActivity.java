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

    /**
     * registration activity
     * @param view view
     */
    public void register(View view) {

        EditText firstName = findViewById(R.id.editFirstName);
        EditText lastName = findViewById(R.id.editLastName);
        EditText user = findViewById(R.id.editNewUsername);
        EditText pass = findViewById(R.id.editNewPassword);

        String firstNameStr = firstName.getText().toString();
        String lastNameStr = lastName.getText().toString();
        String userStr = user.getText().toString();
        String passStr = pass.getText().toString();
        String accountTypeStr = accountTypeSpinner.getSelectedItem().toString();

        if ("".equals(firstNameStr) || "".equals(lastNameStr) || "".equals(userStr)
                || "".equals(passStr) || (accountTypeStr == null)) {
            Toast toast = Toast.makeText(this, "Please enter valid information",
                    Toast.LENGTH_SHORT);
            toast.show();
        } else {
            ((MyApp) getApplication()).addUser(user.getText().toString(), pass.getText()
                    .toString());
            Intent intent = new Intent(this, LandingPageActivity.class);
            startActivity(intent);
        }

    }

    /**
     * cancel button
     * @param view view
     */
    public void cancel(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
