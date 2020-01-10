package com.vargovcik.peter.happypear.ui.performance;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.vargovcik.peter.happypear.R;
import com.vargovcik.peter.happypear.components.CustomWeekPicker;
import com.vargovcik.peter.happypear.components.CustomWeekPickerListener;
import com.vargovcik.peter.happypear.components.DualPerformanceView;
import com.vargovcik.peter.happypear.dto.Shop;
import com.vargovcik.peter.happypear.dto.ShopDetail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class ShopPerformanceFragment extends Fragment {

    private ShopPerformanceModel homeViewModel;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(ShopPerformanceModel.class);
       root = inflater.inflate(R.layout.fragment_shop_performance, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });


        CustomWeekPicker weekPicker = root.findViewById(R.id.calendarTableView);

        weekPicker.setOnChangeListener(new CustomWeekPickerListener() {
            @Override
            public void onWeekChange(Calendar calendar) {
                String test = String.format("...%d Week %d...",calendar.get(Calendar.YEAR),calendar.get(Calendar.WEEK_OF_YEAR));

                Toast.makeText(root.getContext(),test,Toast.LENGTH_SHORT).show();
            }
        });

        ShopDetail leftSide =  new ShopDetail();
        leftSide.setShopName("Centra");
        leftSide.setShopsInMinus(3);
        leftSide.setShopsInMinusLosses(100);
        leftSide.setShopsInPlus(5);
        leftSide.setShopsInPlusEarnings(223);

        ShopDetail rightSide =  new ShopDetail();
        rightSide.setShopName("SuperValue");
        rightSide.setShopsInMinus(16);
        rightSide.setShopsInMinusLosses(1904);
        rightSide.setShopsInPlus(22);
        rightSide.setShopsInPlusEarnings(3482);

        ArrayList<Shop> shopsLeftSide = new ArrayList<Shop>();
        shopsLeftSide.add(new Shop("1625 - KILLINEY - RUSHE",1054,156));
        shopsLeftSide.add(new Shop("393 - ARDEE - LANNEY",453,150));
        shopsLeftSide.add(new Shop("1425 - PORTLAOISE SV",709,128));
        shopsLeftSide.add(new Shop("1905 - ATHY - PETTITT",509,108));
        shopsLeftSide.add(new Shop("1625 - KILLINEY - RUSHE",1054,156));
        shopsLeftSide.add(new Shop("393 - ARDEE - LANNEY",453,150));
        shopsLeftSide.add(new Shop("1425 - PORTLAOISE SV",709,128));
        shopsLeftSide.add(new Shop("1905 - ATHY - PETTITT",509,108));
        shopsLeftSide.add(new Shop("1625 - KILLINEY - RUSHE",1054,156));
        shopsLeftSide.add(new Shop("393 - ARDEE - LANNEY",453,150));
        shopsLeftSide.add(new Shop("1425 - PORTLAOISE SV",709,128));
        shopsLeftSide.add(new Shop("1905 - ATHY - PETTITT",509,108));

        ArrayList<Shop> shopsRightSide = new ArrayList<Shop>();

        shopsRightSide.add(new Shop("1625 - KILLINEY - RUSHE",1054,156));
        shopsRightSide.add(new Shop("393 - ARDEE - LANNEY",453,150));
        shopsRightSide.add(new Shop("1425 - PORTLAOISE SV",709,128));
        shopsRightSide.add(new Shop("1905 - ATHY - PETTITT",509,108));
        shopsRightSide.add(new Shop("1625 - KILLINEY - RUSHE",1054,156));
        shopsRightSide.add(new Shop("393 - ARDEE - LANNEY",453,150));
        shopsRightSide.add(new Shop("1425 - PORTLAOISE SV",709,128));
        shopsRightSide.add(new Shop("1905 - ATHY - PETTITT",509,108));
        shopsRightSide.add(new Shop("1625 - KILLINEY - RUSHE",1054,156));
        shopsRightSide.add(new Shop("393 - ARDEE - LANNEY",453,150));
        shopsRightSide.add(new Shop("1425 - PORTLAOISE SV",709,128));
        shopsRightSide.add(new Shop("1905 - ATHY - PETTITT",509,108));

        // Shop Performance section
        TextView lefShopsCount = root.findViewById(R.id.performance_shops_count_left);
        TextView rightShopsCount = root.findViewById(R.id.performance_shops_count_right);

        TextView leftMinusShops = root.findViewById(R.id.performance_shops_minus_left);
        TextView leftPlusShops = root.findViewById(R.id.performance_shops_plus_left);
        TextView leftTotalShops = root.findViewById(R.id.performance_shops_total_left);
        TextView rightMinusShops = root.findViewById(R.id.performance_shops_minus_right);
        TextView rightPlusShops = root.findViewById(R.id.performance_shops_plus_right);
        TextView rightTotalShops = root.findViewById(R.id.performance_shops_total_right);

        lefShopsCount.setText("Shops : "+(leftSide.getShopsInMinus()+leftSide.getShopsInPlus()));

        leftMinusShops.setText(buildSnannableString(leftSide.getShopsInMinus(),leftSide.getShopsInMinusLosses() * -1), TextView.BufferType.SPANNABLE);
        leftPlusShops.setText(buildSnannableString(leftSide.getShopsInPlus(),leftSide.getShopsInPlusEarnings()), TextView.BufferType.SPANNABLE);
        leftTotalShops.setText(buildSnannableString("Total: ",leftSide.getShopsInMinusLosses() * -1,leftSide.getShopsInPlusEarnings()), TextView.BufferType.SPANNABLE);


        rightShopsCount.setText("Shops : "+(rightSide.getShopsInMinus()+rightSide.getShopsInPlus()));

        rightMinusShops.setText(buildSnannableString(rightSide.getShopsInMinus(),rightSide.getShopsInMinusLosses()* -1), TextView.BufferType.SPANNABLE);
        rightPlusShops.setText(buildSnannableString(rightSide.getShopsInPlus(),rightSide.getShopsInPlusEarnings()), TextView.BufferType.SPANNABLE);
        rightTotalShops.setText(buildSnannableString("Total: ",rightSide.getShopsInMinusLosses() * -1,rightSide.getShopsInPlusEarnings()), TextView.BufferType.SPANNABLE);

        DualPerformanceView performanceView = root.findViewById(R.id.performance_view_shops);
        performanceView.setNameAndSides("ShopDetail",leftSide.getShopName(),rightSide.getShopName());

        displayPerformingShops(inflater,R.id.performance_view_shops_list_left,shopsLeftSide);
        displayPerformingShops(inflater,R.id.performance_view_shops_list_right,shopsRightSide);



        displayPerformingProducts(inflater,R.id.performance_view_products_list_left);
        displayPerformingProducts(inflater,R.id.performance_view_products_list_right);




        return root;
    }

    private void displayPerformingProducts(LayoutInflater inflater,int layoutId) {
        LinearLayout linearLayoutParent =  root.findViewById(layoutId);
        Random random = new Random();
        List<Integer> values = new ArrayList<>();

        for(int i = 0; i< random.nextInt(20);i++){
            values.add(random.nextInt(1000));
        }

        int val1Low = Integer.MAX_VALUE;
        int val1High = Integer.MIN_VALUE;

        for(Integer integer : values){
            if(integer< val1Low){
                val1Low =integer;
            }

            if(integer> val1High){
                val1High = integer;
            }
        }

        for(int i = 0; i< values.size();i++){
            int value = values.get(i);
            int val1 = (value - val1Low) * (255 - 170) / (val1High - val1Low) + 170;
            int color1 = Color.parseColor("#00"+Integer.toHexString(val1)+"00");

            LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.product_view_row_item,null);

            TextView itemName = linearLayout.findViewById(R.id.product_view_row_item_name);
            TextView itemVal1 = linearLayout.findViewById(R.id.product_view_row_item_val1);

            itemName.setText("Shop "+ value);
            itemVal1.setText(""+ value);
            itemVal1.setBackgroundColor(color1);

            linearLayoutParent.addView(linearLayout);

        }

    }

    private void displayPerformingShops(LayoutInflater inflater,int layoutId, ArrayList<Shop> shops) {
        LinearLayout linearLayoutParent =  root.findViewById(layoutId);

        double val1Low = Double.MAX_VALUE;
        double val1High = Double.MIN_VALUE;
        double val2Low = Double.MAX_VALUE;
        double val2High = Double.MIN_VALUE;

        for(Shop shop :shops){
            if(shop.getVal1()< val1Low){
                val1Low = shop.getVal1();
            }

            if(shop.getVal1()> val1High){
                val1High = shop.getVal1();
            }

            if(shop.getVal2()< val2Low){
                val2Low = shop.getVal2();
            }

            if(shop.getVal2()> val2High){
                val2High = shop.getVal2();
            }
        }


        for(Shop shop :shops){

            double val1 = (shop.getVal1() - val1Low) * (255 - 170) / (val1High - val1Low) + 170;
            double val2 = (shop.getVal2() - val2Low) * (255 - 170) / (val2High - val2Low) + 170;

            int color1 = Color.parseColor("#00"+Integer.toHexString((int)val1)+"00");
            int color2 = Color.parseColor("#00"+Integer.toHexString((int)val2)+"00");

            LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.shop_view_row_item,null);

            TextView itemName = linearLayout.findViewById(R.id.shop_view_row_item_name);
            TextView itemVal1 = linearLayout.findViewById(R.id.shop_view_row_item_val1);
            TextView itemVal2 = linearLayout.findViewById(R.id.shop_view_row_item_val2);

            itemName.setText(shop.getName());
            itemVal1.setText(""+ shop.getVal1());
            itemVal1.setBackgroundColor(color1);
            itemVal2.setText(""+ shop.getVal2());
            itemVal2.setBackgroundColor(color2);

            linearLayoutParent.addView(linearLayout);
        }
    }

    private SpannableString buildSnannableString(int shopsInMinus, double shopsInMinusLosses) {
        //https://www.chrisumbel.com/article/android_textview_rich_text_spannablestring

        boolean isInMinus = shopsInMinusLosses < 0;
        String string = String.format("%s Shops: $%s",shopsInMinus,shopsInMinusLosses);
        int startIndex = string.indexOf(":");
        SpannableString text = new SpannableString(string);

        text.setSpan(new ForegroundColorSpan(isInMinus ? Color.RED : Color.GREEN), startIndex + 1, string.length(), 0);

        return text;
    }

    private SpannableString buildSnannableString(String s, double shopsInMinusLosses, double shopsInPlusEarnings) {
        double sum = shopsInPlusEarnings + shopsInMinusLosses;
        boolean isInMinus = sum < 0;
        String string = "Total : $" + sum;

        int startIndex = string.indexOf(":");
        SpannableString text = new SpannableString(string);

        text.setSpan(new ForegroundColorSpan(isInMinus ? Color.RED : Color.GREEN), startIndex + 1, string.length(), 0);

        return text;
    }
}