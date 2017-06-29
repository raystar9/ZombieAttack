package test.gameengine;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {

    GameView _gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(titleView);    // TODO : 다른 뷰를 쓰레드 없이, 혹은 별도의 쓰레드로 실행
        _gameView = new GameView(this);
        setContentView(_gameView);
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        GameSystem.getInstance().off();
//    }
}
