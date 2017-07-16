package com.felipe.app.services;

import com.felipe.app.utils.Utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by felipe on 7/11/17.
 */

public class RestClient implements Client<Retrofit>{

    private Retrofit instance;

    private RestClient(){}

    @Override
    public Retrofit getInstance(){
        if (instance == null){

            instance = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Utils.API_URL)
                    .build();
        }
        return instance;
    }
}
