package com.marinumau.sabbia;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.ImageView;

import com.marinumau.sabbia.logic.BeachManager.Beach;
import com.marinumau.sabbia.logic.BeachManager.BeachFactory;
import com.marinumau.sabbia.ui.detail.SectionsPagerAdapter;

import java.util.Objects;

public class BeachDetail extends SabbiaActivity {

    AppBarLayout appBarLayout;
    Toolbar toolbar;
    ImageView headerImage;


    /**
     *
     * @param savedInstanceState the saved instances
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach_detail);

        initActionBar();
        initTabs();
        setHeaderContents();

    }

    /**
     *
     */
    private void initActionBar() {
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
        toolbar = (MaterialToolbar) findViewById(R.id.toolbar);
        headerImage = (ImageView) findViewById(R.id.header_image);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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

    /**
     *
     */
    private void setHeaderContents(){
        BeachFactory beachFactory = BeachFactory.getInstance();
        Intent intent = getIntent();
        int beachId = intent.getIntExtra("beach_id", -1);

        if(beachId >= 0){
            Beach currentBeach = beachFactory.getBeachById(beachId);
            toolbar.setTitle(currentBeach.getName());
            setHeaderImage(currentBeach.getImgUrl());
        }
    }

    /**
     *
     * @param uri the header image uri
     */
    private void setHeaderImage(String uri){
        Glide.with(this)
                .load(uri)
                .centerCrop()
                .placeholder(R.drawable.img_placeholder)
                .into(headerImage);
    }
}