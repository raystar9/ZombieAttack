package test.gameengine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Koo on 2017-06-02.
 */

public class TitleView extends SurfaceView implements SurfaceHolder.Callback {  //현재 실행 불가
    public TitleView(Context context) {
        super(context);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
    }

    Rect rectFrame;
    Canvas _canvas;
//    TitleThread _titleThread;

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
//        _titleThread = new TitleThread(holder, getResources());
//        _titleThread.run();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
/*
    class TitleThread extends Thread {

        SurfaceHolder _holder;
        Resources _res;

        TitleThread(SurfaceHolder holder, Resources res) {
            _holder = holder;
            _res = res;
            setImage();
        }

        Entity titleImage = new Entity();
        Entity bgImage = new Entity();
        Entity startImage = new Entity();
        Entity quitImage = new Entity();
        Resources res = getResources();

        void setImage() {
            titleImage.setImage(res, R.drawable.title);
            bgImage.setImage(res, R.drawable.bg);
            startImage.setImage(res, R.drawable.start);
            quitImage.setImage(res, R.drawable.quit);
        }

        @Override
        public void run() {
            super.run();

            _canvas = _holder.lockCanvas();
            bgImage.draw(_canvas);
            titleImage.draw(_canvas);

            draw(_canvas);

            _holder.unlockCanvasAndPost(_canvas);
        }
    }*/
}
