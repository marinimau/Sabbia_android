package com.marinumau.sabbia;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.marinumau.sabbia.utils.SoftKeyBoardManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.widget.NestedScrollView;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;

public class MainActivity extends SabbiaActivity {

    AppBarLayout appBarLayout;
    MaterialToolbar toolbar;
    NavController navController;
    BottomNavigationView navView;
    CollapsingToolbarLayout collapsingToolbarLayout;
    NestedScrollView nestedScrollView;

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
        fixBack();
    }

    /**
     *
     */
    private void initActionBar() {
        toolbar = (MaterialToolbar) findViewById(R.id.toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
        setSupportActionBar(toolbar);
    }

    /**
     *
     */
    private void initNavigation(){
        navView = findViewById(R.id.nav_view);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        toolbar = findViewById(R.id.toolbar);
        nestedScrollView = findViewById(R.id.scroll);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(collapsingToolbarLayout, toolbar, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }


    /**
     *
     */
    private void fixBack(){
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId() == R.id.navigation_search) {
                    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
                    getSupportActionBar().setDisplayShowHomeEnabled(false);
                }
                appBarLayout.setExpanded(true);
                nestedScrollView.scrollTo(0,0);
            }

        });
    }


}