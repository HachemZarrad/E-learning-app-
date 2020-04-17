package com.example.release;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class PayingCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paying_course);
    }

    public void enroll(View v){
        Intent openCourse = new Intent(this,Pdf.class);
        startActivity(openCourse);
    }

    public void toFav(View v){
        Toast.makeText(this,"Course added to your favorite list",Toast.LENGTH_SHORT).show();
        Intent fav = new Intent(PayingCourse.this,Favorite.class);
        startActivity(fav);
    }

    public void consult(View view){
        Intent i = new Intent(PayingCourse.this,ConsultProfile.class);
        startActivity(i);
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
