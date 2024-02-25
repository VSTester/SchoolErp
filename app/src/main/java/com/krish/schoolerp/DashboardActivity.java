package com.krish.schoolerp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.krish.schoolerp.databinding.ActivityDashboardBinding;

public class DashboardActivity extends DrawerBaseActivity {


    ActivityDashboardBinding activityDashboardBinding;

    LinearLayout attLay,sylLay, homeWorkLay, timeTableLay, dateSheetLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());
        allocateActivityTitle("");
        attLay = (LinearLayout) findViewById(R.id.linAttendance);
        sylLay = (LinearLayout) findViewById(R.id.linSyllabus);
        homeWorkLay = (LinearLayout) findViewById(R.id.linHomework);
        timeTableLay = (LinearLayout) findViewById(R.id.linTimetable);
        dateSheetLay = (LinearLayout) findViewById(R.id.linDateSheet);



    }

    public void imgAttendanceClicked(View view){
        Intent intent = new Intent(DashboardActivity.this, AttendanceActivity.class);
        startActivity(intent);
    }
    public void imgSyllabusClicked(View view){
        Intent intent = new Intent(DashboardActivity.this, SyllabusActivity.class);
        startActivity(intent);
    }
    public void imgHomeworkClicked(View view){
        Intent intent = new Intent(DashboardActivity.this, HomeWorkActivity.class);
        startActivity(intent);
    }
    public void imgTimetableClicked(View view){
        Intent intent = new Intent(DashboardActivity.this, TimeTableActivity.class);
        startActivity(intent);
    }
    public void imgDatesheetClicked(View view){
//        Intent intent = new Intent(DashboardActivity.this, AttendanceActivity.class);
//        startActivity(intent);
    }








}