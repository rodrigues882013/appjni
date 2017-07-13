package com.felipe.app.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipe on 7/12/17.
 */

public class FruitsJSON {
    private List<Fruit> fruits = new ArrayList<Fruit>();

    public List<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(List<Fruit> fruits) {
        this.fruits = fruits;
    }
}
