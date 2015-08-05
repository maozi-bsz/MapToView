package com.bsz.hanyue.maptoview.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.bsz.hanyue.maptoview.Interface.HImageLoadListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanyue on 2015/8/1.
 */
public class HImageView extends ImageView {

    List<HImageLoadListener> loadListeners;

    public HImageView(Context context) {
        this(context, null);
    }

    public HImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        loadListeners = new ArrayList<>();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.v("HImage", "onAttach");
    }

    @Override
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        Log.v("HImage", "uri");
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        Log.v("HImage", "resource");
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        Log.v("HImage", "bitmap");
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        Log.v("HImage","drawable");
        for(HImageLoadListener loadListener:loadListeners){
            loadListener.onDrawableLoad(drawable);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.v("HImage", "onDraw");
    }

    public void setLoadListeners(HImageLoadListener loadListener){
        this.loadListeners.add(loadListener);
    }

    public void removeLoadListeners(HImageLoadListener loadListener){
        this.loadListeners.remove(loadListener);
    }

}
