package com.felipe.app.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.felipe.app.FruitDetailActivity;
import com.felipe.app.FruitsActivity;
import com.felipe.app.R;
import com.felipe.app.models.pojos.Fruit;

import java.util.ArrayList;

/**
 * Created by felipe on 7/12/17.
 */

public class FruitViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView txtName;
    private TextView txtPrice;
    private ImageView nImg;
    private CustomAdapter<Fruit> adapter;

    public FruitViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        config();
    }

    private void config(){
        configWidgets(R.id.txt_name, itemView);
        configWidgets(R.id.txt_price, itemView);
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

    public TextView getTxtPrice() {
        return txtPrice;
    }

    public void setAdapter(CustomAdapter<Fruit> adapter){
        this.adapter = adapter;
    }

    @Override
    public void onClick(View v) {

        Fruit fruit = ((ArrayList<Fruit>) itemView.getTag()).get(getAdapterPosition());

        FruitsActivity activity = (FruitsActivity) v.getContext();
        Intent intent = new Intent(activity, FruitDetailActivity.class);

        intent.putExtra("fruitName", fruit.getName());
        intent.putExtra("fruitPrice", fruit.getPrice());
        intent.putExtra("fruitImage", fruit.getImage());
        activity.startActivity(intent);
    }
}
