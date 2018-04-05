package com.sdcg3.sheltersearcher.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;
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
        ((TextView) findViewById(R.id.textView8)).setText(user.getShelter());
        String x = user.getNumber() + "";
        ((TextView) findViewById(R.id.textView9)).setText(x);
    }

    /**
     * releases beds
     * @param view view
     */
    public void releaseBeds(View view) {
        view.clearFocus();
        ((MyApp)getApplication()).releaseBeds();
        ((TextView) findViewById(R.id.textView8)).setText("");
        ((TextView) findViewById(R.id.textView9)).setText("0");
    }
}
