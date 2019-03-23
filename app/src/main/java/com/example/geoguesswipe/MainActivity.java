package com.example.geoguesswipe;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<GeoGuessObject> mGeoObjects;
    final int YES = 1;
    final int NO = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView geoGuessRecyclerView = findViewById(R.id.GeoGuessRecyclerView);
        mGeoObjects = new ArrayList<>();


        for (int i = 0; i < GeoGuessObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS.length; i++) {

            mGeoObjects.add(new GeoGuessObject(
                    GeoGuessObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i],
                    GeoGuessObject.PRE_DEFINED_GEO_OBJECT_NAMES[i],
                    GeoGuessObject.PRE_DEFINED_YES_OR_NO[i]
            ));

        }

        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);


        geoGuessRecyclerView.setLayoutManager(mLayoutManager);

        geoGuessRecyclerView.setHasFixedSize(true);

        final GeoguessAdapter mAdapter = new GeoguessAdapter(mGeoObjects);

        geoGuessRecyclerView.setAdapter(mAdapter);
        final GestureDetector mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener()) {

            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        };



        geoGuessRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                int mAdapterPosition = rv.getChildAdapterPosition(child);

                if (child != null && mGestureDetector.onTouchEvent(e)) {
                    showCountry(mAdapterPosition);
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });


        final ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int swipeDir) {

                int position = viewHolder.getAdapterPosition();

                if (checkImage(position, swipeDir)) {
                    greatToast();
                } else {
                    wrongToast();
                }
                mGeoObjects.remove(position);
                mAdapter.notifyItemRemoved(position);
            }


        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(geoGuessRecyclerView);
    }

    public boolean checkImage(int position, int swipeDir) {
        GeoGuessObject geo = mGeoObjects.get(position);
        return (geo.getYesOrNo() == YES && swipeDir == ItemTouchHelper.LEFT) ||
                (geo.getYesOrNo() == NO && swipeDir == ItemTouchHelper.RIGHT);
    }

    public void greatToast() {
        Toast.makeText(MainActivity.this, R.string.great, Toast.LENGTH_LONG).show();

    }

    public void wrongToast() {
        Toast.makeText(MainActivity.this, R.string.wrong, Toast.LENGTH_SHORT).show();
    }

    public void showCountry(int position) {
        Toast.makeText(MainActivity.this, GeoGuessObject.PRE_DEFINED_GEO_OBJECT_NAMES[position]
                , Toast.LENGTH_SHORT).show();
    }
}








