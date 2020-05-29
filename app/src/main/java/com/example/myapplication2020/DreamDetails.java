package com.example.myapplication2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DreamDetails extends AppCompatActivity {
    TextView dreamContent,titleDream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_details);
        titleDream = findViewById(R.id.dreamtitledetails);
        dreamContent = findViewById(R.id.contentOfDream);
        Intent i = getIntent();
        String title = i.getStringExtra("titleOfDream");
        String content = i.getStringExtra("contentofDream");
        titleDream.setText(title);
        dreamContent.setText(content);
         dreamContent.setMovementMethod(new ScrollingMovementMethod());




    }
}
