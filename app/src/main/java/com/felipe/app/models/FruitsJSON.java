package com.felipe.app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipe on 7/12/17.
 */

public class FruitsJSON {
    @SerializedName("fruits")
    @Expose
    private List<Fruit> fruits = null;

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }
}
