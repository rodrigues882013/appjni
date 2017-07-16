package com.felipe.app;

import android.app.Application;

import com.felipe.app.components.ApplicationComponent;
import com.felipe.app.components.DaggerApplicationComponent;
import com.felipe.app.modules.ApplicationModule;

/**
 * Created by felipe on 7/15/17.
 */

public class CustomApplication extends Application {

    /*
    *  Custom application that join all modules and provide them all application
    * */
    private ApplicationComponent applicationComponentInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init(){
        applicationComponentInstance = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule())
                .build();
    }

    public ApplicationComponent getNetworkComponent(){
        return applicationComponentInstance;

    }
}
