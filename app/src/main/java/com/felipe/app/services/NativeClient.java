package com.felipe.app.services;

import android.util.Log;

import java.util.Locale;

import javax.inject.Inject;

/**
 * Created by felipe on 7/15/17.
 */

public class NativeClient {

    private final static String LIB_NAME = "native-lib";
    private double convertedValue;

    @Inject
    public NativeClient(){ }

    static {
        System.loadLibrary(LIB_NAME);
    }


    public native void asyncConvertToReal(double num);

    public void nativeCallBack(double convertedValue){
        Log.d("MUXI", String.format(Locale.UK, "%f", convertedValue));
        this.convertedValue = convertedValue;
    }

    public double getConvertedValue() {
        return convertedValue;
    }
}
