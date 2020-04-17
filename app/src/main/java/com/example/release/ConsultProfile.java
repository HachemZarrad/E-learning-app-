package com.example.release;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

public class ConsultProfile extends AppCompatActivity {

    CircleImageView tofProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_profile);
        tofProfile = findViewById(R.id.imageView11);
        //tofProfile.setImageBitmap();
    }

    public void call(View view){
        Intent intent = new Intent(this,PhoneCall.class);
        startActivity(intent);
    }

    public void email(View view){
        Intent intent = new Intent(this,Email.class);
        startActivity(intent);
    }
}
