package com.marinumau.sabbia;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;

public class MainActivity extends SabbiaActivity {

    MaterialToolbar toolbar;
    MaterialToolbar searchToolbar;
    NavController navController;
    BottomNavigationView navView;

    /**
     *
     * @param savedInstanceState the saved instances
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActionBar();
        initNavigation();
        evaluateToolbar();
    }

    /**
     *
     */
    private void initActionBar() {
        toolbar = (MaterialToolbar) findViewById(R.id.toolbar);
        searchToolbar = (MaterialToolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     *
     */
    private void initNavigation(){
        navView = findViewById(R.id.nav_view);
        CollapsingToolbarLayout layout = findViewById(R.id.collapsing_toolbar_layout);
        toolbar = findViewById(R.id.toolbar);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(layout, toolbar, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }


    private void evaluateToolbar(){
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId() == R.id.navigation_search) {
                    toolbar.setVisibility(View.GONE);
                    Objects.requireNonNull(getSupportActionBar()).setTitle("");
                    searchToolbar.setVisibility(View.VISIBLE);
                } else {
                    toolbar.setVisibility(View.VISIBLE);
                    searchToolbar.setVisibility(View.GONE);
                }
            }

        });


    }



}