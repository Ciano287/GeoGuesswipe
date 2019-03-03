package com.example.geoguesswipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GeoguessAdapter extends RecyclerView.Adapter<GeoguessAdapter.GeoObjectViewHolder>{
   // private ArrayList<String> mImageName = new ArrayList<>();
   // private ArrayList<String> mImages = new ArrayList<>();
        private Context context;
        private List<GeoGuessObject> listGeoObject;

    public GeoguessAdapter(List<GeoGuessObject> listGeoObject, Context context) {
      //  this.mImageName = mImageName;
      //  this.mImages = mImages;
        this.context = context;
        this.listGeoObject = listGeoObject;
    }

    public class GeoObjectViewHolder extends RecyclerView.ViewHolder {


        public TextView geoText;

        public ImageView geoImage;

        public View view;


        public GeoObjectViewHolder(View itemView) {

            super(itemView);

            geoImage = itemView.findViewById(R.id.GeoGuessImageView);

        }

    }

    public GeoObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);

        return new GeoObjectViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull GeoObjectViewHolder holder, final int position) {
        // Gets a single item in the list from its position

        final GeoGuessObject geoObject = listGeoObject.get(position);

        // The holder argument is used to reference the views inside the viewHolder

        // Populate the views with the data from the list

        holder.geoImage.setImageResource(geoObject.getGeoImageName());

    }

    @Override
    public int getItemCount() {
        return listGeoObject.size();
    }


}
