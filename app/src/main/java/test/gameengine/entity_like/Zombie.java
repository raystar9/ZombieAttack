package test.gameengine.entity_like;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import test.gameengine.BitmapManager;

import static test.gameengine.GameView.FRAME_RECTANGLE;

/**
 * Created by Koo on 2017-06-02.
 */

public class Zombie extends Entity {    //TODO : 약간의 코드 정리 필요

    private Point _expendFactor;
    int LIVE_TIME = 5000;

    int healthPoint;

    private double _setTime;

    public Zombie() {
        setImage(BitmapManager.getZombieImage());

        final int FRAME_WIDTH = FRAME_RECTANGLE.width();
        final int FRAME_HEIGHT = FRAME_RECTANGLE.height();
        setSize(FRAME_WIDTH/2, FRAME_HEIGHT/3);
        _center = new Point();
        _center.x = FRAME_WIDTH/2;
        _center.y = FRAME_WIDTH*2/3;
        healthPoint = 7;
    }

    public void setTime() {
        _setTime = System.currentTimeMillis();
    }

    public boolean elapsedTime() {
        double currentTime = System.currentTimeMillis();
        double difference = currentTime - _setTime;
        if(difference > LIVE_TIME)
            return true;
        else
            return false;
    }

    public void setExpendFactor(Point expendFactor) {
        _expendFactor = expendFactor;
    }

    public void setExpendFactor(int x, int y) {
        Point point = new Point(x, y);
        setExpendFactor(point);
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    @Override
    public void move() {
        _center.y += _speed.y;
        _size.x += _expendFactor.x;
        _size.y += _expendFactor.y;

        setRectsByCenter();
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setAlpha(_alpha);
        canvas.drawBitmap(_image, _rectSrc, _rectDst, paint);
    }

    public void loseHealth() {
        healthPoint--;
    }
}
