package com.felipe.app.helpers;

/**
 * Created by felipe on 7/16/17.
 */

public interface ProccessValueListener {

    /*
    *  Simple listener interface that should be implemented for clients of NativeAPI
    * */
    void onCalculeComplete(double result, int pos);
}

