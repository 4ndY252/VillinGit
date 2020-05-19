package com.example.projectexodus.dark;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projectexodus.R;


import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class table_dark extends AppCompatActivity implements PlaceAdapter.OnItemSelected {
    private Button search;
    private Button maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_dark);


        search = findViewById(R.id.search);
        search.setOnClickListener(view -> openSearch());

        maps = findViewById(R.id.maps);
        maps.setOnClickListener(view -> openMaps());

        // Parse JSON (Parsing raw JSON file into array of places (notice Place[].class))
        Gson gson = new Gson();
        InputStream stream = getResources().openRawResource(R.raw.data);
        Place[] places = gson.fromJson(new BufferedReader(new InputStreamReader(stream)), Place[].class);


        // Create recycler manager (way of showing views) and adapter (what views to show)
        RecyclerView recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        PlaceAdapter adapter = new PlaceAdapter(places, this, this);

        // Set recycler manager and adapter
        // Adapter automatically starts to attach place views
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }




       /* File file = new File("data.json");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        for(int i = 0; i < 4933; i++){
            String data = reader.readLine();
            String [] nazov = data.split(": ");

            if (nazov[0].trim().equals("\"Názov\"")){
                String data2 = reader.readLine();
                String [] skupina = data2.split(": ");

                if (skupina[1].trim().equals("\"Fontány a pramene\",") || skupina[1].trim().equals("\"Investície mesta\",")) {

                    //System.out.println("Nazov: " + nazov[1]);
                    textView.setText("Nazov: " + nazov[1]);
                    String [] adresa;
                    do {
                        String data3 = reader.readLine();
                        adresa = data3.split(": ");

                    }while(!adresa[0].trim().equals("\"Adresa\""));

                    //System.out.println("Adresa: " + adresa[1]);
                    textView.setText("Adresa: " + adresa[1]);
                }
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        } */

       // Interface call... Adapter calls this method on click of a place view...
       @Override
       public void onPlaceSelected(Place place) {
           Log.d("PLACE SELECTED: ", place.toString());
       }

    public void openSearch() {
        Intent intent = new Intent(this, search_dark.class);
        startActivity(intent);
    }

    public void openMaps() {
        Intent intent = new Intent(this, maps_dark.class);
        startActivity(intent);
    }

}