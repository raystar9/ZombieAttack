package test.gameengine.entity_like;

import android.graphics.Canvas;
import android.graphics.Point;

import test.gameengine.BitmapHolder;

import static test.gameengine.GameView.FRAME_RECTANGLE;

/**
 * Created by Koo on 2017-06-02.
 */

public class Zombie extends Entity {    //TODO : 약간의 코드 정리 필요

    private Point _expendFactor;

    int healthPoint;

    public Zombie(double elapseTimeMills) {
        _image = BitmapHolder.getZombieImage();

        final int FRAME_WIDTH = FRAME_RECTANGLE.width();
        final int FRAME_HEIGHT = FRAME_RECTANGLE.height();
        setSize(FRAME_WIDTH/2, FRAME_HEIGHT/3);
        _center = new Point();
        _center.x = FRAME_WIDTH/2;
        _center.y = FRAME_WIDTH*2/3;
        healthPoint = 7;
        _elapseTime = elapseTimeMills;
        setSpeed(0, 5);
        setExpendFactor(FRAME_RECTANGLE.width() / 100, FRAME_RECTANGLE.height() / 150);
        setTime();
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
