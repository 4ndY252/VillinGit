package com.example.projectexodus;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    boolean initialized = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavHostFragment host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        NavigationUI.setupWithNavController(bottomNavigationView, host.getNavController());

        host.getNavController().addOnDestinationChangedListener((controller, destination, arguments) -> {
            if(initialized)
                bottomNavigationView.setVisibility(View.VISIBLE);
            else
                initialized = true;
        });
    }
}
