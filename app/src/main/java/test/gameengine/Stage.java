package test.gameengine;

import java.util.Vector;

/**
 * Created by koo on 17. 6. 26.
 */

public class Stage {
    private Timer _timer;
    Vector<Field> _fields;
    boolean[] _isZombieCreatedAt = new boolean[20];

    int _finalStage;

    public Stage(Vector<Field> fields) {
        _fields = fields;
        for (int i = 0; i < 20; i++) {
            _isZombieCreatedAt[i] = false;
        }
        _timer = new Timer(60000);
    }

    void setFinalStage(int finalStage) {
        _finalStage = finalStage;
    }

    public void runStage(int stageNumber) {

        switch (stageNumber) {
            case 1:
                stage1();
                break;
            default:
                gameClear();
                break;
        }
    }

    private void createZombie(int location, double time, int order) {
        if (_timer.getElapsedTime() > time && !_isZombieCreatedAt[order]) {
            _isZombieCreatedAt[order] = true;
            _fields.elementAt(location - 1).createZombie();
        }
    }

    private void stage1() {
        if (_timer.getElapsedTime() < 60000) {
            createZombie(1, 2000, 0);
            createZombie(2, 3000, 1);
            createZombie(3, 4000, 2);
            createZombie(1, 8000, 3);
        } else {
            stageClear();
        }
    }

    private void stageClear() {

    }

    private void gameClear() {
    }


}
