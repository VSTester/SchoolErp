package com.krish.schoolerp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.krish.schoolerp.databinding.ActivityHomeWorkBinding;

public class HomeWorkActivity extends DrawerBaseActivity {

    ActivityHomeWorkBinding activityHomeWorkBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeWorkBinding = ActivityHomeWorkBinding.inflate(getLayoutInflater());
        setContentView(activityHomeWorkBinding.getRoot());
        allocateActivityTitle("HomeWork");
    }


}