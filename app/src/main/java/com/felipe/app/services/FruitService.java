package com.felipe.app.services;

import com.felipe.app.models.schemas.FruitsJSON;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by felipe on 7/11/17.
 */

public interface FruitService {

    @GET("fruits.json")
    Observable<FruitsJSON> listFruits();
}