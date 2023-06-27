package logic.modelstructure.entity.enemy;

import util.Constant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Plant extends Enemy{
    private Timer timer;
    private boolean timerStarted;
    public Plant() {
        setTimer();
        setHeight(Constant.BACKGROUND_TILE_SIZE);
        setWidth(Constant.BACKGROUND_TILE_SIZE);
//        setVY(200);
        setAlive(true);
        timerStarted = false;
//        timer.start();
    }
    private void setTimer(){
        timer = new Timer(1000, new ActionListener() {
            int up = 0;
            int down = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                timerStarted = true;
                if (isAlive()) {
                    if (up < 3){
                        up++;
                        setVY(-80);
                    }
                    else {
                        if (down< 4) {
                            setVY(60);
                            down++;
                        }
                        else {
                            up = 0;
                            down = 0;
                        }
                    }
                }
                else {
                    timer.stop();
                }
            }
        });
        timer.start();
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public boolean isTimerStarted() {
        return timerStarted;
    }

    public void setTimerStarted(boolean timerStarted) {
        this.timerStarted = timerStarted;
    }
}
