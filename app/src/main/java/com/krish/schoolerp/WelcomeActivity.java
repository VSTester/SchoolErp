package com.krish.schoolerp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }


    public void onButtonSignUpClicked(View view){

        Intent intent = new Intent(WelcomeActivity.this,SignUpActivity.class);
        startActivity(intent);
    }

    public void onButtonSignInClicked(View view){

        Intent intent = new Intent(WelcomeActivity.this,SignInActivity.class);
        startActivity(intent);

    }
}