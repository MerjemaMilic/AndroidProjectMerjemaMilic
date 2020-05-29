package com.example.myapplication2020;


import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Dream> dreamList;

    public Adapter(Context context, List<Dream> dreamList){
      this.context = context;
     this.dreamList = dreamList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     Dream dream = dreamList.get(position);
     holder.dreamTitle.setText(dream.getTitle());
    holder.dreamContent.setText(dream.getDescription());


    }

    @Override
    public int getItemCount() {
        return dreamList.size();
    }

    public void notifyData(List<Dream> myList) {
        Log.d("notifyData ", myList.size() + "");
        this.dreamList = myList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
       public TextView dreamTitle, dreamContent;
        public ViewHolder (@NonNull View itemView){
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), DreamDetails.class);
             //      i.putExtra("titleofDream", dreamList.get(getAdapterPosition()));
                    i.putExtra("titleOfDream", dreamTitle.getText().toString());
                    i.putExtra("contentofDream", dreamContent.getText().toString());

                    //     i.putExtra("contentofDream",dreamList.get(getAdapterPosition()));
                    v.getContext().startActivity(i);
                }
            });

            dreamTitle = itemView.findViewById(R.id.dream_title);
            dreamContent = itemView.findViewById(R.id.dream_content);

        }
    }





}
