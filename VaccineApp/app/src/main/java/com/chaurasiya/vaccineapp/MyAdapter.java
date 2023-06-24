package com.chaurasiya.vaccineapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
// name inside thr adapter<is your custom view holder name>
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private VaccineModel[] listData ;
    public ItemClickListener clickListener;
    public void setClickListener(ItemClickListener clickListener){
        this.clickListener = clickListener;
    }
    public MyAdapter(VaccineModel[] listData) {
        this.listData = listData;
    }
    // implementing methods
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // it creates a new view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recycler_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(listItem);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // it displays the new data
        final VaccineModel vaccineModel = listData[position];
        holder.textView.setText(listData[position].getTitle());
        holder.imageView.setImageResource(listData[position].getImage());

    }

    @Override
    public int getItemCount() {
        return listData.length;
    }
    // View holder Class that contains layout params of custom layouts

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageView;
        public TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener != null){
                clickListener.onClick(v , getAdapterPosition());
            }
        }
    }
}
