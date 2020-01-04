package com.vargovcik.peter.happypear.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.vargovcik.peter.happypear.R;


public class DualPerformanceView extends View {

    private static final String QUOTE = "SuperValue";
    private Path circle;
    private Paint cPaint;
    private Paint tPaint,tPaint2;

    public DualPerformanceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setCustomAttributes(context.obtainStyledAttributes(attrs, R.styleable.DualPerformanceView ));

        int color = Color.argb(127, 255, 0, 255);

        circle = new Path();
        circle.addCircle(170, 170, 150, Path.Direction.CW);

        circle.addCircle(170, 170, 150, Path.Direction.CW);


        cPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        cPaint.setStyle(Paint.Style.FILL);
        cPaint.setColor(Color.LTGRAY);
        cPaint.setStrokeWidth(3);


        // For Background Image
//        setBackgroundResource(R.drawable.YOUR_IMAGE);

        tPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        tPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        //TextColor you want to set
        tPaint.setColor(Color.BLACK);
        //TextSize you want to set
        tPaint.setTextSize(30);

        tPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        tPaint2.setStyle(Paint.Style.FILL_AND_STROKE);
        //TextColor you want to set
        tPaint2.setColor(color);
        //TextSize you want to set
        tPaint2.setTextSize(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF oval = new RectF(0,0,300,300);

        canvas.drawArc(oval, 90F, 180F, true, tPaint2);

        canvas.drawArc(oval, 270F, 180F, true, tPaint);

        canvas.drawCircle(150,150,100,cPaint);

        canvas.drawTextOnPath(QUOTE, circle, 242, 40, tPaint);
        canvas.drawTextOnPath(QUOTE, circle, 600, 40, tPaint2);
    }

    private void setCustomAttributes(TypedArray attributes) {
        final int indexCount = attributes.getIndexCount();
        for (int i = 0; i < indexCount; ++i) {
            int attr = attributes.getIndex(i);
            switch (attr) {
                case R.styleable.DualPerformanceView_left_side_text:
                    //TODO
                    break;
                case R.styleable.DualPerformanceView_left_side_text_color:
                    //TODO
                    break;
                case R.styleable.DualPerformanceView_left_side_background_color:
                    //TODO
                    break;
                case R.styleable.DualPerformanceView_right_side_text:
                    //TODO
                    break;
                case R.styleable.DualPerformanceView_right_side_text_color:
                    //TODO
                    break;
                case R.styleable.DualPerformanceView_right_side_background_color:
                    //TODO
                    break;
            }
        }
        attributes.recycle();
    }
}
