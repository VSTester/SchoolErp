package com.krish.schoolerp;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.krish.schoolerp.model.UserModel;
import com.krish.schoolerp.utils.FirebaseUtils;

import java.util.HashMap;


public class UpdateProfileActivity extends AppCompatActivity {

    ImageView coverImage,profileImage;
    TextView upUserName, upSchoolName, upAddress,upState,upCity;
    EditText upPhone,upEmail,upClass;
    Button upUpdate;
    ProgressBar progressBar;
    FloatingActionButton coverImageBtn, profileImageBtn;
    UserModel currentUserModel;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        coverImage = (ImageView) findViewById(R.id.imgCoverImage);
        profileImage = (ImageView) findViewById(R.id.imgProfileImage);
        coverImageBtn = (FloatingActionButton) findViewById(R.id.floatingButtonCoverProfile);
        profileImageBtn = (FloatingActionButton) findViewById(R.id.floatingButtonProfile);
        upUserName = (TextView) findViewById(R.id.profile_UserName);
        upSchoolName = (TextView) findViewById(R.id.profile_SchoolName);
        upAddress = (TextView) findViewById(R.id.profile_Address);
        upState = (TextView) findViewById(R.id.profile_State);
        upCity = (TextView) findViewById(R.id.profile_City);
        upClass = (EditText) findViewById(R.id.profile_Class);
        upPhone = (EditText) findViewById(R.id.profile_PhoneNo);
        upEmail = (EditText) findViewById(R.id.profile_EmailId);
        upUpdate = (Button) findViewById(R.id.btn_UpdateProfile);
        progressBar = (ProgressBar) findViewById(R.id.profile_progressBar);

         getUserData();
        coverImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePicker(v, 10);
            }
        });
        profileImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePicker(v, 20);
            }
        });
    }

    private void getUserData() {
        setInProgress(true);
        String userId = FirebaseAuth.getInstance().getUid().trim();
        reference = FirebaseDatabase.getInstance().getReference("User");
        reference.child(userId).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()){


                if (task.getResult().exists()){
                    setInProgress(false);
                    DataSnapshot dataSnapShot = task.getResult();
                    String userName = String.valueOf(dataSnapShot.child("userName").getValue());
                    String userSchool = String.valueOf(dataSnapShot.child("userSchoolName").getValue());
                    String userAddress = String.valueOf(dataSnapShot.child("userAddress").getValue());
                    String userState = String.valueOf(dataSnapShot.child("userState").getValue());
                    String userCity = String.valueOf(dataSnapShot.child("userCity").getValue());
                    String userPhone = String.valueOf(dataSnapShot.child("userPhoneNo").getValue());
                    String userEmil = String.valueOf(dataSnapShot.child("userEmailId").getValue());
                    String userClassName = String.valueOf(dataSnapShot.child("userClass").getValue());
                    if (userName.isEmpty()){
                upUserName.setText("NA");
            }else{
                upUserName.setText(userName);
            }
            if (userSchool.isEmpty()){
                upSchoolName.setText("NA");
            }else{
                upSchoolName.setText(userSchool);
            }

            if (userAddress.isEmpty()){
                upAddress.setText("NA");
            }else{
                upAddress.setText(userAddress);
            }
            if (userState.isEmpty()){
                upState.setText("NA");
            }else{
                upState.setText(userState);
            }
            if (userCity.isEmpty()){
                upCity.setText("NA");
            }else{
                upCity.setText(userCity);
            }
            if (userEmil.isEmpty()){
                upEmail.setText("NA");
            }else{
                upEmail.setText(userEmil);
            }
            if (userClassName.isEmpty()||TextUtils.equals(userClassName ,"null")){
                upClass.setText("NA");
            }else{
                upClass.setText(userClassName);
            }

            if (userPhone.isEmpty()){
                upPhone.setText("NA");
            }else{
                upPhone.setText(userPhone);
            }

                }else{
                    Toast.makeText(UpdateProfileActivity.this, "User Doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(UpdateProfileActivity.this, "Unable to fetch Data", Toast.LENGTH_SHORT).show();
            }



        });

        //for firebaseStore
//        FirebaseUtils.currentUserDetails().get().addOnCompleteListener(task -> {
//            setInProgress(false);
//            currentUserModel  = task.getResult().toObject(UserModel.class);
//            String userName =   currentUserModel.getUserName();
//            if (userName.isEmpty()){
//                upUserName.setText("NA");
//            }else{
//                upUserName.setText(userName);
//            }
//           String schoolName =  currentUserModel.getSchoolName();
//            if (schoolName.isEmpty()){
//                upSchoolName.setText("NA");
//            }else{
//                upSchoolName.setText(schoolName);
//            }
//
//           String address =  currentUserModel.getAddress();
//            if (address.isEmpty()){
//                upAddress.setText("NA");
//            }else{
//                upAddress.setText(userName);
//            }
//           String state =  currentUserModel.getState();
//            if (state.isEmpty()){
//                upState.setText("NA");
//            }else{
//                upState.setText(state);
//            }
//            String city = currentUserModel.getCity();
//            if (city.isEmpty()){
//                upCity.setText("NA");
//            }else{
//                upCity.setText(city);
//            }
//            String email = currentUserModel.getEmilId();
//            if (email.isEmpty()){
//                upEmail.setText("NA");
//            }else{
//                upEmail.setText(email);
//            }
//            String className = currentUserModel.getClassName();
//            if (className.isEmpty()){
//                upClass.setText("NA");
//            }else{
//                upClass.setText(className);
//            }
//            String phone = currentUserModel.getPhone();
//
//            if (phone.isEmpty()){
//                upPhone.setText("NA");
//            }else{
//                upPhone.setText(phone);
//            }
//        });

    }

    void setInProgress(boolean inProgress) {
        if (inProgress){
            progressBar.setVisibility(View.VISIBLE);
            upUpdate.setVisibility(View.GONE);
        }else {
            progressBar.setVisibility(View.GONE);
            upUpdate.setVisibility(View.VISIBLE);
        }
    }


    public void imagePicker(View view,int requestCode){
        ImagePicker.with(this)
                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start(requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==10) {
            Uri uri = data.getData();
            coverImage.setImageURI(uri);
        }else {
            Uri uri = data.getData();
            profileImage.setImageURI(uri);
        }
    }


    public void updateProfileButtonClicked(View view){
        String textEmailId = upEmail.getText().toString().trim();
        String textPhone= upPhone.getText().toString().trim();
        String textClass= upClass.getText().toString().trim();

        int count = 2;
        if (!Patterns.EMAIL_ADDRESS.matcher(textEmailId).matches()) {
            upEmail.setError("Please Enter valid Email Id");
            upEmail.requestFocus();
            if (textEmailId.isEmpty()) {
                upEmail.setError("Please Enter Email Id");
                upEmail.requestFocus();
            }
            count--;
        }

        if (textPhone.isEmpty() || textPhone.length() !=10) {
            upPhone.setError("Please Enter valid Phone Number");
            upPhone.requestFocus();
                count--;
            }
        if(count==2)
        {
            //for FirebaseStore
//            currentUserModel.setEmilId(textEmailId);
//            currentUserModel.setPhone(textPhone);
//            currentUserModel.setClassName(textClass);
            setInProgress(true);
            updateUserProfile(textEmailId,textPhone,textClass);
        }
    }

    private void updateUserProfile(String textEmailId, String textPhone, String textClass) {
        setInProgress(true);
        HashMap user = new HashMap();
        user.put("userEmailId",textEmailId);
        user.put("userPhoneNo",textPhone);
        user.put("userClass",textClass);
        String userId = FirebaseAuth.getInstance().getUid().trim();
        reference = FirebaseDatabase.getInstance().getReference("User");

        reference.child(userId).updateChildren(user).addOnCompleteListener(task -> {

            if (task.isSuccessful()){
                Toast.makeText(UpdateProfileActivity.this, "User Update Profile successfully", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                Intent intent = new Intent(UpdateProfileActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(UpdateProfileActivity.this, "User Fail to Update Profile", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }


        });
    }


    //for FireBaseStore
//    void updateUserProfile(){
//        FirebaseUtils.currentUserDetails().set(currentUserModel).addOnCompleteListener(task -> {
//            setInProgress(false);
//            if (task.isSuccessful()){
//                Toast.makeText(UpdateProfileActivity.this, "User Update Profile successfully", Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
//            }
//            else{
//                Toast.makeText(UpdateProfileActivity.this, "User Fail to Update Profile", Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
//            }
//
//        });
//    }

}