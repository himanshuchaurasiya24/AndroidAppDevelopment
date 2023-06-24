package com.chaurasiya.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NonNls;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    // Creating Variables
    private Context context;
    private ArrayList<CourseModel> courseModelArrayList;
    // Constructor

    public MyAdapter(Context context, ArrayList<CourseModel> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }
    // View Holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView courseImage;
        private TextView courseTitle;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            courseImage = itemView.findViewById(R.id.imageViewCard);
            courseTitle = itemView.findViewById(R.id.textViewCard);
        }
    }
    // Implementing Methods
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CourseModel model = courseModelArrayList.get(position);
        holder.courseTitle.setText(model.getCourseTitle());
        holder.courseImage.setImageResource(model.getCourseImage());
    }

    @Override
    public int getItemCount() {
        return courseModelArrayList.size();
    }
}





















