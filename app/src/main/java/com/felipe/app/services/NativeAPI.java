package com.felipe.app.services;

import android.content.Context;
import android.util.Log;

import com.felipe.app.BaseActivity;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by felipe on 7/15/17.
 */

public class NativeAPI {

    private final static String LIB_NAME = "native-lib";
    private Double convertedValue;
    private Context ctx;
    private int position;


    @Inject
    public NativeAPI(){
    }

    static {
        System.loadLibrary(LIB_NAME);
    }


    public native void asyncConvertToReal(double num, int pos);

    public void nativeCallBack(double convertedValue){
        Log.d("MUXI", String.format(Locale.UK, "%f", convertedValue));
        ((BaseActivity) ctx).onCalculeComplete(convertedValue, position);
    }


    public void setContext(Context ctx){
        this.ctx = ctx;
    }

    public void setCurrentPosition(int pos){
        this.position = pos;
    }


}
