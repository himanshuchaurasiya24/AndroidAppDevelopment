package com.chaurasiya.cardviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.MyViewHolder> {
    private List<AppsModel> appList;
    private Context context;
    //Step 1
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, appDownload;
        public ImageView thumbnail;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        appDownload = itemView.findViewById(R.id.count);
        thumbnail = itemView.findViewById(R.id.thumbnail);

    }
}
// Step 2
// Creating variables & constructors
    public AppsAdapter(List<AppsModel> appList, Context context) {
        this.appList = appList;
        this.context = context;
    }
// Implementing Methods
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_app, parent, false);
        return new MyViewHolder(itemView);
    }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            AppsModel appsModel = appList.get(position);
            holder.title.setText(appsModel.getName());
            holder.appDownload.setText(appsModel.getNumberOfDownload()+" users");
            holder.thumbnail.setImageResource(appsModel.getThumbnails());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context.getApplicationContext(), "You clicked "+appsModel.getName(), Toast.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return appList.size();
        }























}
