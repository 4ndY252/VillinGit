package com.example.projectexodus.dark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectexodus.R;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceViewHolder> {

    private Place[] places;             // What items to show
    private Context context;            // Context used to inflate views.. (create their layout)
    private OnItemSelected listener;    // Interface listener which is used when user clicks on a place view

    // Constructor requiring all values mentioned above
    PlaceAdapter(Place[] places, Context context, OnItemSelected listener) {
        this.places = places;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This method gets called when adapter is creating place views
        // Note that the view does not contain any values from places yet... (it just creates a layout)
        // using LayoutInflater class
        return new PlaceViewHolder(LayoutInflater.from(context).inflate(R.layout.place_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        // This method is called when views are created and ready to attach values to... (in our case Place class)
        // So, we just set the place to a view at position... values are handled in PlaceViewHolder class not in adapter
        holder.setPlace(places[position]);
        // This line is basically just setting an onClickListener so we know when user selected a Place
        // It calls method onPlaceSelected with parameter of place[position] (place user had chosen)
        holder.itemView.setOnClickListener(view -> listener.onPlaceSelected(places[position]));
    }

    @Override
    public int getItemCount() {
        // This method represents just how many views should adapter create...
        // In our case we use all places
        return places.length;
    }

    // This interface is for letting the activity know what place user chose
    interface OnItemSelected{
        void onPlaceSelected(Place place);
    }
}
