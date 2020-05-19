package com.example.projectexodus.dark;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectexodus.R;

/**
 * PlaceViewHolder class
 * Class which loads and shows data on screen
 * One PlaceViewHolder represents one Place
 */
class PlaceViewHolder extends RecyclerView.ViewHolder {

    private TextView title;

    // Constructor used to make the layout and get views from it
    PlaceViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
    }

    // Method which gets called when view is ready to show data
    // In here you can process all values from Place object
    // We just show name of place...
    void setPlace(Place place){
        title.setText(place.getName());
    }
}
