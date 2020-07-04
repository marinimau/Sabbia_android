/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.utils
 * Date: 04/07/2020
 */

package com.marinumau.sabbia.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


public class SoftKeyBoardManager {

    /**
     *
     * @param context the calling activity context
     * @param view the calling activity view
     */
    public static void showKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.toggleSoftInputFromWindow(
                view.getApplicationWindowToken(),
                InputMethodManager.SHOW_FORCED, 0);
    }

    /**
     *
     * @param context the calling activity context
     * @param view the calling activity view
     */
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}
