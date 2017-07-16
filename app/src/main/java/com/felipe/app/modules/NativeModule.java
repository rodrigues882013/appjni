package com.felipe.app.modules;

import com.felipe.app.services.NativeClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by felipe on 7/15/17.
 */

@Module
public class NativeModule {

    public NativeModule(){
    }

    @Provides
    @Singleton
    NativeClient provideNative(){
        return new NativeClient();
    }

}
