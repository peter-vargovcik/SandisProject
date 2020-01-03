package com.vargovcik.peter.happypear.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.vargovcik.peter.happypear.R;

import java.util.Calendar;

public class CustomWeekPicker extends TableLayout {
    private static final String TAG = "CustomWeekPicker";
    private TextView previousYear,nextYear,previousWeek,currentWeek,nextWeek;
    private Calendar calendar;
    private CustomWeekPickerListener listener;

    public CustomWeekPicker(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

//        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Options, 0, 0);
//
//        String titleText = a.getString(R.styleable.Options_titleText);
//        int valueColor = a.getColor(R.styleable.Options_valueColor,
//                android.R.color.holo_blue_light);
//        a.recycle();


        calendar = Calendar.getInstance();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_custom_week_picker, this, true);

        previousYear = findViewById(R.id.custom_week_previous_year);
        nextYear = findViewById(R.id.custom_week_next_year);
        previousWeek = findViewById(R.id.custom_week_previous_week);
        currentWeek = findViewById(R.id.custom_week_current_week);
        nextWeek = findViewById(R.id.custom_week_next_week);

        updateFields();

        previousYear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                subtractYear();
                publishDateChange();
            }
        });

        nextYear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                addYear();
                publishDateChange();
            }
        });

        previousWeek.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                subtractWeek();
                publishDateChange();
            }
        });

        nextWeek.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                addWeek();
                publishDateChange();
            }
        });
    }

    private void publishDateChange() {
        if(listener != null){
            listener.onWeekChange(calendar);
        }
    }

    private void subtractWeek(){
        calendar.add(Calendar.DATE, -7);
        updateFields();
    }

    private void addWeek(){
        calendar.add(Calendar.DATE, 7);
        updateFields();

    }

    private void subtractYear(){
        calendar.add(Calendar.YEAR, -1);
        updateFields();

    }

    private void addYear(){
        calendar.add(Calendar.YEAR, 1);
        updateFields();

    }

    private void updateFields(){
        Calendar calPreviousYear = ((Calendar) calendar.clone());
        calPreviousYear.add(Calendar.YEAR, -1);

        Calendar calNextYear = ((Calendar) calendar.clone());
        calNextYear.add(Calendar.YEAR, 1);

        Calendar calPreviousWeek = ((Calendar) calendar.clone());
        calPreviousWeek.add(Calendar.DATE, -7);

        Calendar calNextWeek = ((Calendar) calendar.clone());
        calNextWeek.add(Calendar.DATE, 7);

        String pattern = "...%d Week %d...";

        previousYear.setText(String.format(pattern,calPreviousYear.get(Calendar.YEAR),calPreviousYear.get(Calendar.WEEK_OF_YEAR)));
        nextYear.setText(String.format(pattern,calNextYear.get(Calendar.YEAR),calNextYear.get(Calendar.WEEK_OF_YEAR)));
        previousWeek.setText(String.format(pattern,calPreviousWeek.get(Calendar.YEAR),calPreviousWeek.get(Calendar.WEEK_OF_YEAR)));
        currentWeek.setText(String.format(pattern,calendar.get(Calendar.YEAR),calendar.get(Calendar.WEEK_OF_YEAR)));
        nextWeek.setText(String.format(pattern,calNextWeek.get(Calendar.YEAR),calNextWeek.get(Calendar.WEEK_OF_YEAR)));
    }

    public void setOnChangeListener(CustomWeekPickerListener listener){
        this.listener = listener;
    }
}
