/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia
 * Date: 03/07/2020
 */

package com.marinumau.sabbia;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.marinumau.sabbia.utils.UIConfigurationManager;


public abstract class SabbiaActivity extends AppCompatActivity {

    Toolbar toolbar;
    AppBarLayout appBarLayout;

    /**
     *
     * @param savedInstanceState the saved instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        evaluateUITheme();
    }

    /**
     *
     */
    protected void evaluateUITheme(){

        switch (UIConfigurationManager.getNightModeConfiguration(this)) {
            case Configuration.UI_MODE_NIGHT_NO:
                setTheme(R.style.LightTheme);
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                setTheme(R.style.DarkTheme);
                break;
        }
    }

    /**
     *
     */
    void initActionBar() {
        toolbar = (MaterialToolbar) findViewById(R.id.toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
        setSupportActionBar(toolbar);
    }


}
