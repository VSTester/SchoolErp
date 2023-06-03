package com.krish.schoolerp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.krish.schoolerp.databinding.ActivityAttendanceBinding;

public class AttendanceActivity extends DrawerBaseActivity {

    private FirebaseAuth mAuth;

    ActivityAttendanceBinding activityAttendanceBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAttendanceBinding = ActivityAttendanceBinding.inflate(getLayoutInflater());
        setContentView(activityAttendanceBinding.getRoot());
        allocateActivityTitle("Attendence");
    }



}