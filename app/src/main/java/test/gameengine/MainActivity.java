package test.gameengine;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        TitleView titleView = new TitleView(this);
//        setContentView(titleView);    // TODO : 다른 뷰를 쓰레드 없이, 혹은 별도의 쓰레드로 실행
        GameView gameView = new GameView(this);
        setContentView(gameView);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
