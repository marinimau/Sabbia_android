/*
 * Sabbia copyright © 2020
 * Author: mauromarini - https://github.com/marinimau
 * Package: com.marinumau.sabbia.utils
 * Date: 13/07/2020
 */

package com.marinumau.sabbia.utils;

import android.app.Activity;
import android.content.res.Configuration;

public class UIConfigurationManager {

    /**
     *
     * @param activity the calling activity
     * @return the night mode configuration
     */
    public static int getNightModeConfiguration(Activity activity) {
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        return activity.getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;
    }
}
