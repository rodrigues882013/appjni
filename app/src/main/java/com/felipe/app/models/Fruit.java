package com.felipe.app.models;

/**
 * Created by felipe on 7/11/17.
 */

public class Fruit {
    private String name;
    private String image;
    private Double price;

    public Fruit(String name, String image, Double price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public Fruit() {
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
