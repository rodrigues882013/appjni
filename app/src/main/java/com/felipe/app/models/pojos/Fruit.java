package com.felipe.app.models.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by felipe on 7/11/17.
 */

public class Fruit {
    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("price")
    @Expose
    private Double price;

    private Double priceReal;

    public Fruit(String name, String image, Double price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public Fruit() {
    }

    public Double getPriceReal() {
        return priceReal;
    }

    public void setPriceReal(Double priceReal) {
        this.priceReal = priceReal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fruit fruit = (Fruit) o;

        return name.equals(fruit.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
