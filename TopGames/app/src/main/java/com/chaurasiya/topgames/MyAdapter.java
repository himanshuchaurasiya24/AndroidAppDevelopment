package com.chaurasiya.topgames;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    // data
    private Context context;
    private ArrayList<ModelClass> gameList;
    // constructor
    public MyAdapter(Context context, ArrayList<ModelClass> gameList) {
        this.context = context;
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass modelClass = gameList.get(position);
        holder.gameName.setText(modelClass.getGameName());
        holder.gameImage.setImageResource(modelClass.getGameImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Choose: "+gameList.get(position).getGameName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    // view holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView gameImage;
        private TextView gameName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameImage = itemView.findViewById(R.id.imageViewCard);
            gameName = itemView.findViewById(R.id.textViewCard);
        }
    }
}
