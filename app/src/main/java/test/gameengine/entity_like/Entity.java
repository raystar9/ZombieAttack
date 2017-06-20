package test.gameengine.entity_like;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Koo on 2017-05-30.
 */

public class Entity { //TODO : Entity는 클릭 불가능한 이미지만을 구현하도록 정리. 추상 클래스로 만들고 싶었으나...

    Point _position = new Point(0, 0);
    Point _speed = new Point(0, 0);
    Point _size = new Point(0, 0);
    Point _center = new Point(0, 0);
    Bitmap _image;
    int _alpha = 255;

    Rect _rectSrc = new Rect();
    Rect _rectDst = new Rect();
    Paint paint = new Paint();

    double _setTime;
    double _elapseTime;

    Entity(){
    }

    public Entity(Bitmap image, Point size, Point position) {
        this(image, size.x, size.y, position.x, position.y, -1);
    }

    public Entity(Bitmap image, Point size, Point position, double elapseTimeMills) {
        this(image, size.x, size.y, position.x, position.y, elapseTimeMills);
    }

    public Entity(Bitmap image, int width, int height, int positionX, int positionY) {
        this(image, width, height, positionX, positionY, -1);
    }

    public Entity(Bitmap image, int width, int height, int positionX, int positionY, double elapseTimeMills) {
        _image = image;
        _size.set(width, height);
        _position.set(positionX, positionY);
        _elapseTime = elapseTimeMills;
        _center.set(positionX + width/2, positionY + height/2);

        setRects();
        if(elapseTimeMills != -1){
            setTime();

        }
        else {
        }
    }

    //region getter & setter
    public Point getPosition() {
        return _position;
    }

    public void setPosition(Point position) {
        _position = position;
    }

    public void setPosition(int x, int y) {
        this._position.set(x, y);
        setCenter(x, y);
        setRects();
    }

    private void setCenter(int x, int y) {
        this._center.set(x + _size.x / 2, y + _size.y / 2);
    }

    public Point getCenter() {
        Point point = new Point();
        point.x = _position.x + _size.x / 2;
        point.y = _position.y + _size.y / 2;
        return point;
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
        setSize(size.x, size.y);
    }

    public void setSize(int width, int height) {
        this._size.set(width, height);
        setRects();
    }

    public Bitmap getImage() {
        return _image;
    }

    public void setImage(Bitmap image) {
        _image = image;
    }

    public Rect getRectSrc() {
        return _rectSrc;
    }

    public Rect getRectDst() {
        return _rectDst;
    }

    void setRects() {
        _rectSrc.set(0, 0, _image.getWidth(), _image.getHeight());
        _rectDst.set(_position.x, _position.y, _position.x + _size.x, _position.y + _size.y);
    }

    void setRectsByCenter() {
        _rectSrc.set(0, 0, _image.getWidth(), _image.getHeight());
        _rectDst.set(_center.x - _size.x / 2, _center.y - _size.y / 2,
                _center.x + _size.x / 2, _center.y + _size.y / 2);
    }
    //endregion

    public void setTime() {
        _setTime = System.currentTimeMillis();
    }

    public boolean elapsedTime() {
        double currentTime = System.currentTimeMillis();
        double difference = currentTime - _setTime;
        if(difference > _elapseTime)
            return true;
        else
            return false;
    }

    public void draw(Canvas canvas) {
        paint.setAlpha(_alpha);
        canvas.drawBitmap(_image, _rectSrc, _rectDst, paint);
    }

    public void drawAtCenter(Canvas canvas) {
        _rectDst.set(_position.x - _size.x/2, _position.y - _size.y/2,
                _position.x + _size.x/2, _position.y + _size.y/2);

        paint.setAlpha(_alpha);
        canvas.drawBitmap(_image, null, _rectDst, paint);
    }

    public void setSpeed(int x, int y) {
        this._speed.set(x, y);
    }

    public void move() {
        _position.x += _speed.x;
        _position.y += _speed.y;
        _center.x += _speed.x;
        _center.y += _speed.y;

        setRects();
    }

}
