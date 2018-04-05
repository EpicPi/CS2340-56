package com.sdcg3.sheltersearcher.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;
import com.sdcg3.sheltersearcher.model.Shelter;
import com.sdcg3.sheltersearcher.model.User;

/**
 * Shelter Detail Activity
 */
public class ShelterDetailActivity extends AppCompatActivity {
    private Shelter shelter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_detail);
        shelter = ((MyApp)getApplication()).getSelected();
        ((TextView)findViewById(R.id.name)).setText(shelter.getName());
        String x = shelter.getCapacity() + "";
        ((TextView)findViewById(R.id.capacity)).setText(x);
        ((TextView)findViewById(R.id.restrictions)).setText(shelter.getRestrictions());
        ((TextView)findViewById(R.id.longitude)).setText(shelter.getLongitude());
        ((TextView)findViewById(R.id.latitude)).setText(shelter.getLatitude());
        ((TextView)findViewById(R.id.address)).setText(shelter.getAddress());
        ((TextView)findViewById(R.id.notes)).setText(shelter.getNotes());
        ((TextView)findViewById(R.id.phone)).setText(shelter.getPhone());
    }

    /**
     * claim
     * @param view view
     */
    public void claim(View view){
        view.clearFocus();
        EditText amount = findViewById(R.id.editAmount);
        int number;
        try {
            Editable text = amount.getText();
            number = Integer.parseInt(text.toString());
        }
        catch (Exception e){
            Toast toast = Toast.makeText(this, "Please enter a valid amount",
                    Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        User usr = ((MyApp)getApplication()).getCurrent();

        if(usr.getNumber()!=0){
            Toast toast = Toast.makeText(this, "Must release claimed beds first",
                    Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if((shelter.getCapacity() - number) < 0){
            Toast toast = Toast.makeText(this,
                    "Shelter does not have enough capacity left", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        ((MyApp)getApplication()).claim(number,shelter);
        String y = shelter.getCapacity() + "";
        ((TextView)findViewById(R.id.capacity)).setText(y);
        amount.setText("");
        ((MyApp)getApplication()).writePpl();
        ((MyApp)getApplication()).writeShelters();

    }
}
