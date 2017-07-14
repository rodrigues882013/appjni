package com.felipe.app.services;

import com.felipe.app.Utils.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by felipe on 7/11/17.
 */

public class EndPointManager {

    private static Retrofit instance;

    private EndPointManager(){}

    public static Retrofit getInstance(){
        if (instance == null){

            instance = new Retrofit.Builder()
                    .baseUrl(Utils.API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
