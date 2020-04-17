package com.example.release;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void instructorReg(View v){
        Intent intent = new Intent(this, InstructorReg.class);
        startActivity(intent);

    }
    public void studentReg(View v){
        Intent intent = new Intent(this, StudentReg.class);
        startActivity(intent);
    }
    public void loginThen(View view){
        Intent intent = new Intent(this, GoogleLogin.class);
        startActivity(intent);
    }

}
