package com.felipe.app;

/**
 * Created by felipe on 7/14/17.
 */

interface ActivityAction {

    /*
    *  Simple activity contract
    * */
    void onConfigure();
    void configWidgets(int vid);
    void configureToolbar();
}
