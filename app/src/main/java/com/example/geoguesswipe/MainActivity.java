package com.example.geoguesswipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView GeoGuessRecyclerView = findViewById(R.id.GeoGuessRecyclerView);
    List<GeoGuessObject> mGeoObjects = new ArrayList<>();
    final String POSITIVE_MESSAGE = "Great";
    final String NEGATIVE_MESSAGE = "Wrong";
    final int YES = 1;
    final int NO = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < GeoGuessObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS.length; i++) {

            mGeoObjects.add(new GeoGuessObject(
                    GeoGuessObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i],
                    GeoGuessObject.PRE_DEFINED_GEO_OBJECT_NAMES[i],
                    GeoGuessObject.PRE_DEFINED_YES_OR_NO[i]
                   ));

        }

        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);


        GeoGuessRecyclerView.setLayoutManager(mLayoutManager);

        GeoGuessRecyclerView.setHasFixedSize(true);

        GeoguessAdapter mAdapter = new GeoguessAdapter(mGeoObjects, this);

        GeoGuessRecyclerView.setAdapter(mAdapter);





        ItemTouchHelper.SimpleCallback simpleItemtouchCallBack = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int swipeDir) {

                int position = viewHolder.getAdapterPosition();

                if (checkImage(position, swipeDir)){
                    Toast.makeText(MainActivity.this, POSITIVE_MESSAGE, Toast.LENGTH_LONG);
                } else {
                    Toast.makeText(MainActivity.this,NEGATIVE_MESSAGE, Toast.LENGTH_SHORT);
                }
            }

            public boolean checkImage(int i, int swipeDir){
                if((GeoGuessObject.PRE_DEFINED_YES_OR_NO[i] == YES && swipeDir == ItemTouchHelper.LEFT) ||
                        (GeoGuessObject.PRE_DEFINED_YES_OR_NO[i] == NO && swipeDir == ItemTouchHelper.RIGHT)){
                    return true;
                } else {
                    return false;
                }
            }
        };
    }
}








