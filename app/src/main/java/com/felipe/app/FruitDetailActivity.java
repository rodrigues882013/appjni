package com.felipe.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.felipe.app.models.pojos.Fruit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by felipe on 7/11/17.
 */

public class FruitDetailActivity extends BaseActivity implements ActivityAction {

    private Fruit fruit;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        fruit = getFruit();
        onConfigure();
    }

    @Override
    public void onConfigure(){

        configureToolbar();
        configWidgets(R.id.txt_info_name);
        configWidgets(R.id.txt_info_price);
        configWidgets(R.id.txt_info_price_real);
        configWidgets(R.id.img_fruit_image);
    }

    @Override
    public void configureToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void configWidgets(final int vid) {

        switch (vid){
            case R.id.txt_info_name:
                TextView txtName = (TextView) findViewById(vid);
                txtName.setText(fruit.getName());
                break;

            case R.id.txt_info_price:
                TextView txtPrice = (TextView) findViewById(vid);
                txtPrice.setText(String.format(Locale.UK, "U$ " + "%,.2f",  fruit.getPrice()));
                break;

            case R.id.txt_info_price_real:
                TextView txtPriceReal = (TextView) findViewById(vid);
                txtPriceReal.setText(String.format(Locale.UK, "R$ " + "%,.2f",  fruit.getPriceReal()));
                break;

            case R.id.img_fruit_image:
                ImageView nImg = (ImageView) findViewById(vid);
                Picasso.with(this).load(fruit.getImage()).into(nImg);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable("fruits", fruit);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fruit = savedInstanceState.getParcelable("fruit");
    }

    public Fruit getFruit(){
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();

        Fruit fruit = new Fruit();
        fruit.setName(extra.getString("name"));
        fruit.setImage(extra.getString("image"));
        fruit.setPrice(extra.getDouble("price"));
        fruit.setPriceReal(extra.getDouble("priceReal"));

        return fruit;
    }
}
