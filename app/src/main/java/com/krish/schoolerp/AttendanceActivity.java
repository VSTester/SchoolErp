package com.krish.schoolerp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.widget.CalendarView;

import com.applandeo.materialcalendarview.EventDay;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.krish.schoolerp.databinding.ActivityAttendanceBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class AttendanceActivity extends DrawerBaseActivity {

    private FirebaseAuth mAuth;

    ActivityAttendanceBinding activityAttendanceBinding;

   CalendarView calendarView;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAttendanceBinding = ActivityAttendanceBinding.inflate(getLayoutInflater());
        setContentView(activityAttendanceBinding.getRoot());
        allocateActivityTitle("Attendence");



    }
}