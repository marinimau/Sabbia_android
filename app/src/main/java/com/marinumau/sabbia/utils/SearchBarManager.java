/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.utils
 * Date: 04/07/2020
 */

package com.marinumau.sabbia.utils;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Objects;

public class SearchBarManager {

    /**
     *
     * @param activity the calling activity
     */
    public static void hideActionBar(Activity activity){
        if(((AppCompatActivity)activity).getSupportActionBar() != null){
            Objects.requireNonNull(((AppCompatActivity) activity).getSupportActionBar()).hide();
        }
    }

    /**
     *
     * @param activity the calling activity
     */
    public static void showActionBar(Activity activity){
        if(((AppCompatActivity)activity).getSupportActionBar() != null){
            Objects.requireNonNull(((AppCompatActivity) activity).getSupportActionBar()).show();
        }
    }
}
