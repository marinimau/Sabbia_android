package com.marinumau.sabbia;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.marinumau.sabbia.utils.SoftKeyBoardManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;

import static androidx.core.content.ContextCompat.getSystemService;

public class MainActivity extends SabbiaActivity {

    MaterialToolbar toolbar;
    MaterialToolbar searchToolbar;
    NavController navController;
    BottomNavigationView navView;
    CollapsingToolbarLayout collapsingToolbarLayout;
    SearchView searchView;

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
        searchView = (SearchView) findViewById(R.id.search_widget);
        setSupportActionBar(toolbar);
    }

    /**
     *
     */
    private void initNavigation(){
        navView = findViewById(R.id.nav_view);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        toolbar = findViewById(R.id.toolbar);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(collapsingToolbarLayout, toolbar, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }


    /**
     *
     */
    private void evaluateToolbar(){
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId() == R.id.navigation_search) {
                    toolbar.setVisibility(View.GONE);
                    searchToolbar.setVisibility(View.VISIBLE);
                    collapsingToolbarLayout.setTitle("");
                    SoftKeyBoardManager.showKeyboardFrom(MainActivity.this, searchToolbar);
                    searchView.requestFocus();
                    Objects.requireNonNull(getSupportActionBar()).setTitle("");
                } else {
                    toolbar.setVisibility(View.VISIBLE);
                    searchToolbar.setVisibility(View.GONE);
                    SoftKeyBoardManager.hideKeyboardFrom(MainActivity.this, searchToolbar);
                }
            }

        });
    }


}