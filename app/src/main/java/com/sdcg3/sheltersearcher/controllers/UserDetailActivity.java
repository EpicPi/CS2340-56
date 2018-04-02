package com.sdcg3.sheltersearcher.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;
import com.sdcg3.sheltersearcher.model.Shelter;
import com.sdcg3.sheltersearcher.model.User;

/**
 * user detail
 */
public class UserDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user = ((MyApp) getApplication()).getCurrent();
        setContentView(R.layout.activity_user_detail);
        if (user.getShelter() == null) {
            user.setShelter("a");
        }
        Log.e("creating user detail name", user.getShelter());
        Log.e("creating user detail num", user.getNumber() + "");
        ((TextView) findViewById(R.id.textView8)).setText(user.getShelter());
        String x = user.getNumber() + "";
        ((TextView) findViewById(R.id.textView9)).setText(x);
    }

    /**
     * releases beds
     *
     * @param view view
     */
    public void releaseBeds(View view) {
        User user = ((MyApp) getApplication()).getCurrent();
        Shelter shelter = ((MyApp) getApplication()).findByName(user.getShelter());
        if (shelter == null) {
            Toast toast = Toast.makeText(this, "No shelter space allocated", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        int num = user.getNumber();
        user.setNumber(0);
        user.setShelter("");
        shelter.setCapacity(shelter.getCapacity() + num);
        shelter.setClaimed(shelter.getClaimed() - num);
        ((TextView) findViewById(R.id.textView8)).setText(user.getShelter());
        String z = user.getNumber() + "";
        ((TextView) findViewById(R.id.textView9)).setText(z);
        ((MyApp) getApplication()).writePpl();
        ((MyApp) getApplication()).writeShelters();
    }
}
