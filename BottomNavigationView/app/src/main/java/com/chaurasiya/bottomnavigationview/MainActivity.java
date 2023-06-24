package com.chaurasiya.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnView = findViewById(R.id.bnView);
//        loadFragment(new HomeFragment(), 0);
        bnView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.nav_home){
                    loadFragment(new HomeFragment() ,1);
                } else if (id==R.id.nav_search) {
                    loadFragment(new SearchFragment(), 1);

                } else if (id== R.id.nav_contactUs) {
                    loadFragment(new ContactUsFragment(), 1);

                } else if (id==R.id.nav_utilities) {
                    loadFragment(new UtilitiesFragment(), 1);

                }else {
                    loadFragment(new MyProfileFragment(), 1);

                }
                return true;  // to show the selection of tabs at bottom;
            }
        });
        bnView.setSelectedItemId(R.id.nav_home);
        }
            public void loadFragment(Fragment fragment, int flag){
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                if(flag==0){

                    ft.add(R.id.container, fragment);

                }else {
                    ft.replace(R.id.container, fragment);
                }
                ft.commit();
    }
}