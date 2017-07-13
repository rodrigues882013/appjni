package com.felipe.app.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.felipe.app.BaseActivity;
import com.felipe.app.DetailActivityFragment;
import com.felipe.app.R;

/**
 * Created by felipe on 7/12/17.
 */

public class FruitViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView txtName;
    private TextView txtPrice;
    private ImageView nImg;

    public FruitViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        config();
    }

    private void config(){
        configWidgets(R.id.txt_name, itemView);
        configWidgets(R.id.txt_price, itemView);
        configWidgets(R.id.img_fruit_image, itemView);

    }

    private void configWidgets(final int vid, View v) {
        switch (vid){
            case R.id.txt_name:
                txtName = (TextView) v.findViewById(vid);
                break;
            case R.id.txt_price:
                txtPrice = (TextView) v.findViewById(vid);
                break;
            case R.id.img_fruit_image:
                nImg = (ImageView) v.findViewById(vid);
                break;
        }
    }

    public TextView getTxtName() {
        return txtName;
    }

    public void setTxtName(TextView txtName) {
        this.txtName = txtName;
    }

    public TextView getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(TextView txtPrice) {
        this.txtPrice = txtPrice;
    }

    public ImageView getnImg() {
        return nImg;
    }

    public void setnImg(ImageView nImg) {
        this.nImg = nImg;
    }

    @Override
    public void onClick(View v) {
        Log.e("MUXI", "onClick " + getPosition());
        BaseActivity myActivity = (BaseActivity) v.getContext();
        myActivity.getSupportFragmentManager();

    }
}
