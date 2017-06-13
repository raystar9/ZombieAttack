package test.gameengine.entity_like;

import android.graphics.Canvas;
import android.graphics.Rect;

import test.gameengine.BitmapManager;

import static test.gameengine.GameView.FRAME_RECTANGLE;

/**
 * Created by Koo on 2017-06-02.
 */

public class Field {        // TODO : Sight라는 클래스 이름 자체에 한계가 있음. 이름 재설정 및 그에따른 코드정리.

    private boolean isZombie = false;
    private Zombie _zombie;

    public Field() {
    }

    public void createZombie() {
        _zombie = new Zombie();
        _zombie.setSpeed(0, 5);
        _zombie.setExpendFactor(FRAME_RECTANGLE.width() / 100, FRAME_RECTANGLE.height() / 150);
        _zombie.setTime();
        isZombie = true;
    }

    public void drawZombie(Canvas canvas) {
        if(isZombie)
            _zombie.draw(canvas);
    }

    public void moveZombie() {
        if(isZombie)
            _zombie.move();
    }

    public boolean isAttacked() {
        if(isZombie) {
            if (_zombie.elapsedTime())
                return true;
        }
        return false;

    }

    public void removeZombie() {
        isZombie = false;
        _zombie = null;
    }

    public Rect getZombieRect() {
        if(isZombie) {
            return _zombie.getRectDst();
        }
        return new Rect();
    }

    public boolean hasZombie() {
        return isZombie;
    }

    public void hitZombie(int x, int y) {
        _zombie.loseHealth();

        drawHitImage(x, y);     //TODO : 타격 판정 및 타격 이미지 구현.
        if(_zombie.getHealthPoint() <= 0){
            removeZombie();
        }
    }

    private Entity drawHitImage(int x, int y) {
        Entity hitEntity = new Entity();
        hitEntity.setImage(BitmapManager.getHitImage());
        return hitEntity;
    }

    public void drawDamaged() {
        //TODO : 내가 맞을 때 피격 이미지를 띄워 줌.(약 0.5초)
    }
}
