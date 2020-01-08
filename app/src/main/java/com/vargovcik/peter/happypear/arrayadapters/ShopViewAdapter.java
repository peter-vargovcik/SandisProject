package com.vargovcik.peter.happypear.arrayadapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vargovcik.peter.happypear.R;
import com.vargovcik.peter.happypear.dto.Shop;

import java.util.ArrayList;

public class ShopViewAdapter extends ArrayAdapter<Shop> {


    private ArrayList<Shop> dataSet;
    Context mContext;



    public ShopViewAdapter(ArrayList<Shop> data, Context context) {
        super(context, R.layout.shop_view_row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Shop data = getItem(position);

        TextView name,val1,val2;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.shop_view_row_item, parent, false);

            name = (TextView) convertView.findViewById(R.id.shop_view_row_item_name);
            val1 = (TextView) convertView.findViewById(R.id.shop_view_row_item_val1);
            val2 = (TextView) convertView.findViewById(R.id.shop_view_row_item_val2);

//            String[] array = data.split(":");
//            boolean isPositive = data.contains("+");
//            left.setText(array[0] + ": ");
//            right.setText(array[1]);
//            right.setTextColor(isPositive ? Color.GREEN : Color.RED);

            name.setText(data.getName());
            val1.setText(""+data.getVal1());
            val2.setText(""+data.getVal2());

        }

        lastPosition = position;


        // Return the completed view to render on screen
        return convertView;
    }
}
