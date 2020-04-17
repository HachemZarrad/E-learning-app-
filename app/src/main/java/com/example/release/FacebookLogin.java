package com.example.release;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FacebookLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);
    }

    public void goTOGoogle(View v){
        Intent intent = new Intent(this,GoogleLogin.class);
        startActivity(intent);
    }
}
