package com.felipe.app.services;

import com.felipe.app.Utils.Utils;

import retrofit2.Retrofit;

/**
 * Created by felipe on 7/11/17.
 */

public class APIClient {

    private static Retrofit instance;

    private APIClient(){}

    public static Retrofit getInstance(){
        if (instance == null){
            instance = new Retrofit.Builder()
                    .baseUrl(Utils.API_URL)
                    .build();
        }
        return instance;
    }
}
