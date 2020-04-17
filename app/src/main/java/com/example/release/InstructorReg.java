package com.example.release;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class InstructorReg extends AppCompatActivity {

    EditText emailId, password, userName, phoneNumber, city, speciality;
    Button btnSignUp;
    FirebaseAuth mFirebaseAuth;
    TextView tvSignIn;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_reg);


        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        final String id = mDatabase.push().getKey();

        mFirebaseAuth = FirebaseAuth.getInstance();
        userName = findViewById(R.id.editText1);
        phoneNumber = findViewById(R.id.editText4);
        city = findViewById(R.id.editText5);
        emailId = findViewById(R.id.editText2);
        password = findViewById(R.id.editText3);
        speciality = findViewById(R.id.editText6);
        btnSignUp = findViewById(R.id.button3);
        tvSignIn = findViewById(R.id.textView);

        final String email = emailId.getText().toString().trim();
        final String pwd = password.getText().toString().trim();
        final String phone = phoneNumber.getText().toString().trim();
        final String City = city.getText().toString().trim();
        final String user = userName.getText().toString().trim();
        final String Speciality = speciality.getText().toString().trim();


    }

    public void onClick(View v) {


        //mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(InstructorReg.this, new OnCompleteListener<AuthResult>() {
                        /*@Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(InstructorReg.this,"SignUp Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Instructor instructor = new Instructor(id,user,phone,City,email,Speciality);
                                mDatabase.child(id).setValue(instructor);*/
        Intent intent = new Intent(InstructorReg.this, InstructorRegCVV.class);
        startActivity(intent);
    }

}







