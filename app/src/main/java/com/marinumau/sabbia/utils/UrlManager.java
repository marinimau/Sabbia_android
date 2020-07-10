/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.utils
 * Date: 10/07/2020
 */

package com.marinumau.sabbia.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class UrlManager {

    /**
     *
     * @param context the calling activity context
     * @param url the url to open
     */
    public static void open_url(Context context, String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(browserIntent);
    }

}
