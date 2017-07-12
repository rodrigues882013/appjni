package com.felipe.app.adapters;

import android.app.Activity;
import android.content.Context;
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
    public View getView(int position, View convertView, ViewGroup viewGroup){
        Fruit f = items.get(position);

        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.card_fruit, null);
        }

        //Get Image
        ImageView imgLocal = (ImageView) convertView.findViewById(R.id.img_fruit_image);
        Picasso.with(activity).load(f.getImage()).into(imgLocal);

//      imgLocal.setImageUrl(c.getImage(), AppController.getInstance(activity).getImageLoader());

        //Get Texts
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txt_fruit_name);
        String packageName = f.getName();
        if (packageName != null) {
            txtTitle.setText(packageName);
        }

        TextView txtPrice = (TextView) convertView.findViewById(R.id.txt_fruit_price);
        Double price = f.getPrice();
        if (packageName != null) {
            txtPrice.setText(String.format(Locale.UK, "%f", price));
        }

        return convertView;



    }
}
