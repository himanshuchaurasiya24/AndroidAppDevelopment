package com.chaurasiya.navigationdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BFragment extends Fragment {
    private static final String ARG1 = "Argument1";
    private static final String ARG2 = "Argument2";
    // Second method
    public static BFragment getInstance(String val1, int val2){
        BFragment bFragment = new BFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG1 , val1);
        bundle.putInt(ARG2, val2);
        bFragment.setArguments(bundle);
        return bFragment;
    }
    // second method


    public BFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(getArguments()!=null){
            // first method
//            String name = getArguments().getString("Argument1");
//            int number = getArguments().getInt("Argument2");
//            Log.d("values from the bundle is ", "name is "+name+ " Roll number is "+number);
            // first method
// second method
            String name = getArguments().getString(ARG1);
            int number = getArguments().getInt(ARG2);
            Log.d("Value of these are: ", "Your name is "+name +" your roll number is "+number);
            // to pass data from another activity;
            ((MainActivity)getActivity()).CallFragment();
// second method
        }
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        return v;
    }
}