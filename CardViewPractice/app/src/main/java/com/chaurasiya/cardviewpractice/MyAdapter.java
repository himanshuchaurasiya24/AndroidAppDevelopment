package com.chaurasiya.cardviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
// Variables Created
    private Context context;
    private ArrayList<MyItemList> itemList;
//Constructor
    public MyAdapter(Context context, ArrayList<MyItemList> itemList) {
        this.context = context;
        this.itemList = itemList;
    }
// View Holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView courseImage;
        private TextView courseTitle;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        courseImage= itemView.findViewById(R.id.imageViewCard);
        courseTitle = itemView.findViewById(R.id.textViewCard);
    }
}
    // Implementing Methods
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyItemList myItemList = itemList.get(position);
        holder.courseImage.setImageResource(myItemList.getImage());
        holder.courseTitle.setText(myItemList.getTitle());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
