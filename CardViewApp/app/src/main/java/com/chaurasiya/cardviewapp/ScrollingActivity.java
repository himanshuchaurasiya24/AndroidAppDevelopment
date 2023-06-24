package com.chaurasiya.cardviewapp;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.chaurasiya.cardviewapp.databinding.ActivityScrollingBinding;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {
    // Step 1 Declaring some variables
    private List<AppsModel> appsList;
    private AppsAdapter adapter;
    private RecyclerView recyclerView;


    private ActivityScrollingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // recycler View widget;
        recyclerView = findViewById(R.id.recyclerView);
        appsList = new ArrayList<>();
        adapter = new AppsAdapter(appsList, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        // Item decoration;
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,dpToPx(10),true  ));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        insertDataIntoCard();
    }

    private void insertDataIntoCard() {
        // Add card data and display them
        int [] appCovers = new int[]{
                R.drawable.masterandroid, R.drawable.masterpro, R.drawable.youtube, R.drawable.loggo, R.drawable.app2, R.drawable.app3
        };
        AppsModel a = new AppsModel("Master android app", 8000, appCovers[0]);
        appsList.add(a);
        a = new AppsModel("Master android pro", 8500, appCovers[1]);
        appsList.add(a);
        a = new AppsModel("Master kotlin", 4500, appCovers[2]);
        appsList.add(a);
        a = new AppsModel("Master youtube", 4000, appCovers[3]);
        appsList.add(a);
        a = new AppsModel("Loggo", 1000, appCovers[4]);
        appsList.add(a);
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spaceCount, int spacing, boolean includeEdge) {
            this.spanCount = spaceCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

            int position = parent.getChildAdapterPosition(view);
            int coloumn = position%spanCount;
            if(includeEdge){
                outRect.left = spacing - coloumn * spacing/ spanCount;
                outRect.right = (coloumn +1)*spacing/spanCount;
                if(position<spanCount){
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            }else {
                outRect.left = coloumn *spacing/spanCount;
                outRect.right = spacing-(coloumn+1)*spacing/spanCount;
                if(position>= spanCount){
                    outRect.top = spacing;
                }
            }
        }
    }
    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}































