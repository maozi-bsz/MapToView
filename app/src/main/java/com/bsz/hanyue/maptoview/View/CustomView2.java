package com.bsz.hanyue.maptoview.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.bsz.hanyue.maptoview.R;

import java.util.ArrayList;

/**
 * Created by hanyue on 2015/7/26.
 */

public class CustomView2 extends View {

    Paint paint;
    private ArrayList<PointF> graphics = new ArrayList<PointF>();
    PointF point;

    public CustomView2(Context context) {
        this(context, null);
    }

    public CustomView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(); //设置一个笔刷大小是10的黑色画笔
        paint.setColor(Color.BLACK);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(10);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        graphics.add(new PointF(event.getX(), event.getY()));
        invalidate(); //重新绘制区域
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.qunguangguangchang7);
        Paint mPaint = new Paint();
        canvas.drawBitmap(bitmap, 0, 0, mPaint);

        for (PointF point : graphics) {
            canvas.drawPoint(point.x, point.y, paint);
        }
        super.onDraw(canvas);

    }
}

