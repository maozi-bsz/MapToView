package com.bsz.hanyue.maptoview.Utils;

import com.bsz.hanyue.maptoview.Model.Coordinate;

/**
 * Created by hanyue on 2015/7/26.
 */
public class CoordinateTranslator {

    public CoordinateTranslator() {
    }

    public Coordinate 屏幕坐标转图片坐标(Coordinate O, Coordinate screen, float scaleTimes) {
        Coordinate screenOToBitmapO = new Coordinate();
        screenOToBitmapO.setX((int) (screen.getX() / scaleTimes));
        screenOToBitmapO.setY((int) (screen.getY() / scaleTimes));
        Coordinate pointOnBitmap = new Coordinate();
        pointOnBitmap.setX(O.getX() + screenOToBitmapO.getX());
        pointOnBitmap.setY(O.getY() - screenOToBitmapO.getY());
        return pointOnBitmap;
    }

    public Coordinate 地理坐标转图片坐标(Coordinate geo, float scaleTimes) {
        Coordinate onBitmap = new Coordinate();
        onBitmap.setX((int) (geo.getX() / scaleTimes));//米每像素
        onBitmap.setY((int) (geo.getY() / scaleTimes));
        return onBitmap;
    }

    public Coordinate 图片坐标转地理坐标(Coordinate bitmap, float scaleTimes) {
        Coordinate onGeo = new Coordinate();
        onGeo.setX((int) (bitmap.getX() * scaleTimes));
        onGeo.setY((int) (bitmap.getY() * scaleTimes));
        return onGeo;
    }

    public Coordinate O点坐标(Coordinate oldO, int dx, int dy, float scaleTimes) {
        Coordinate O = new Coordinate();
        O.setX(oldO.getX() + (int) (dx / scaleTimes));
        O.setY(oldO.getY() + (int) (dy / scaleTimes));
        return O;
    }
}
