package test.gameengine;

import android.graphics.Canvas;

import test.gameengine.entity_like.Entity;

import static test.gameengine.GameView.FRAME_RECTANGLE;

/**
 * Created by Koo on 2017-06-02.
 */

public class UserInterface {
    private final int MAX_HEART = 3;
    private Entity leftButton;
    private Entity rightButton;
    private Entity[] hearts;
    private Entity _backGround;

    UserInterface() {   //TODO : background를 UI에서 분리해야 함.
        _backGround = new Entity();
        _backGround.setImage(BitmapManager.getBackGroundImage());

        _backGround.setPosition(0, 0);
        _backGround.setSize(FRAME_RECTANGLE.width(), FRAME_RECTANGLE.height());

        int width = FRAME_RECTANGLE.width();
        int height = FRAME_RECTANGLE.height();

        leftButton = new Entity();
        rightButton = new Entity();

        hearts = new Entity[MAX_HEART];
        for (int i = 0; i < MAX_HEART; i++) {
            hearts[i] = new Entity();
            hearts[i].setImage(BitmapManager.getHeartImage());
            hearts[i].setSize(width/7, width/7);
        }
        leftButton.setImage(BitmapManager.getLeftButtonImage());
        rightButton.setImage(BitmapManager.getRightButtonImage());

        leftButton.setSize(width/2, height/10);
        rightButton.setSize(width/2, height/10);

        leftButton.setPosition(0, height*9/10 + 1);
        rightButton.setPosition(width/2, height*9/10 + 1);
        hearts[0].setPosition(width*5/6, height*9/10 + 1 - width/6);
        hearts[1].setPosition(width*4/6, height*9/10 + 1 - width/6);
        hearts[2].setPosition(width*3/6, height*9/10 + 1 - width/6);
    }

    public Entity getLeftButton() {
        return leftButton;
    }

    public Entity getRightButton() {
        return rightButton;
    }

    public void drawBackGround(Canvas canvas) {
        _backGround.draw(canvas);
    }
    public void draw(Canvas canvas) {


        leftButton.draw(canvas);
        rightButton.draw(canvas);
        for (int i = 0; i < MAX_HEART; i++) {
            hearts[i].draw(canvas);
        }
    }


    public void emptyHeart(int life) {
        hearts[life-1].setImage(BitmapManager.getEmptyHeartImage());
    }
}