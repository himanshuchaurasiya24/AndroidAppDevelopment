package com.chaurasiya.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    int fragAddFlag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenNavigation, R.string.CloseNavigation);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        loadFragment(new AFragment());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.optNotes){
                    loadFragment(new AFragment());
                } else if (id==R.id.optNewWindow) {
                    loadFragment(new BFragment());
                } else if (id == R.id.optHome){
                    loadFragment(new CFragment());
                } else if (id==R.id.optSettings) {
                    loadFragment(new DFragment());
                }else{
                    loadFragment(new EFragment());
                }
                drawerLayout.closeDrawer(GravityCompat.START);


                return true;
            }
        });

    }
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        // to pass data to fragment-->
        Bundle bundle = new Bundle();
        bundle.putString("Argument1", "Raman");
        bundle.putInt("Argument2" , 7);
        fragment.setArguments(bundle);
        //
        if(fragAddFlag==0){
            ft.add(R.id.container, fragment);
            fragAddFlag =1;
        }else
            ft.replace(R.id.container, fragment);
        ft.commit();
    }
    public void CallFragment(){
        Log.d("InActivity", "from fragment");
    }
}























