package com.zelenograd.android.helper.models;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by _red_ on 14.07.17.
 */

public class UserNotification {

    public static void showMessage(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
