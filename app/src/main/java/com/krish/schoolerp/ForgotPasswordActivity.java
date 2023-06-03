package com.krish.schoolerp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText editTextRestPassEmailId;
    ProgressBar progressBar;
    ImageView imgRestPasswordLogo,imgRestPasswordFooterLogo;
    Button btnResetPassword;

    LottieAnimationView lottieAnimationView;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        editTextRestPassEmailId = (EditText)findViewById(R.id.edForgotEmailId);
        imgRestPasswordLogo = (ImageView) findViewById(R.id.forgot_Logo);
        imgRestPasswordFooterLogo = (ImageView) findViewById(R.id.forgotPassword_footer_logo);
        progressBar = (ProgressBar) findViewById(R.id.progressBarRestPassword);
        btnResetPassword = (Button)findViewById(R.id.btn_Reset_Password);
        lottieAnimationView = (LottieAnimationView)findViewById(R.id.lottieSendMailAnimationView);
        mAuth = FirebaseAuth.getInstance();
    }



    public void buttonResetPasswordClicked(View View){
        String textRestPasswordEmailId = editTextRestPassEmailId.getText().toString().trim();
        if (!Patterns.EMAIL_ADDRESS.matcher(textRestPasswordEmailId).matches()) {
            Log.d("scherp","email is "+ textRestPasswordEmailId );
            editTextRestPassEmailId.setError("Please Enter Valid Email Id");
            editTextRestPassEmailId.requestFocus();
            if (textRestPasswordEmailId.isEmpty()) {
                editTextRestPassEmailId.setError("Please Enter Email Id");
                editTextRestPassEmailId.requestFocus();
            }
        }else {
            progressBar.setVisibility(View.VISIBLE);
            mAuth.sendPasswordResetEmail(textRestPasswordEmailId).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        editTextRestPassEmailId.setText(null);
                        editTextRestPassEmailId.setVisibility(View.GONE);
                        imgRestPasswordLogo.setVisibility(View.GONE);
                        imgRestPasswordFooterLogo.setVisibility(View.GONE);
                        btnResetPassword.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        lottieAnimationView.setVisibility(View.VISIBLE);
                        Toast.makeText(ForgotPasswordActivity.this, "Reset password email sent to: " + textRestPasswordEmailId, Toast.LENGTH_SHORT).show();

                        Runnable runnable = new Runnable() {
                            @Override
                            public void run() {
                                lottieAnimationView.setVisibility(View.GONE);
                                Intent intent = new Intent(ForgotPasswordActivity.this, SignInActivity.class);
                                startActivity(intent);
                            }
                        };
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.postDelayed(runnable,2500);
                    } else{
                        Toast.makeText(ForgotPasswordActivity.this, "Unable to reset your password. please try again later", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }
            });



        }

    }
}