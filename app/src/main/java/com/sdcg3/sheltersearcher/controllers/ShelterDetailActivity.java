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

        TextView name = findViewById(R.id.name);
        TextView capacity = findViewById(R.id.capacity);
        TextView restrictions =findViewById(R.id.restrictions);
        TextView longitude =findViewById(R.id.longitude);
        TextView latitude =findViewById(R.id.latitude);
        TextView address =findViewById(R.id.address);
        TextView notes =findViewById(R.id.notes);
        TextView phone =findViewById(R.id.phone);
        shelter.doStuff(capacity,restrictions,longitude,latitude);
        shelter.doStuff2(address,notes,phone,name);
    }

    /**
     * claim
     * @param view view
     */
    @SuppressWarnings("LawOfDemeter")
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


    }
}
