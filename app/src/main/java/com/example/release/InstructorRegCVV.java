package com.example.release;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InstructorRegCVV extends AppCompatActivity {

    EditText CardNumber,ExpirationDate,Cvv;
    Button save;
    FirebaseAuth mFirebaseAuth;
    TextView tvSignIn;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_reg_cvv);

        mDatabase = FirebaseDatabase.getInstance().getReference("cards");
        mFirebaseAuth = FirebaseAuth.getInstance();
        CardNumber = findViewById(R.id.editText6);
        ExpirationDate = findViewById(R.id.editText7);
        Cvv = findViewById(R.id.editText8);
        save = findViewById(R.id.button3);
        tvSignIn = findViewById(R.id.textView);

        Intent intent =getIntent();
        final String id = intent.getStringExtra("insId");
        final String owner = intent.getStringExtra("owner");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cardNumber = CardNumber.getText().toString().trim();
                String expirationDate = ExpirationDate.getText().toString().trim();
                String cvv = Cvv.getText().toString().trim();


                 if (cardNumber.isEmpty()) {
                    CardNumber.setError("Please enter your password");
                    CardNumber.requestFocus();
                } else if (expirationDate.isEmpty() && cardNumber.isEmpty()) {
                    Toast.makeText(InstructorRegCVV.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(cardNumber.isEmpty() && expirationDate.isEmpty() && cvv.isEmpty())) {

                    Cards cards = new Cards(cvv,expirationDate,cardNumber,owner);
                   // mDatabase.child(id).setValue(cards);
                     Intent intent = new Intent(InstructorRegCVV.this, NavigationDrawerForInstructor.class);
                    // intent.putExtra("insId2",id);
                     startActivity(intent);


                    tvSignIn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(InstructorRegCVV.this, InstructorLog.class);
                            i.putExtra("insIdLog2",id);
                            startActivity(i);
                        }
                    });
                }

            }
        });
    }
}