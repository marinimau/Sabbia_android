/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.utils
 * Date: 10/07/2020
 */

package com.marinumau.sabbia.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.marinumau.sabbia.R;
import com.marinumau.sabbia.logic.BeachManager.Beach;

public class AlertManager {

    /**
     *
     * @param activity the calling activity
     * @param context the calling context
     * @param message the text to print in the snackbar
     */
    public static void showSnackBarSimple(Activity activity, Context context, String message) {
        View parentLayout = activity.findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(parentLayout, message, Snackbar.LENGTH_LONG);
        CustomSnackbar.configSnackbar(context, snackbar);
        snackbar.getView().findViewById(R.id.snackbar_text).setBackgroundColor(Color.TRANSPARENT);
        TextView tv = (TextView) snackbar.getView().findViewById(R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        snackbar.show();
    }

    /**
     *
     * @param activity the calling activity
     * @param context the calling context
     * @param beach the currentBeach
     */
    public static void stopBeachPermanenceDialog(final Activity activity, final Context context, Beach beach){
        final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(context);
        @SuppressLint("InflateParams") View sheetView = activity.getLayoutInflater().inflate(R.layout.bottomsheet_interrupt_permanence, null);
        mBottomSheetDialog.setContentView(sheetView);
        mBottomSheetDialog.show();

        Button confirm = (Button) sheetView.findViewById(R.id.btn_confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mBottomSheetDialog.dismiss();
               showSnackBarSimple(activity, context, "Confirm pressed");
            }
        });
    }
}
