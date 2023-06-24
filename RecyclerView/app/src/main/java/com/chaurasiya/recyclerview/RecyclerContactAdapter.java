package com.chaurasiya.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>{
    Context context;
    ArrayList<ContactModel> arrContact;
    private int lastPosition = -1;
    public RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContact){
        this.context = context;
        this.arrContact = arrContact;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageContact.setImageResource(arrContact.get(position).image);
        holder.txtContactName.setText(arrContact.get(position).contactName);
        holder.txtContactNumber.setText(arrContact.get(position).contactNumber);
        setAnimation(holder.itemView,position);
        holder.linearLayoutRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_layout);
                EditText edtUpdateContactName = dialog.findViewById(R.id.edtAddContactName);
                EditText edtUpdateContactNumber = dialog.findViewById(R.id.edtAddContactNumber);
                TextView txtContactName = dialog.findViewById(R.id.contactName);
                Button btnUpdateContact = dialog.findViewById(R.id.btnAddContact);
                btnUpdateContact.setText("Update Contact");
                txtContactName.setText("Update Contact");
                edtUpdateContactName.setText(arrContact.get(position).contactName);
                edtUpdateContactNumber.setText(arrContact.get(position).contactNumber);
                btnUpdateContact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            String name = "";
                            String number= "";
                            int image = R.drawable.contact_img_default;
                        if(edtUpdateContactName.getText().toString().equals("")||edtUpdateContactNumber.getText().toString().equals("")){
                            Toast.makeText(context, "Please Enter All Details!",Toast.LENGTH_LONG ).show();
                        }else {
                            name = edtUpdateContactName.getText().toString();
                            number = edtUpdateContactNumber.getText().toString();
                        }
                        arrContact.set(position,new ContactModel(arrContact.get(position).image,name, number));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        holder.linearLayoutRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure want to delete this contact")
                        .setIcon(R.drawable.baseline_delete_forever_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                    arrContact.remove(position);
                                    notifyItemChanged(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.show();




                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtContactName, txtContactNumber;
        ImageView imageContact;
        LinearLayout linearLayoutRow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtContactName = itemView.findViewById(R.id.txtContactName);
            txtContactNumber = itemView.findViewById(R.id.txtContactNumber);
            imageContact =itemView.findViewById(R.id.imgContact);
            linearLayoutRow = itemView.findViewById(R.id.linearLayout);
        }
    }
    private void setAnimation(View viewToAnimate, int position){
        if(position>lastPosition){
            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.setAnimation(slideIn);
            lastPosition=position;
        }





    }
}

//public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//        }
//    }
//}
