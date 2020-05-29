package com.example.myapplication2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class NewDream extends AppCompatActivity {
    Button saveDream;
    EditText newTitle,newDescription;
     Adapter mAdapter;
    private RecyclerView mrecyclerView;
    List<Dream> dreamList;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dream);
        dreamList = new ArrayList<>();
        saveDream = findViewById(R.id.save_dream_button);
        newTitle = findViewById(R.id.new_dream_title);
        newDescription = findViewById(R.id.new_dream_description);
        LayoutInflater inflater = getLayoutInflater();
        View myView = inflater.inflate(R.layout.activity_add_dream, null);
        mrecyclerView = myView.findViewById(R.id.dreamsList);
        mAdapter = new Adapter(this, dreamList);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView.setAdapter(mAdapter);
        db = FirebaseFirestore.getInstance();

        saveDream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String title = newTitle.getText().toString();
                String desc = newDescription.getText().toString();
                Dream mLog = new Dream();
                mLog.setTitle(title);
                mLog.setDescription(desc);
                uploadData(mLog);
/*
                dreamList.add(mLog);
                mAdapter.notifyData(dreamList);
                newTitle.setText("");
                newDescription.setText("");
            Intent i = new Intent(NewDream.this,AddDreamActivity.class);
            i.putExtra("titleOfDream",mLog.getTitle());
            i.putExtra("DesriptionOfDream",mLog.getDescription());
            startActivity(i);
            */

            }
        });
    }

    private void uploadData(Dream dream) {
        String id = UUID.randomUUID().toString();
        Map<String,Object> dreamtable = new HashMap<>();
        dreamtable.put("id",id);
        dreamtable.put("Dream", dream);
        db.collection("Dreams").document(id).set(dreamtable)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(NewDream.this, "Dream uploaded succesfully",Toast.LENGTH_SHORT);

                    }

                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(NewDream.this, "Dream didn't upload",Toast.LENGTH_SHORT);

            }
        });


    }
}
