package com.example.myapplication2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class NewDream extends AppCompatActivity {
    Button saveDream, btnList;
    public EditText newTitle, newDescription;
    private RecyclerView mrecyclerView;
    public List<Dream> dreamList;
    FirebaseFirestore db;
    public String id;
    String updateID, updateTitle, updateDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dream);

        saveDream = findViewById(R.id.save_dream_button);
        newTitle = findViewById(R.id.new_dream_title);
        newDescription = findViewById(R.id.new_dream_description);
        btnList = findViewById(R.id.show_list_newdream);

        dreamList = new ArrayList<>();

        final Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            saveDream.setText("Update");
            updateID = bundle.getString("updateId");
            updateTitle = bundle.getString("updateT");
            updateDescription = bundle.getString("updateD");
            newTitle.setText(updateTitle);
            newDescription.setText(updateDescription);
        } else {
            saveDream.setText("Save");
        }

        db = FirebaseFirestore.getInstance();

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewDream.this, ListActivity.class));
                finish();
            }
        });

        saveDream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = getIntent().getExtras();
                if (bundle1 != null) {
                    //update
                    String id = updateID;
                    String title = newTitle.getText().toString().trim();
                    String desc = newDescription.getText().toString().trim();
                    updateData(id, title, desc);
                } else {
                    //add new
                    String title = newTitle.getText().toString().trim();
                    String desc = newDescription.getText().toString().trim();
                    uploadData(title, desc);
                }


            }
        });

    }

    public void uploadData(String title, String description) {
        id = UUID.randomUUID().toString();
        Map<String, Object> doc = new HashMap<>();
        doc.put("id", id);
        doc.put("title", title);
        doc.put("description", description);

        db.collection("Dreams").document(id).set(doc).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d("tag", "DocumentSnapshot added with ID: ");
                Toast.makeText(NewDream.this, "Dream uploaded succesfully", Toast.LENGTH_SHORT);

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(NewDream.this, "Dream didn't upload", Toast.LENGTH_SHORT);

                    }
                });


    }

    private void updateData(String id1, String title1, String description1) {
        db.collection("Dreams")
                .document(id1)
                .update("title", title1, "description", description1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(NewDream.this, "Updated successfully", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(NewDream.this, "Update failed", Toast.LENGTH_LONG).show();

            }
        });
    }


}
