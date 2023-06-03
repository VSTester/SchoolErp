package com.krish.schoolerp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.krish.schoolerp.databinding.ActivityFeesBinding;

public class FeesActivity extends DrawerBaseActivity {

    ActivityFeesBinding activityFeesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFeesBinding = ActivityFeesBinding.inflate(getLayoutInflater());
        setContentView(activityFeesBinding.getRoot());
        allocateActivityTitle("Fees");
    }


}