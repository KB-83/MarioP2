package graphic.requestlistener;

import logic.requsethandler.PlayerRequestHandler;

import javax.swing.*;
import java.awt.event.*;

public class PlayerListener implements KeyListener {
    private PlayerRequestHandler playerRequestHandler;
    private boolean isUpPressed, isDownPressed;
    private boolean isDuringSwardChecking;
    private Timer swardRequestTimer;
    private Timer letPlayerPressBothKeys;
    private boolean isDuringLetPlayerPressBothKeys;
    private long startPressingUpAndDown;
    private long lastSwardRequest;
    public PlayerListener(PlayerRequestHandler playerRequestHandler){
        this.playerRequestHandler = playerRequestHandler;
        isDuringSwardChecking = false;
        letPlayerPressBothKeys = new Timer(100, new ActionListener() {
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i<1){
                    isDuringLetPlayerPressBothKeys = true;
                    i++;
                }
                else {
                    i = 0;
                    isDuringLetPlayerPressBothKeys = false;
                    letPlayerPressBothKeys.stop();
                    if(isDownPressed && isUpPressed){
                        isDuringSwardChecking = true;
                        startSwardRequestTimer();
                    }
                    else if (isUpPressed){playerRequestHandler.jumpRequest();}
                    else if (isDownPressed){playerRequestHandler.SeatRequest();}

                }
            }
        });
    }
    private void startSwardRequestTimer(){
        startPressingUpAndDown = System.currentTimeMillis();
        swardRequestTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isUpPressed && isDownPressed && System.currentTimeMillis() - startPressingUpAndDown >= 1000){
                    playerRequestHandler.SwardRequest();
                    swardRequestTimer.stop();
                    swardRequestTimer = null;
                    isDuringSwardChecking = false;
                    lastSwardRequest = System.currentTimeMillis();
                }
                else if (!(isUpPressed && isDownPressed)){
                    swardRequestTimer.stop();
                    swardRequestTimer = null;
                    isDuringSwardChecking = false;
                }
            }
        });
        swardRequestTimer.start();

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (isDuringSwardChecking){
            return;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            isUpPressed = true;
            letPlayerPressBothKeys.start();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            isDownPressed = true;
            if(!isDuringLetPlayerPressBothKeys) {
                letPlayerPressBothKeys.start();
            }
        }
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
        if(e.getKeyCode() == KeyEvent.VK_UP || System.currentTimeMillis() - lastSwardRequest < 500){
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
