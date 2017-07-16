package com.felipe.app.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by felipe on 7/11/17.
 */

public class Utils {

    public final static String API_URL = "https://raw.githubusercontent.com/muxidev/desafio-android/master/";
    public final static String MUXI_TAG = "MUXI";
    public final static String FRUITS = "Fruits";
    private final static String ERROR_MESSAGE = "Something went wrong.";
    final public static int GENERIC_RESOURCE_ID = 1;

    public static void onErrorHandler(Context context, String message){
        Log.e(MUXI_TAG, String.format("Error: %s", message));
        Toast toast = Toast.makeText(context, ERROR_MESSAGE, Toast.LENGTH_LONG);
        toast.show();
    }

}
