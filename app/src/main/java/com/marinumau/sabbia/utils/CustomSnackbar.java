/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.utils
 * Date: 10/07/2020
 */

package com.marinumau.sabbia.utils;

import android.content.Context;
import android.view.ViewGroup;

import androidx.core.view.ViewCompat;

import com.google.android.material.snackbar.Snackbar;
import com.marinumau.sabbia.R;

public class CustomSnackbar {

    /**
     *
     * @param context the context
     * @param snack the snackbar
     */
    public static void configSnackbar(Context context, Snackbar snack) {
        addMargins(snack);
        setRoundBordersBg(context, snack);
        ViewCompat.setElevation(snack.getView(), 6f);
    }

    /**
     *
     * @param snack the snackbar
     */
    private static void addMargins(Snackbar snack) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) snack.getView().getLayoutParams();
        params.setMargins(0, 20, 0, 0);
        snack.getView().setLayoutParams(params);
    }

    /**
     *
     * @param context the context
     * @param snackbar the background
     */
    private static void setRoundBordersBg(Context context, Snackbar snackbar) {
        snackbar.getView().setBackground(context.getDrawable(R.drawable.snackbar_bg));
    }
}
