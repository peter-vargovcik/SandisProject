package com.vargovcik.peter.happypear.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.vargovcik.peter.happypear.R;


public class DualPerformanceView extends View {

    private Path circle,namePath;
    private Paint centreCirclePaint;
    private Paint leftTextPaint, leftBackgroundPaint, rightTextPaint, rightBackgroundPaint, namePaint;

    private float size;
    private String leftSideText,rightSideText,name;
    private int leftSideTextColor, leftSideBackgroundColor,rightSideTextColor,rightSideBackgroundColor,nameColor;

    private static int defaultColor1,defaultColor2,defaultBackground;

    public DualPerformanceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        defaultColor1 = ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null);
        defaultColor2 = ResourcesCompat.getColor(getResources(), R.color.colorAccent, null);
        defaultBackground = ResourcesCompat.getColor(getResources(), R.color.colorPrimaryDark, null);

        size = 400;
        leftSideTextColor = Color.BLACK;
        leftSideBackgroundColor = defaultColor1;
        rightSideTextColor = Color.BLACK;
        rightSideBackgroundColor = defaultColor2;
        nameColor = defaultColor1;

        name = "Placebo";
        leftSideText = "Placebo";
        rightSideText = "Placebo";

        setCustomAttributes(context.obtainStyledAttributes(attrs, R.styleable.DualPerformanceView ));

//        int color = Color.argb(127, 255, 0, 255);

        circle = new Path();
        circle.addCircle(size/2, size/2, size/2, Path.Direction.CW);

        namePath = new Path();
        namePath.moveTo(size/2,0);
        namePath.lineTo(size/2,size);


//        circle.addCircle(170, 170, 150, Path.Direction.CW);
        float innerCircleRadius = (float) ((size/2) * .8);

        centreCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        centreCirclePaint.setStyle(Paint.Style.FILL);
        centreCirclePaint.setColor(Color.LTGRAY);
        centreCirclePaint.setStrokeWidth(3);
        centreCirclePaint.setShader(new RadialGradient(size/2, size/2,
                innerCircleRadius, Color.WHITE, Color.GRAY, Shader.TileMode.MIRROR));


        // For Background Image
//        setBackgroundResource(R.drawable.YOUR_IMAGE);

        namePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        namePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        //TextColor you want to set
        namePaint.setColor(nameColor);
        //TextSize you want to set
        namePaint.setTextSize(50);

        setLeftTextPaint(leftSideTextColor);
        setLeftBackgroundPaint(leftSideBackgroundColor);
        setRightTextPaint(rightSideTextColor);
        setRightBackgroundPaint(rightSideBackgroundColor);

    }

    private void setLeftTextPaint(int color) {
        leftTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        leftTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        //TextColor you want to set
        leftTextPaint.setColor(color);
        //TextSize you want to set
        leftTextPaint.setTextSize(31);
    }

    private void setLeftBackgroundPaint(int color) {
        leftBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        leftBackgroundPaint.setStyle(Paint.Style.FILL);
        leftBackgroundPaint.setColor(color);
    }

    private void setRightTextPaint(int color) {
        rightTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rightTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        //TextColor you want to set
        rightTextPaint.setColor(color);
        //TextSize you want to set
        rightTextPaint.setTextSize(31);
    }

    private void setRightBackgroundPaint(int color) {
        rightBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rightBackgroundPaint.setStyle(Paint.Style.FILL);
        rightBackgroundPaint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.rotate(-90f,size/2,size/2);

        RectF oval = new RectF(0,0,size,size);
        float innerCircleRadius = (float) ((size/2) * .8);

        canvas.drawArc(oval, 0F, 180F, true, leftBackgroundPaint);
        canvas.drawArc(oval, 180F, 180F, true, rightBackgroundPaint);
        canvas.drawCircle(size/2,size/2,innerCircleRadius, centreCirclePaint);

        PathMeasure pathMeasure = new PathMeasure(circle,false);
        float pathLength = pathMeasure.getLength();

        PathMeasure pathLineMeasure = new PathMeasure(namePath,false);
        float pathLineMeasureLength = pathLineMeasure.getLength();

        float leftTextWidth = leftTextPaint.measureText(leftSideText);
        float rightTextWidth = leftTextPaint.measureText(rightSideText);
        float nameTextWidth = namePaint.measureText(name);

        float pathQuadrantLength = pathLength/4;

        float offsetLeft = pathQuadrantLength*3- (leftTextWidth/2);
        float offsetRigth = pathQuadrantLength- (rightTextWidth/2);
        float offsetName = pathLineMeasureLength/2- (nameTextWidth/2);

        canvas.drawTextOnPath(leftSideText, circle, offsetLeft, 30, leftTextPaint);
        canvas.drawTextOnPath(rightSideText, circle, offsetRigth, 30, rightTextPaint);
        canvas.drawTextOnPath(name,namePath,offsetName,20,namePaint);

        canvas.restore();

    }

    private void setCustomAttributes(TypedArray attributes) {
        final int indexCount = attributes.getIndexCount();
        for (int i = 0; i < indexCount; ++i) {
            int attr = attributes.getIndex(i);
            switch (attr) {
                case R.styleable.DualPerformanceView_size:
                    size = attributes.getDimension(attr,-1);
                    break;
                case R.styleable.DualPerformanceView_left_side_text:
                    leftSideText = attributes.getString(attr);
                    break;
                case R.styleable.DualPerformanceView_left_side_text_color:
                    leftSideTextColor = attributes.getColor(attr,-1);
                    break;
                case R.styleable.DualPerformanceView_left_side_background_color:
                    leftSideBackgroundColor = attributes.getColor(attr,-1);
                    break;
                case R.styleable.DualPerformanceView_right_side_text:
                    rightSideText = attributes.getString(attr);
                    break;
                case R.styleable.DualPerformanceView_right_side_text_color:
                    rightSideTextColor = attributes.getColor(attr,-1);
                    break;
                case R.styleable.DualPerformanceView_right_side_background_color:
                    rightSideBackgroundColor = attributes.getColor(attr,-1);
                    break;
            }
        }
        attributes.recycle();
    }

    public void setNameAndSides(String name,String leftSideText, String rightSideText){
        this.name = name;
        this.leftSideText = leftSideText;
        this.rightSideText = rightSideText;
    }
}
