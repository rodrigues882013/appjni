package com.felipe.app.models.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Locale;

/**
 * Created by felipe on 7/11/17.
 */

public class Fruit implements Parcelable{
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

    protected Fruit(Parcel in) {
        name = in.readString();
        image = in.readString();
        price = Double.parseDouble(in.readString());
        priceReal = Double.parseDouble(in.readString());
    }

    public static final Creator<Fruit> CREATOR = new Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel in) {
            return new Fruit(in);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(String.format(Locale.UK, "%f", price));
        dest.writeString(String.format(Locale.UK, "%f", priceReal));
    }
}
