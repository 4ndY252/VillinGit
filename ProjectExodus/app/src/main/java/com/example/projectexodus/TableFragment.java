package com.example.projectexodus;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TableFragment extends Fragment implements PlaceAdapter.OnItemSelected {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Parse JSON (Parsing raw JSON file into array of places (notice Place[].class))
        Gson gson = new Gson();
        InputStream stream = getResources().openRawResource(R.raw.data);
       Place[] places = gson.fromJson(new BufferedReader(new InputStreamReader(stream)), Place[].class);


        // Create recycler manager (way of showing views) and adapter (what views to show)
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        PlaceAdapter adapter= new PlaceAdapter(places, requireContext(), this);

        // Set recycler manager and adapter
        // Adapter automatically starts to attach place views
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPlaceSelected(Place place) {
        Toast.makeText(requireContext(), place.getAddress(), Toast.LENGTH_SHORT).show();
    }
}