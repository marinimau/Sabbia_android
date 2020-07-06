package com.marinumau.sabbia;


import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.marinumau.sabbia.utils.SoftKeyBoardManager;

import java.util.Objects;

public class SearchActive extends SabbiaActivity {

    SearchView searchView;
    Toolbar searchToolbar;

    /**
     *
     * @param savedInstanceState the saved instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_active);

        initSearchView();
        SoftKeyBoardManager.showKeyboardFrom(SearchActive.this, searchView);
    }

    /**
     *
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //SoftKeyBoardManager.hideKeyboardFrom(SearchActive.this, searchView);

    }

    /**
     *
     */
    private void initSearchView(){
        searchToolbar = (Toolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(searchToolbar);
        setTitle("");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        searchView = (SearchView) findViewById(R.id.search_widget);
        searchView.requestFocus();
    }


}