package com.felipe.app;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by felipe on 7/11/17.
 */

public class FruitDetailActivity extends BaseActivity {

    private TextView txtName;
    private TextView txtPrice;
    private ImageView nImg;

    public FruitDetailActivity() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        onConfigure();

    }

    public void onConfigure(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        configWidgets(R.id.txt_info_name);
        configWidgets(R.id.txt_info_price);
        configWidgets(R.id.img_fruit_image);
    }

    private void configWidgets(final int vid) {
        switch (vid){
            case R.id.txt_info_name:
                txtName = (TextView) findViewById(vid);
                break;
            case R.id.txt_info_price:
                txtPrice = (TextView) findViewById(vid);
                break;
            case R.id.img_fruit_image:
                nImg = (ImageView) findViewById(vid);
                break;
        }
    }
}
