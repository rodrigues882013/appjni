package com.felipe.app.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.felipe.app.R;
import com.felipe.app.models.Fruit;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

/**
 * Created by felipe on 7/11/17.
 */

public class FruitAdapter extends CustomAdapter<Fruit> {

    public FruitAdapter(Activity activity, List<Fruit> items) {
        super(activity, items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.activity).inflate(R.layout.card_fruit, parent, false);
        return new FruitViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        FruitViewHolder holder = (FruitViewHolder) viewHolder;
        Fruit f  = (Fruit) this.items.get(position) ;

        holder.getTxtName().setText(f.getName());
        holder.getTxtPrice().setText(String.format(Locale.UK, "R$ " + "%,.2f",  f.getPrice()));
        //Picasso.with(activity).load(f.getImage()).into(holder.getnImg());

    }
}
