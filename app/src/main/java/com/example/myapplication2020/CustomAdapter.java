package com.example.myapplication2020;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {
    ListActivity listActivity;
   public List<Dream> dreamsList;
    Context context;

    public CustomAdapter(ListActivity listActivity, List<Dream> dreamsList) {
        this.listActivity = listActivity;
        this.dreamsList = dreamsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate layout
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view,parent,false);
      ViewHolder viewHolder = new ViewHolder(itemView);
        // handle item clicks
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // called when user clicks item
                String title = dreamsList.get(position).getTitle();
                String description = dreamsList.get(position).getDescription();
                Intent i = new Intent(view.getContext(), DreamDetails.class);
                //      i.putExtra("titleofDream", dreamList.get(getAdapterPosition()));
                i.putExtra("titleOfDream", title);
                i.putExtra("contentofDream", description);

                //     i.putExtra("contentofDream",dreamList.get(getAdapterPosition()));
                view.getContext().startActivity(i);
              //  Toast.makeText(context, title+"\n"+title, Toast.LENGTH_SHORT).show();
                Log.d("tag",title);
            }

            @Override
            public void onItemLongClick(View view, final int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(listActivity);
                String[] options = {"Update", "Delete"};
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which == 0) {
                            String id = dreamsList.get(position).getId();
                            Log.d("tag","id" + id);
                            String title = dreamsList.get(position).getTitle();
                            Log.d("TITLE","title" + title);
                            String description = dreamsList.get(position).getDescription();

                            Intent intent = new Intent(listActivity,NewDream.class);
                            intent.putExtra("updateId",id);
                            intent.putExtra("updateT",title);
                            intent.putExtra("updateD",description);
                            listActivity.startActivity(intent);

                        }
                        if(which == 1) {
                            listActivity.deleteData(position);
                        }
                    }
                }).create().show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind views / set data
         holder.mTitle.setText(dreamsList.get(position).getTitle());
        holder.mDescription.setText(dreamsList.get(position).getDescription());



    }

    @Override
    public int getItemCount() {
        return dreamsList.size();
    }


}


