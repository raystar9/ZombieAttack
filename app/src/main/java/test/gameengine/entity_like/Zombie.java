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

    public Zombie() {
        Bitmap zombieImage = BitmapManager.getZombieImage();
        setImage(zombieImage);

        rectSrc = new Rect();
        rectDst = new Rect();
        int width = FRAME_RECTANGLE.width();
        int height = FRAME_RECTANGLE.height();
        setSize(width/2, height/3);
        _center = new Point();
        _center.x = width/2;
        _center.y = width*2/3;
        healthPoint = 7;

    }
    private long _setTime;

    public void setTime() {
        _setTime = System.currentTimeMillis();
    }

    public boolean elapsedTime() {
        long currentTime = System.currentTimeMillis();
        long difference = currentTime - _setTime;
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
        rectSrc.set(0, 0, _image.getWidth(), _image.getHeight());
        rectDst.set(_center.x - _size.x/2, _center.y - _size.y/2,
                _center.x + _size.x/2, _center.y + _size.y/2);
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setAlpha(_alpha);
        canvas.drawBitmap(_image, rectSrc, rectDst, paint);
    }

    public void loseHealth() {
        healthPoint--;
    }
}
