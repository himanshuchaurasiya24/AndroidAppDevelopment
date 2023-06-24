package com.chaurasiya.worldcupapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Country> {
    private ArrayList<Country> countryArrayList;
    Context context;
    public CustomAdapter(ArrayList<Country> countryArrayList, Context context){
        super(context, R.layout.item_list_layout, countryArrayList);
        this.countryArrayList = countryArrayList;
        this.context = context;
    }
// view lookup cache
    private static class ViewHolder{
        TextView countryName , worldCupWins;
        ImageView flagImg;
}
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get item data for this position
        Country country = getItem(position);
        // check if an existing view is being reused, otherwise inflate the view ;
        ViewHolder viewHolder ;
        final View result;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_layout,
                    parent,
                    false);
            viewHolder.countryName =(TextView) convertView.findViewById(R.id.countryName);
            viewHolder.worldCupWins = (TextView) convertView.findViewById(R.id.cupWinDec);
            viewHolder.flagImg = convertView.findViewById(R.id.imageView);
            result = convertView;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        viewHolder.countryName.setText(country.getCountryName());
        viewHolder.worldCupWins.setText(country.getCupWinCount());
        viewHolder.flagImg.setImageResource(country.getFlagImage());
        return convertView;
    }
}























