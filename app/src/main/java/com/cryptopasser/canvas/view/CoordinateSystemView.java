package com.cryptopasser.canvas.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CoordinateSystemView extends View {

    private Paint mPaint;

    public CoordinateSystemView(Context context) {
        super(context);
    }

    public CoordinateSystemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CoordinateSystemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CoordinateSystemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建画笔
        mPaint = new Paint();
        drawAxis(canvas);
    }

    private void drawAxis(Canvas canvas) {
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(6 * 1);

        //用绿色画x轴，用蓝色画y轴

        //第一次绘制坐标轴
        mPaint.setColor(0xff00ff00);//绿色
        canvas.drawLine(0, 0, canvasWidth, 0, mPaint);//绘制x轴
        mPaint.setColor(0xff0000ff);//蓝色
        canvas.drawLine(0, 0, 0, canvasHeight, mPaint);//绘制y轴

        //对坐标系平移后，第二次绘制坐标轴
        canvas.translate(canvasWidth / 4, canvasWidth / 4);//把坐标系向右下角平移
        mPaint.setColor(0xff00ff00);//绿色
        canvas.drawLine(0, 0, canvasWidth, 0, mPaint);//绘制x轴
        mPaint.setColor(0xff0000ff);//蓝色
        canvas.drawLine(0, 0, 0, canvasHeight, mPaint);//绘制y轴

        //再次平移坐标系并在此基础上旋转坐标系，第三次绘制坐标轴
        canvas.translate(canvasWidth / 4, canvasWidth / 4);//在上次平移的基础上再把坐标系向右下角平移
        canvas.rotate(30);//基于当前绘图坐标系的原点旋转坐标系
        mPaint.setColor(0xff00ff00);//绿色
        canvas.drawLine(0, 0, canvasWidth, 0, mPaint);//绘制x轴
        mPaint.setColor(0xff0000ff);//蓝色
        canvas.drawLine(0, 0, 0, canvasHeight, mPaint);//绘制y轴
    }

}
