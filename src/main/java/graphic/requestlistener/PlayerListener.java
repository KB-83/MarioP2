package graphic.requestlistener;

import logic.requsethandler.PlayerRequestHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerListener implements KeyListener {
    private PlayerRequestHandler playerRequestHandler;
    public PlayerListener(PlayerRequestHandler playerRequestHandler){
        this.playerRequestHandler = playerRequestHandler;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            playerRequestHandler.JumpRequest();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            playerRequestHandler.SeatRequest();
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
//        if(e.getKeyCode() == KeyEvent.VK_UP){
//            playerRequestHandler.JumpRequest();
//        }
//        if(e.getKeyCode() == KeyEvent.VK_DOWN){
//            playerRequestHandler.DownRequest();
//        }
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
