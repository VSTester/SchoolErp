package com.krish.schoolerp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.krish.schoolerp.databinding.ActivitySyllabusBinding;

public class SyllabusActivity extends DrawerBaseActivity {


    ActivitySyllabusBinding activitySyllabusBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySyllabusBinding = ActivitySyllabusBinding.inflate(getLayoutInflater());
        setContentView(activitySyllabusBinding.getRoot());
        allocateActivityTitle("Syllabus");
    }



}