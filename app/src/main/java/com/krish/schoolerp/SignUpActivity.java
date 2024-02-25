package com.krish.schoolerp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.krish.schoolerp.model.UserModel;
import com.krish.schoolerp.utils.FirebaseUtils;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {


    EditText editTextUserName;
    EditText editTextSchoolName;
    EditText editTextAddress;
    EditText editTextState;
    EditText editTextCity;
    EditText editTextPhoneNo;
    EditText editTextRole;
    EditText editTextEmailId;
    EditText editTextPassword;



    ProgressBar progressBar;

    private FirebaseAuth mAuth;

    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editTextUserName = (EditText) findViewById(R.id.edUserName);
        editTextSchoolName = (EditText)findViewById(R.id.edSchoolName);
        editTextAddress= (EditText)findViewById(R.id.edAddress);
        editTextState= (EditText)findViewById(R.id.edState);
        editTextCity= (EditText)findViewById(R.id.edCity);
        editTextPhoneNo= (EditText)findViewById(R.id.edPhoneNo);
        editTextRole= (EditText)findViewById(R.id.edRole);
        editTextEmailId= (EditText)findViewById(R.id.edEmailId);
        editTextPassword= (EditText)findViewById(R.id.edPassword);
        progressBar= (ProgressBar)findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();
    }

    public void signinButtonClicked(View view) {
        int count =5;
        String textUserName = editTextUserName.getText().toString().trim();
        String textSchoolName = editTextSchoolName.getText().toString().trim();
        String textAddress = editTextAddress.getText().toString().trim();
        String textState = editTextState.getText().toString().trim();
        String textCity = editTextCity.getText().toString().trim();
        String textPhoneNo = editTextPhoneNo.getText().toString().trim();
        String textRole = editTextRole.getText().toString().trim();
        String textEmailId = editTextEmailId.getText().toString().trim();
        String textPassword = editTextPassword.getText().toString().trim();


        if (textUserName.isEmpty()) {
            editTextUserName.setError("Please Enter User Name");
            editTextUserName.requestFocus();
            count--;
        }
        if (textSchoolName.isEmpty()) {
            editTextSchoolName.setError("Please Enter School Name");
            editTextSchoolName.requestFocus();
            count--;
        }

        if (textRole.isEmpty()) {
            editTextRole.setError("Please Enter User Role");
            editTextRole.requestFocus();
            count--;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(textEmailId).matches()) {
            editTextEmailId.setError("Please Enter valid Email Id");
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

        if(count==5)
        {
            authenticateUserWithEmailAndPassword(textUserName, textSchoolName, textAddress,
                    textState, textCity, textPhoneNo, textRole, textEmailId, textPassword, "");

        }

    }



    private void authenticateUserWithEmailAndPassword(String textUserName, String textSchoolName, String textAddress,
                                                      String textState, String textCity, String textPhoneNo, String textRole, String textEmailId, String textPassword, String textClassName) {
        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(textEmailId, textPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){


                            User user = new User(textUserName,textSchoolName,textAddress,
                                    textState,textCity,textPhoneNo,textRole,textEmailId,textPassword,textClassName);
                            FirebaseDatabase.getInstance().getReference("User").
                                    child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()) {
                                                Toast.makeText(SignUpActivity.this, "User Registered successfully", Toast.LENGTH_SHORT).show();
                                                //for firebaseStore
//                                                setUserDataInFireStoreDb(textUserName,textSchoolName,textAddress,
//                                                        textState,textCity,textPhoneNo, textRole,textEmailId,textPassword," ");
                                                progressBar.setVisibility(View.GONE);
                                                Intent intent = new Intent(SignUpActivity.this, WelcomeActivity.class);
                                                startActivity(intent);
                                            }else{
                                                Toast.makeText(SignUpActivity.this, "User Fail to Registered", Toast.LENGTH_SHORT).show();
                                                progressBar.setVisibility(View.GONE);
                                            }

                                        }
                                    });
                        }else{
                            Toast.makeText(SignUpActivity.this, "User Fail to Registered", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

//    void setUserDataInFireStoreDb(String textUserName, String textSchoolName, String textAddress,
//                                                 String textState, String textCity, String textPhoneNo, String textRole, String textEmailId, String textPassword, String textClassName){
//        userModel = new UserModel(textUserName,textSchoolName,textAddress,
//                textState,textCity,textPhoneNo,textEmailId,textPassword,textClassName,textRole);
//
//        FirebaseUtils.currentUserDetails().set(userModel).addOnCompleteListener(task ->{
//            if(task.isSuccessful()) {
//              Toast.makeText(SignUpActivity.this, "User Registered on FireStore successfully", Toast.LENGTH_SHORT).show();
//            }else{
//                Toast.makeText(SignUpActivity.this, "User Fail to Registered on FireStore", Toast.LENGTH_SHORT).show();
//            }
//                });
//    }
}
