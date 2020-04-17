package com.example.release;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentReg extends AppCompatActivity {

    EditText emailId, password,userName,phoneNumber,city;
    Button btnSignUp , googleSignIN;
    FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg);

        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        final String id = mDatabase.push().getKey();

        mFirebaseAuth = FirebaseAuth.getInstance();
        userName = findViewById(R.id.editText1);
        phoneNumber = findViewById(R.id.editText4);
        city = findViewById(R.id.editText5);
        emailId = findViewById(R.id.editText2);
        password = findViewById(R.id.editText3);
        btnSignUp = findViewById(R.id.button3);
        googleSignIN = findViewById(R.id.button);




        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailId.getText().toString().trim();
                final String pwd = password.getText().toString().trim();
                final String phone = phoneNumber.getText().toString().trim();
                final String City = city.getText().toString().trim();
                final String user = userName.getText().toString().trim();

                if(email.isEmpty()){
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(StudentReg.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty() && user.isEmpty() && phone.isEmpty() && City.isEmpty()) ){

                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(StudentReg.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(StudentReg.this,"SignUp Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                            else {

                                Student student = new Student(id,user,phone,City,email);
                                mDatabase.child(id).setValue(student);


                                Intent intent = new Intent(StudentReg.this,NavigationDrawerForStudent.class);
                                intent.putExtra("id",id);
                                startActivity(intent);

                            }
                        }
                    });
                }
                else{
                    Toast.makeText(StudentReg.this,"Error Occurred! or one of the fields is empty",Toast.LENGTH_SHORT).show();

                }
            }
        });

        googleSignIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentReg.this, GoogleLogin.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }

    public void facebookLog(View v){
        Intent intent = new Intent(this, FacebookLogin.class);
        startActivity(intent);
    }




}
