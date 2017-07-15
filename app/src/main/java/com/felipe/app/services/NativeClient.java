package com.felipe.app.services;

/**
 * Created by felipe on 7/15/17.
 */

public class NativeClient {

    static {
        System.loadLibrary("native-lib");
    }


    public static native double callbackToNative(double num);

}
