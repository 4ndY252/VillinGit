package com.example.projectexodus;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFragment extends Fragment {

    private Place[] places;
    private List<Place> placesToShow = new ArrayList<>();
    private PlaceAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        SearchView searchView = view.findViewById(R.id.search);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        Gson gson = new Gson();
        InputStream stream = getResources().openRawResource(R.raw.data);
        places = gson.fromJson(new BufferedReader(new InputStreamReader(stream)), Place[].class);

        adapter = new PlaceAdapter(places, requireContext(), place -> {
            Toast.makeText(requireContext(), place.getAddress(), Toast.LENGTH_SHORT).show();
        });


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                search(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                search(s);
                return false;
            }
        });
    }

    private void search(String searchText){
        String regex = ".*" + searchText + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        placesToShow = new ArrayList<>();
        for (Place place : places) {
            Matcher matcher = pattern.matcher(place.getName());
            if (matcher.matches()){
                placesToShow.add(place);
            }else {
                matcher = pattern.matcher(place.getAddress());
                if (matcher.matches()){
                    placesToShow.add(place);
                }
            }
        }
        adapter.setItems(placesToShow);
    }
}