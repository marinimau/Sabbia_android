package com.marinumau.sabbia;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.marinumau.sabbia.ui.homePageViewer.SectionsPagerAdapter;


public class HomeActivity extends SabbiaActivity {


    /**
     *
     * @param savedInstanceState the saved instances
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        super.initActionBar();
        initTabs();
        toolbar.inflateMenu(R.menu.options_menu);
    }


    /**
     *
     * @param menu the menu
     * @return a flag
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    /**
     *
     * @param item the item selected
     * @return a flag
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.navigation_settings) {
            showSettings();
            return true;
        }
        return true;
    }

    /**
     *
     */
    private void showSettings(){
        Intent myIntent = new Intent(this, Settings.class);
        startActivity(myIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    /**
     *
     */
    private void initTabs(){
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
}