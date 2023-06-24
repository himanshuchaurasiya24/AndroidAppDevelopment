package com.chaurasiya.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tab = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);
        ViewPagerMessengerAdapter viewPagerMessengerAdapter = new ViewPagerMessengerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerMessengerAdapter);
        tab.setupWithViewPager(viewPager);
    }
}