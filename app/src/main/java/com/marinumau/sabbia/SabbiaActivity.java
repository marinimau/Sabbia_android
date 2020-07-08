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


public abstract class SabbiaActivity extends AppCompatActivity {

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

        Configuration configuration = new Configuration();
        configuration.setToDefaults();

        int currentNightMode = configuration.uiMode & Configuration.UI_MODE_NIGHT_MASK;

        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                setTheme(R.style.LightTheme);
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                setTheme(R.style.DarkTheme);
                break;
        }
    }


}
