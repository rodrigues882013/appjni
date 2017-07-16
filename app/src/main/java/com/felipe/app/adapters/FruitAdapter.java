package com.felipe.app.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.felipe.app.R;
import com.felipe.app.models.pojos.Fruit;

import java.util.List;
import java.util.Locale;

/**
 * Created by felipe on 7/11/17.
 */

public class FruitAdapter extends CustomAdapter<Fruit>{

    private List<Fruit> items;
    private FruitViewHolder holder;

    public FruitAdapter(Activity activity, List<Fruit> items) {
        super(activity, items);
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.activity).inflate(R.layout.card_fruit, parent, false);
        v.setTag(items);
        return new FruitViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        holder = (FruitViewHolder) viewHolder;
        holder.setAdapter(this);
        Fruit f  = (Fruit) this.items.get(position);

        holder.getTxtName().setText(f.getName());
        holder.getTxtPriceDollar().setText(String.format(Locale.UK, "U$ " + "%,.2f",  f.getPrice()));
        holder.getTxtPriceReal().setText(String.format(Locale.UK, "R$ " + "%,.2f",  f.getPriceReal()));
    }



}
