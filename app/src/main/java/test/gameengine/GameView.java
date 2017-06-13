package test.gameengine;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Koo on 2017-05-30.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    public static Rect FRAME_RECTANGLE;         //TODO : Frame의 크기정보와 Resourse정보는 다양한 곳에서 필요로 함.
    public static Resources GAME_RESOURSE;      //TODO : 하지만 그렇다고 static 변수로 만드는 것이 옳은 지
                                                //TODO : 다시 생각해 볼 필요가 있음.
    private String TAG = "GameView";
    GameSystem gameSystem;

    public GameView(Context context) {
        super(context);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        FRAME_RECTANGLE = new Rect(0,0,getWidth(), getHeight());
        GAME_RESOURSE = getResources();

        gameSystem = new GameSystem(holder);
        gameSystem.on();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        gameSystem.off();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        gameSystem.onTouchScreen(x, y);
        return false;
    }
}
