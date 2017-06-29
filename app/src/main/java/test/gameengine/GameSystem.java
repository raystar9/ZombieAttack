package test.gameengine;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.widget.Toast;

import java.util.Vector;

/**
 * Created by Koo on 2017-05-30.
 */

public class GameSystem extends Thread {
    private Stage _stage;
    String TAG = "gameSystem";

    private UserInterface _userInterface;
    private SurfaceHolder _surfaceHolder;

    private boolean haveToStop = false;

    Vector<Field> _fields = new Vector<>();
    Field _currentField;
    private int _fieldIndex = 1;
    private int _currentStage = 1;
    private int _healthPoint;

    public GameSystem(SurfaceHolder holder) {

        _surfaceHolder = holder;
        _userInterface = new UserInterface();
        _healthPoint = 3;

        for (int i = 0; i < 3; i++) {
            Field field = new Field();
            _fields.add(field);
        }
        _stage = new Stage(_fields);
        _currentField = _fields.elementAt(_fieldIndex);

//        _currentField.createZombie();
    }

    public void on() {
        this.start();
    }

    public void off() {
        this.haveToStop = true;
    }

    @Override
    public void run() {
        super.run();

        try {
            sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!haveToStop) {
            _stage.runStage(_currentStage);
            // 화면 잠그기
            Canvas canvas = _surfaceHolder.lockCanvas();
            // 화면 그리기
            draw(canvas);
            // 화면 풀기
            _surfaceHolder.unlockCanvasAndPost(canvas);
            // 게임 진행시키기
            update();
        }
    }

    private void update() {
        for (Field field : _fields) {
            field.moveZombie();
            if (field.zombieAttacked()) {
                field.removeZombie();
                field.drawDamaged();
                loseHealth();
            }
        }
    }

    private void draw(Canvas canvas) {
        _currentField.drawBackGround(canvas);
        _currentField.drawZombie(canvas);
        _userInterface.draw(canvas);
    }

    private void loseHealth() {
        _userInterface.emptyHeart(_healthPoint);
        _healthPoint--;
    }

    public void screenTouchedAt(int x, int y) {
        if(_userInterface.getLeftButtonRect().contains(x, y)){
            if(_fieldIndex > 0)
            _currentField = _fields.elementAt(--_fieldIndex);
            else{
                Log.d(TAG, "Left End");
            }
        }

        else if(_userInterface.getRightButtonRect().contains(x, y)){
            if(_fieldIndex < _fields.size() - 1)
                _currentField = _fields.elementAt(++_fieldIndex);
            else{
                Log.d(TAG, "Right End");
            }
        }

        else if (_currentField.getZombieRect().contains(x, y)) {
            _userInterface.setHitImage(x, y);
            _currentField.hitZombie(x, y);
        }
    }
}
