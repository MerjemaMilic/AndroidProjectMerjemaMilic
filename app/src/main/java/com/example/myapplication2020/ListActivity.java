
package com.example.myapplication2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<Dream> dreamList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;

    FloatingActionButton mAddBtn;

    FirebaseFirestore db;
    CustomAdapter adapter;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        db = FirebaseFirestore.getInstance();
        mRecyclerView = findViewById(R.id.recyclerviewlist);
        mAddBtn = findViewById(R.id.addBtn);

        // set recycler view properties

        mRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        pd = new ProgressDialog(this);
        // show data in recyclerview
        showData();



        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListActivity.this, NewDream.class));
            }
        });



    }

    private void showData() {
        // progress dialog setting
        pd.setTitle("Loading data...");
        pd.show();

        db.collection("Dreams")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        pd.dismiss();
                        for(DocumentSnapshot doc: task.getResult()) {
                                Log.d("tag", doc.getId() + " => " + doc.getData());
                                task.getResult();
                               Dream dream = new Dream(doc.getString("title"), doc.getString("description"));
                            Log.d("tag", "title" + dream.getTitle());
                            dreamList.add(dream);


                        }
                       adapter = new CustomAdapter(ListActivity.this,dreamList);
                        mRecyclerView.setAdapter(adapter);


                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(ListActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
