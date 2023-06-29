package logic.modelstructure.entity;

import logic.modelstructure.entity.player.V;
import util.Constant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bullet extends Entity {
    private boolean isLock;
    private long lastTime;
    private int startX;
    private Timer timer;
    public Bullet() {
        addActionListeners();
        lastTime = System.currentTimeMillis();
        setLock(true);
        setWidth(35);
        setHeight(35);
    }
    public void addActionListeners() {
        timer = new Timer(1000/Constant.FPS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getWorldX() - startX <= 8 * Constant.BACKGROUND_TILE_SIZE){
                    setWorldX(getWorldX()+(V.Mario.returnV()/Constant.FPS));
                    setLastTime(System.currentTimeMillis());
                }
                else {
                    setVX(0);
                    setLock(true);
                    setLastTime(System.currentTimeMillis());
                    timer.stop();

                }
            }
        });
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
