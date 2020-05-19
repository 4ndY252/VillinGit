package com.example.projectexodus.light;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.projectexodus.R;
import com.example.projectexodus.dark.Home_dark;
import com.example.projectexodus.dark.Place;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button buttondark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_light);

        button = findViewById(R.id.button);
        button.setOnClickListener(view -> table_light());
        buttondark = findViewById(R.id.buttondark);
        buttondark.setOnClickListener(view -> openHome_dark());



    }

    public void table_light(){
        Intent intent = new Intent(this, table_light.class);
        startActivity(intent);
    }
    public void openHome_dark(){
        Intent intent = new Intent(this, Home_dark.class);
        startActivity(intent);
    }

}
