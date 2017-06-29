package test.gameengine;

import android.graphics.Canvas;
import android.graphics.Rect;

import test.gameengine.entityLike.Entity;

import static test.gameengine.GameView.FRAME_RECTANGLE;

/**
 * Created by Koo on 2017-06-02.
 */

public class UserInterface {
    private final int MAX_HEART = 3;
    private Entity _leftButton;
    private Entity _rightButton;
    private Entity[] _hearts;
    private Entity _hit;

    UserInterface() {
        int width = FRAME_RECTANGLE.width();
        int height = FRAME_RECTANGLE.height();

        _leftButton = new Entity(
                BitmapHolder.getLeftButtonImage(),
                width/2, height/10,
                0, height*9/10 + 1);
        _rightButton = new Entity(
                BitmapHolder.getRightButtonImage(),
                width/2, height/10,
                width/2, height*9/10 + 1);

        _hearts = new Entity[MAX_HEART];
        for (int i = 0; i < MAX_HEART; i++) {
            _hearts[i] = new Entity(
                    BitmapHolder.getHeartImage(),
                    width/7, width/7,
                    0, 0);
        }
        _hearts[0].setPosition(width*5/6, height*9/10 + 1 - width/6);
        _hearts[1].setPosition(width*4/6, height*9/10 + 1 - width/6);
        _hearts[2].setPosition(width*3/6, height*9/10 + 1 - width/6);
    }

    public Rect getLeftButtonRect() {
        return _leftButton.getRectDst();
    }

    public Rect getRightButtonRect() {
        return _rightButton.getRectDst();
    }

    public void setHitImage(int x, int y) {
        Entity hitEntity = new Entity(
                BitmapHolder.getHitImage(),
                150, 150,
                x, y,
                100);
        _hit = hitEntity;
    }

    public void draw(Canvas canvas) {
        _leftButton.draw(canvas);
        _rightButton.draw(canvas);
        if(_hit != null){
            if(!_hit.isLifeTimeEnded()){
                _hit.drawAtCenter(canvas);
            }
            else{
                _hit = null;
            }
        }
        for (int i = 0; i < MAX_HEART; i++) {
            _hearts[i].draw(canvas);
        }
    }

    public void emptyHeart(int life) {
        _hearts[life-1].setImage(BitmapHolder.getEmptyHeartImage());
    }
}
