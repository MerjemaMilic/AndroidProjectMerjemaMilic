package com.example.myapplication2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuestActivity extends AppCompatActivity {

    Button guestAddNewDream,guestShowDreams, guestDreamMeanings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        guestAddNewDream = findViewById(R.id.gadddreambuttonnew);
        guestShowDreams = findViewById(R.id.ghome);
        guestDreamMeanings = findViewById(R.id.gdream_meanings);

        guestAddNewDream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuestActivity.this,NewDream.class);
                startActivity(intent);
            }
        });

        guestShowDreams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuestActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });

        guestDreamMeanings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuestActivity.this,DreamMeanings.class);
                startActivity(intent);
            }
        });
    }
}
