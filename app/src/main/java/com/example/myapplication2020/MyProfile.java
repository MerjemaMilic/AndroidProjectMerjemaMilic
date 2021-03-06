package com.example.myapplication2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Calendar;

public class MyProfile extends AppCompatActivity {
    EditText fullName, email;
    Button updateUserInfo, addDream;
    FirebaseUser user;
    FirebaseAuth mfirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        mfirebaseAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.mp_email);
        updateUserInfo = findViewById(R.id.update_user_button);
        addDream = findViewById(R.id.mpadd_button);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            String memail = user.getEmail();
            email.setText(memail);
        } else {
            // No user is signed in
        }

        updateUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = FirebaseAuth.getInstance().getCurrentUser();
//                String fullName1 = fullName.getText().toString();
                String email1 = email.getText().toString();

/*
                UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                       .setDisplayName(fullName1)
                      .build();
                user.updateProfile(request).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //   Toast.makeText(MyProfile.this,"Successful update",Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("TAG", "Failed:", e.getCause());
                    }
                });
                */


                user.updateEmail(email1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MyProfile.this, "Successful email update  " + user.getEmail(), Toast.LENGTH_LONG).show();


                    }
                });
            }
        });

     addDream.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(MyProfile.this, NewDream.class));

         }
     });

    }


}
