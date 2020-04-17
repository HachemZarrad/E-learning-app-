package com.example.release;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class InstructorProfile extends AppCompatActivity {

    private CircleImageView ProfileImage;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;
    EditText t1,t2,t4,t5,t6;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_profile);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        t1 = findViewById(R.id.editText1);
        t2 = findViewById(R.id.editText2);
        t4 = findViewById(R.id.editText4);
        t5 = findViewById(R.id.editText5);
        t6 = findViewById(R.id.editText6);

        ProfileImage = (CircleImageView) findViewById(R.id.imageView11);
        ProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery, "Select Picture"), PICK_IMAGE);
            }
        });
    }

    public void alter(View v){

        final String user = t1.getText().toString().trim();
        final String email = t2.getText().toString().trim();
        final String phoneNumber = t4.getText().toString().trim();
        final String country = t5.getText().toString().trim();
        final String speciality = t6.getText().toString().trim();
        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        final String id = mDatabase.push().getKey();

                mDatabase.child(id).getRef().child("name").setValue(user);
                mDatabase.child(id).getRef().child("email").setValue(email);
                mDatabase.child(id).getRef().child("country").setValue(country);
                mDatabase.child(id).getRef().child("phoneNumber").setValue(phoneNumber);
                mDatabase.child(id).getRef().child("speciality").setValue(speciality);
        Toast.makeText(InstructorProfile.this,"Data updated",Toast.LENGTH_SHORT).show();
            }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                ProfileImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(this, MainActivity.class);
                startActivity(intToMain);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
