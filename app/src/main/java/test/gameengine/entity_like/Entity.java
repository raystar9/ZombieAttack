package test.gameengine.entity_like;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Koo on 2017-05-30.
 */

public class Entity {   //TODO : Entity는 클릭 불가능한 이미지만을 구현하도록 정리. 추상 클래스로 만들고 싶었으나...

    Point _position = new Point(0,0);
    Point _speed    = new Point(0,0);
    Point _size     = new Point(0,0);
    Point _center   = new Point(0,0);
    Bitmap _image;
    int _alpha = 255;

    Rect rectSrc    = new Rect();
    Rect rectDst   = new Rect();
    Paint paint     = new Paint();

    public Point getPosition() {
        return _position;
    }

    public void setPosition(Point position) {
        _position = position;
    }

    public Point getSpeed() {
        return _speed;
    }

    public void setSpeed(Point speed) {
        _speed = speed;
    }

    public Point getSize() {
        return _size;
    }

    public void setSize(Point size) {
        _size = size;
    }

    public Bitmap getImage() {
        return _image;
    }

    public void setImage(Bitmap image) {
        _image = image;
    }

    public void setPosition(int x, int y) {
        this._position.set(x, y);
        this._center.set(x + _size.x/2, y + _size.y/2);
    }

    public void setSize(int width, int height) {
        this._size.set(width, height);
    }

    public Rect getRectSrc() {
        return rectSrc;
    }

    public Rect getRectDst() {
        return rectDst;
    }

    public Point getCenter() {
        Point point = new Point();
        point.x = _position.x + _size.x/2;
        point.y = _position.y + _size.y/2;
        return point;
    }

    public void draw(Canvas canvas) {
        rectSrc.set(0, 0, _image.getWidth(), _image.getHeight());
        rectDst.set(_position.x, _position.y, _position.x + _size.x, _position.y + _size.y);

        paint.setAlpha(_alpha);
        canvas.drawBitmap(_image, rectSrc, rectDst, paint);
    }
    public void drawAtCenter(Canvas canvas) {
        rectSrc.set(0, 0, _image.getWidth(), _image.getHeight());
        rectDst.set(_center.x - _size.x/2, _center.y - _size.y/2,
                _center.x + _size.x/2, _center.y + _size.y/2);

        paint.setAlpha(_alpha);
        canvas.drawBitmap(_image, rectSrc, rectDst, paint);
    }

    public void setSpeed(int x, int y) {
        this._speed.set(x, y);
    }

    public void move() {
        _position.x += _speed.x;
        _position.y += _speed.y;
        _center.x += _speed.x;
        _center.y += _speed.y;
    }

}
