package com.sdcg3.sheltersearcher.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sdcg3.sheltersearcher.MyApp;
import com.sdcg3.sheltersearcher.R;
import com.sdcg3.sheltersearcher.model.Shelter;
import com.sdcg3.sheltersearcher.model.User;

public class UserDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user =((MyApp)getApplication()).current;
        setContentView(R.layout.activity_user_detail);
        if(user.shelter==null){
            user.shelter = "a";
        }
        Log.e("creating user detail name",user.shelter);
        Log.e("creating user detail num",user.number+"");
        ((TextView)findViewById(R.id.textView8)).setText(user.shelter);
        ((TextView)findViewById(R.id.textView9)).setText(user.number+"");
    }

    public void releaseBeds(View view){
        User user =((MyApp)getApplication()).current;
        Shelter shelter = ((MyApp)getApplication()).findByName(user.shelter);
        int num = user.number;
        user.number = 0;
        user.shelter="";
        shelter.capacity += num;
        shelter.claimed -= num;
        ((TextView)findViewById(R.id.textView8)).setText(user.shelter);
        ((TextView)findViewById(R.id.textView9)).setText(user.number+"");
    }
}
