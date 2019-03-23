package com.example.geoguesswipe;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



import java.util.List;

public class GeoguessAdapter extends RecyclerView.Adapter<GeoguessAdapter.GeoObjectViewHolder>{

    private List<GeoGuessObject> listGeoObject;

    GeoguessAdapter(List<GeoGuessObject> listGeoObject) {

        this.listGeoObject = listGeoObject;
    }

    class GeoObjectViewHolder extends RecyclerView.ViewHolder {




        ImageView geoImage;



        GeoObjectViewHolder(View itemView) {

            super(itemView);

            geoImage = itemView.findViewById(R.id.GeoGuessImageView);

        }

    }

    @NonNull
    @Override
    public GeoObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

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
