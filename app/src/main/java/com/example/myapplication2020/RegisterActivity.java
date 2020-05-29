package com.example.myapplication2020;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Button register;
    EditText email,password,fullName;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore fStore;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        mFirebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        register = findViewById(R.id.button_register);
        email = findViewById(R.id.edittext_remail);
        password = findViewById(R.id.edittext_rpassword);
        fullName = findViewById(R.id.edittext_rfullname);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String femail = email.getText().toString();
                String fpassword = password.getText().toString();
                final String fFullName = fullName.getText().toString();
                if(femail.isEmpty()) {
                    email.setError("Please enter username");
                    email.requestFocus();
                }
                else if(fpassword.isEmpty()) {
                    password.setError("Please enter password");
                    password.requestFocus();
                }
                else if(femail.isEmpty() && fpassword.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Fields are emplty", Toast.LENGTH_SHORT).show();
                }
                else if(!(femail.isEmpty() && fpassword.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(femail,fpassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Sign in unsuccessful, Please try again", Toast.LENGTH_SHORT).show();

                            } else {
                                userID = mFirebaseAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = fStore.collection("users").document(userID);
                                Map<String,Object> user = new HashMap<>();
                                user.put("fName",fFullName);
                                user.put("email",femail);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.i("TAG", "onSuccess: user profile is created for" + userID);
                                    }
                                });
                                startActivity(new Intent(RegisterActivity.this, AddDreamActivity.class));
                            }

                        }
                    });
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Error occured!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
