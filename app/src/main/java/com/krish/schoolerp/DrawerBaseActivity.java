package com.krish.schoolerp;

import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerLayout;
    private SharedPreferences sharedPreferences;

    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_View);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.menu_drawer_open,R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START,false);
        switch (item.getItemId()){
            case R.id.nav_Dashboard:
                startActivity(new Intent(this,DashboardActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_Attendence:
                startActivity(new Intent(this,AttendanceActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_Homework:
                startActivity(new Intent(this,HomeWorkActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_TimeTable:
                startActivity(new Intent(this,TimeTableActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_Syllabus:
                startActivity(new Intent(this,SyllabusActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_Fees:
                startActivity(new Intent(this,FeesActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_logout:
                logout();
                break;
            case R.id.nav_Profile:
                startActivity(new Intent(this,UpdateProfileActivity.class));
                overridePendingTransition(0,0);
                break;
    }
    return false;
    }


    public void allocateActivityTitle(String title){
        if (getSupportActionBar()!= null){
            getSupportActionBar().setTitle(title);
        }
    }

    public void logout(){
        sharedPreferences = getSharedPreferences("Logout",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Intent intent =   new Intent(this,SignInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        Toast.makeText(this, "User has been log out", Toast.LENGTH_SHORT).show();
    }
}