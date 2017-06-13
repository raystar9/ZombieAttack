package test.gameengine;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import static test.gameengine.GameView.GAME_RESOURSE;

/**
 * Created by koo on 17. 6. 13.
 */

public class BitmapManager {

    private static Bitmap removeColor(Bitmap bitmap) {
        int size = bitmap.getWidth()*bitmap.getHeight();
        int removeColor = Color.rgb(255,200,200);
        int[] array = new int[size];
        bitmap.getPixels(array,0,bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        for (int i = 0; i < array.length; i++) {
            if(array[i] == removeColor){
                array[i] = Color.TRANSPARENT;
            }
        }
        return Bitmap.createBitmap(array, 0, bitmap.getWidth(),
                bitmap.getWidth(), bitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
    }

    public static Bitmap getZombieImage() {
        Bitmap zombieImage = BitmapFactory.decodeResource(GAME_RESOURSE, R.drawable.zombie);
        zombieImage = removeColor(zombieImage);
        return zombieImage;
    }

    public static Bitmap getBackGroundImage() {
        Bitmap backGroundImage = BitmapFactory.decodeResource(GAME_RESOURSE, R.drawable.bg_cloud);
        return backGroundImage;
    }

    public static Bitmap getHeartImage() {
        Bitmap heartImage = BitmapFactory.decodeResource(GAME_RESOURSE, R.drawable.heart);
        heartImage = removeColor(heartImage);
        return heartImage;
    }

    public static Bitmap getEmptyHeartImage() {
        Bitmap emptyHeartImage = BitmapFactory.decodeResource(GAME_RESOURSE, R.drawable.empty_heart);
        emptyHeartImage = removeColor(emptyHeartImage);
        return emptyHeartImage;
    }

    public static Bitmap getLeftButtonImage() {
        Bitmap leftButtonImage = BitmapFactory.decodeResource(GAME_RESOURSE, R.drawable.arrow_left);
        return leftButtonImage;
    }

    public static Bitmap getRightButtonImage() {
        Bitmap rightButtonImage = BitmapFactory.decodeResource(GAME_RESOURSE, R.drawable.arrow_right);
        return rightButtonImage;
    }

    public static Bitmap getHitImage() {
        Bitmap hitImage = BitmapFactory.decodeResource(GAME_RESOURSE, R.drawable.hit);
        hitImage = removeColor(hitImage);
        return hitImage;
    }
}
