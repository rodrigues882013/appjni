package com.felipe.app;

import android.app.Application;

import com.felipe.app.components.DaggerNetworkComponent;
import com.felipe.app.components.NetworkComponent;
import com.felipe.app.modules.AppModule;
import com.felipe.app.modules.NativeModule;
import com.felipe.app.modules.NetworkModule;

/**
 * Created by felipe on 7/15/17.
 */

public class CustomApplication extends Application {

    private NetworkComponent networkComponentInstance;
//    private NativeComponent nativeComponentInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init(){
        networkComponentInstance = DaggerNetworkComponent
                .builder()
                .networkModule(new NetworkModule())
                .build();

//        nativeComponentInstance = DaggerNativeComponent
//                .builder()
//                .nativeModule(new NativeModule())
//                .build();
    }

    public NetworkComponent getNetworkComponent(){
        return networkComponentInstance;

    }

//    public NativeComponent getNativeComponent(){
//        return nativeComponentInstance;
//
//    }

}
