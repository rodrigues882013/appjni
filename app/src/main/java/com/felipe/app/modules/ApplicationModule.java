package com.felipe.app.modules;

import com.felipe.app.services.NativeAPI;
import com.felipe.app.utils.Utils;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by felipe on 7/15/17.
 */

@Module
public class ApplicationModule {

    /**
     * Dagger 2 module
     * */
    public ApplicationModule() {
    }

    @Provides
    @Named("retrofit")
    @Singleton
    Retrofit provideRetrofit(){
        /*
        * Retrofit provide
        * */
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Utils.API_URL)
                .build();
    }

    @Provides
    @Named("native")
    @Singleton
    NativeAPI provideNative(){
        /*
        * NativeAPI provide
        * */
        return new NativeAPI();
    }

}
