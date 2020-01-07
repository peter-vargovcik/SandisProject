package com.vargovcik.peter.happypear.arrayadapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vargovcik.peter.happypear.R;

import java.util.ArrayList;

public class ShopViewAdapter extends ArrayAdapter<String> {


    private ArrayList<String> dataSet;
    Context mContext;



    public ShopViewAdapter(ArrayList<String> data, Context context) {
        super(context, R.layout.shop_view_row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        String data = getItem(position);

        TextView left,right;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.shop_view_row_item, parent, false);

            left = (TextView) convertView.findViewById(R.id.shop_view_row_item_left);
            right = (TextView) convertView.findViewById(R.id.shop_view_row_item_right);

            String[] array = data.split(":");

            boolean isPositive = data.contains("+");

            left.setText(array[0] + ": ");
            right.setText(array[1]);
            right.setTextColor(isPositive ? Color.GREEN : Color.RED);

        }

        lastPosition = position;


        // Return the completed view to render on screen
        return convertView;
    }
}
