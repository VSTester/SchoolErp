package com.krish.schoolerp;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class UpdateProfileActivity extends AppCompatActivity {

    ImageView coverImage,profileImage;
    FloatingActionButton coverImageBtn, profileImageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        coverImage = (ImageView) findViewById(R.id.imgCoverImage);
        profileImage = (ImageView) findViewById(R.id.imgProfileImage);
        coverImageBtn = (FloatingActionButton) findViewById(R.id.floatingButtonCoverProfile);
        profileImageBtn = (FloatingActionButton) findViewById(R.id.floatingButtonProfile);
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
}