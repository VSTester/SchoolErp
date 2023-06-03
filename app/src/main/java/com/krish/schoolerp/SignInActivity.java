package com.krish.schoolerp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignInActivity extends AppCompatActivity {


    EditText editTextEmailId,editTextPassword;
    TextView txtViewForgotPassword, txtViewRegister;
    ProgressBar progressBar;
    SharedPreferences sharedPreferences;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

       editTextEmailId = (EditText)findViewById(R.id.edSigininEmailId);
        editTextPassword = (EditText)findViewById(R.id.edSigninPassword);
        txtViewForgotPassword = (TextView) findViewById(R.id.txt_forgot_Pass);
        txtViewRegister = (TextView) findViewById(R.id.txt_Register);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_Signin);
        mAuth = FirebaseAuth.getInstance();
        sharedPreferences = getSharedPreferences("Dashboard",MODE_PRIVATE);

    }


    public void textSignInForgotPasswordClicked(View view){
        Intent intent = new Intent(SignInActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
    public void textSignInRegisterClicked(View view){
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
    public void buttonSignInScrSignInClicked(View view){
        int count = 2;
        String textEmailId = editTextEmailId.getText().toString().trim();
        String textPassword = editTextPassword.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(textEmailId).matches()) {
            editTextEmailId.setError("Please Enter Valid Email Id");
            editTextEmailId.requestFocus();
            if (textEmailId.isEmpty()) {
                editTextEmailId.setError("Please Enter Email Id");
                editTextEmailId.requestFocus();
            }
            count--;
        }
        if (textPassword.isEmpty() || textPassword.length() <= 6) {
            editTextPassword.setError("Please Enter Password conatin atleat 6 charaters");
            editTextPassword.requestFocus();
            count--;
        }
        if (count==2){
            authenticateSignInWithEmailAndPassword(textEmailId, textPassword);
        }
    }

    public void authenticateSignInWithEmailAndPassword(String textEmailId, String textPassword){
            progressBar.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(textEmailId, textPassword)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    Toast.makeText(SignInActivity.this, "User has successfully Sign in", Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);
                                    editTextEmailId.setText(null);
                                    editTextPassword.setText(null);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.commit();
                                    startActivity(new Intent(SignInActivity.this,DashboardActivity.class));
                                }else{
                                    Toast.makeText(SignInActivity.this, "Invalid User name and password", Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);
                                }

                            }
                        });
    }
}
