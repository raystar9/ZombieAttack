package test.gameengine;

/**
 * Created by koo on 17. 6. 26.
 */

public class Timer {

    private double _setTime;
    private double _lifeTime;

    public Timer(double lifeTime){
        _setTime = System.currentTimeMillis();
        _lifeTime = lifeTime;
    }

    public double getElapsedTime(){
        return System.currentTimeMillis() - _setTime;
    }

    public boolean isEnded(){
        double currentTime = System.currentTimeMillis();
        double difference = currentTime - _setTime;
        if(difference > _lifeTime)
            return true;
        else
            return false;
    }
}
