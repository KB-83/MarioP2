package graphic.requestlistener;

import logic.requsethandler.PlayerRequestHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestPlayerListener implements KeyListener {
    private PlayerRequestHandler playerRequestHandler;
    private boolean isUpPressed, isDownPressed;
    private boolean isDuringSwardChecking;
    private Timer swardRequestTimer;
    private Timer letPlayerPressBothKeys;
    private long startPressingUpAndDown;
    public TestPlayerListener(PlayerRequestHandler playerRequestHandler){
        this.playerRequestHandler = playerRequestHandler;
        isDuringSwardChecking = false;
        startSwardRequestTimer();
    }
    private void startSwardRequestTimer(){
            startPressingUpAndDown = System.currentTimeMillis();
            swardRequestTimer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isUpPressed && isDownPressed && System.currentTimeMillis() - startPressingUpAndDown >= 3000){
                        playerRequestHandler.SwardRequest();
                        swardRequestTimer.stop();
                        swardRequestTimer = null;
                        isDuringSwardChecking = false;
                    }
                    else if (!(isUpPressed && isDownPressed)){
                        swardRequestTimer.stop();
                        swardRequestTimer = null;
                        isDuringSwardChecking = false;
                    }
                }
            });
        letPlayerPressBothKeys = new Timer(100, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i<5){
                    i++;
                }
                else {
                    i = 0;
                    letPlayerPressBothKeys.stop();
                    if(isDownPressed && isUpPressed){
                        swardRequestTimer.start();
                    }
                    else if (isUpPressed){playerRequestHandler.jumpRequest();}
                    else if (isDownPressed){playerRequestHandler.SeatRequest();}

                }
            }
        });
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            playerRequestHandler.jumpRequest();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            playerRequestHandler.SeatRequest();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (isDuringSwardChecking){
            return;
        }
//        if(e.getKeyCode() == KeyEvent.VK_UP){
//            isUpPressed = true;
//            letPlayerPressBothKeys.start();
//        }
//        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
//            isDownPressed = true;
//        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            playerRequestHandler.RightRequest();
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            playerRequestHandler.LeftRequest();
        }
        else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
            playerRequestHandler.BulletRequest();
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            playerRequestHandler.PauseRequest();
        }
        //Todo : add swan timer request too

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            isUpPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            isDownPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            playerRequestHandler.rightDoneRequest();
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            playerRequestHandler.leftDoneRequest();
        }
//        else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
//            playerRequestHandler.BulletRequest();
//        }
//        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
//            playerRequestHandler.PauseRequest();
//        }
    }
}
