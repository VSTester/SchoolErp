package com.krish.schoolerp;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class CastelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_castel);

        //Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TextView welcomeMessage = findViewById(R.id.txt_Welcome_msg);
        welcomeMessage.animate().translationX(2000).setDuration(3000).setStartDelay(3000);


        Thread thread = new Thread(){
            public void run(){
                try {
                    Thread.sleep(7000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(CastelActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}