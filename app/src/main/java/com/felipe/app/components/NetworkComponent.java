package com.felipe.app.components;

import com.felipe.app.FruitsActivity;
import com.felipe.app.modules.AppModule;
import com.felipe.app.modules.NativeModule;
import com.felipe.app.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by felipe on 7/15/17.
 */

@Singleton
@Component( modules = { NetworkModule.class, NativeModule.class })
public interface NetworkComponent {
    void inject(FruitsActivity activity);
}
