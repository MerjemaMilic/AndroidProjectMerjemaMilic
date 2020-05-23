package com.example.myapplication2020;

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
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText loginemail;
    EditText loginpassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFirebaseAuth = FirebaseAuth.getInstance();

        loginemail = (EditText) findViewById(R.id.edittext_username);
        loginpassword = (EditText) findViewById(R.id.edittext_password);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mTextViewRegister = (TextView) findViewById(R.id.textview_register);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(v.getContext(), RegisterActivity.class);
                v.getContext().startActivity(registerIntent);
            }
        });

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();

                if( mFirebaseUser != null) {
                    Toast.makeText(LoginActivity.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Please login", Toast.LENGTH_SHORT).show();

                }

            }
        };

    mButtonLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String femail = loginemail.getText().toString();
            String fpassword = loginpassword.getText().toString();
            if(femail.isEmpty()) {
                loginemail.setError("Please enter username");
                loginemail.requestFocus();
            }
            else if(fpassword.isEmpty()) {
                loginpassword.setError("Please enter password");
                loginpassword.requestFocus();
            }
            else if(femail.isEmpty() && fpassword.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Fields are emplty", Toast.LENGTH_SHORT).show();
            }
            else if(!(femail.isEmpty() && fpassword.isEmpty())) {
                mFirebaseAuth.signInWithEmailAndPassword(femail, fpassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login Error, please login again", Toast.LENGTH_SHORT).show();

                        } else {
                            Intent intToHome = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intToHome);
                        }
                    }


                });
            }

            else{
                Toast.makeText(LoginActivity.this, "Error occured!", Toast.LENGTH_SHORT).show();

            }

        }
    });




    }

    public void openRegisterActivity(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

}