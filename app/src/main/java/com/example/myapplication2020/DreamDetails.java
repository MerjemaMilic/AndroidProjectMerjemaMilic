package com.example.myapplication2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

public class DreamDetails extends AppCompatActivity {
    TextView dreamContent,titleDream;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_details);

        db = FirebaseFirestore.getInstance();


        titleDream = findViewById(R.id.dreamtitledetails);
        dreamContent = findViewById(R.id.contentOfDream);

        Intent i = getIntent();
        final String title = i.getStringExtra("titleOfDream");
        final String content = i.getStringExtra("contentofDream");
        final Bundle bundle = getIntent().getExtras();

        titleDream.setText(title);
        dreamContent.setText(content);





    }


}
