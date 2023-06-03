package com.krish.schoolerp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.krish.schoolerp.databinding.ActivityTimeTableBinding;

public class TimeTableActivity extends DrawerBaseActivity {

    ActivityTimeTableBinding activityTimeTableBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTimeTableBinding  = ActivityTimeTableBinding.inflate(getLayoutInflater());
        setContentView(activityTimeTableBinding.getRoot());
        allocateActivityTitle("TimeTable");
    }


}