package test.gameengine;

import android.graphics.Canvas;
import android.graphics.Rect;

import test.gameengine.entity_like.Zombie;

/**
 * Created by Koo on 2017-06-02.
 */

public class Field {

    private boolean _isZombie = false;
    private Zombie _zombie;

    public Field() {
    }

    public void createZombie() {
        _zombie = new Zombie(5000);
        _isZombie = true;
    }

    public void drawZombie(Canvas canvas) {
        if(_isZombie)
            _zombie.draw(canvas);
    }

    public void moveZombie() {
        if(_isZombie)
            _zombie.move();
    }

    public boolean zombieAttacked() {
        if(_isZombie) {
            if (_zombie.elapsedTime())
                return true;
        }
        return false;

    }

    public void removeZombie() {
        _isZombie = false;
        _zombie = null;
    }

    public Rect getZombieRect() {
        if(_isZombie) {
            return _zombie.getRectDst();
        }
        return new Rect();
    }

    public boolean hasZombie() {
        return _isZombie;
    }

    public void hitZombie(int x, int y) {
        _zombie.loseHealth();
        if(_zombie.getHealthPoint() <= 0){
            removeZombie();
        }
    }

    public void drawDamaged() {
        //TODO : 내가 맞을 때 피격 이미지를 띄워 줌.(약 0.5초)
    }
}
