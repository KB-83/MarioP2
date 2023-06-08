package logic.requsethandler;

import graphic.guigamestructure.Camera;
import graphic.panel.GamePanel;
import logic.gamestrucure.GameState;
import logic.gamestrucure.gameworldoption.Gravity;
import logic.modelstructure.entity.player.JumpV0;
import logic.modelstructure.entity.player.Player;
import util.Constant;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class PlayerRequestHandler extends Request{
    private Player player;
    private GameState gameState;
    private int counter;
    private ActionListener jumpActionListener;
    private Timer jumpTimer;
    private double jumpStartTime;
    private int jumpStartY;

    public PlayerRequestHandler(GameState gameState) {
        this.player = gameState.getPlayer();
        this.gameState = gameState;
        setActonListeners();

    }

    public void JumpRequest(){
        if(gameState.isPaused() || player.isDuringJump()){
            return;
        }
        player.setDuringJump(true);
        jumpTimer = new Timer(1000/Constant.FPS,jumpActionListener);
        player.setImageAddress("JumpRight");
        setJumpDependencies();
        jumpTimer.start();

        System.out.println("jump request player request handler line 40");
    }
    private void setJumpDependencies(){
        jumpStartTime = System.currentTimeMillis();
        jumpStartY = player.getWorldY();
    }
    public void RightRequest(){
        if(gameState.isPaused()){
            return;
        }
        // todo : make section v=changing mechanisem alright
        if(player.getWorldX() >= Constant.PANEL_WIDTH){
            gameState.getGameStateController().changeSection();
            return;
        }
        // todo : check next line
        player.setCameraY(player.getWorldY());
        if(counter < 2){
            player.setImageAddress("Right1");
            counter++;
        }
        else if(counter < 4) {
            player.setImageAddress("Right2");
            counter++;
        }
        else {
            counter = 0;
        }
        player.setVX(400);

    }
    public void rightDoneRequest(){
        player.setVX(0);
    }
    public void LeftRequest(){
        if(gameState.isPaused()){
            return;
        }
        if(counter < 2){
            player.setImageAddress("Left1");
            counter++;
        }
        else if(counter < 4) {
            player.setImageAddress("Left2");
            counter++;
        }
        else {
            counter = 0;
        }
        //todo : improve it
        player.setVX(-400);
    }
    public void leftDoneRequest(){
        player.setVX(0);
    }

    public void DownRequest(){
        if(gameState.isPaused() || player.isDuringJump()){
            return;
        }
        player.setWorldY(player.getWorldY()+10);
        player.setCameraY(player.getCameraY()+10);
    }
    public void SwardRequest(){
        if(gameState.isPaused()){
            return;
        }
    }
    public void BulletRequest(){
        if(gameState.isPaused()){
            return;
        }
    }
    //todo : maybe pause request is for a user not a player
    public void PauseRequest(){
        System.out.println("pause request 70 player Request Handler");
        System.out.println(gameState.isPaused());
        gameState.setPaused(!gameState.isPaused());
    }
    public void setActonListeners() {
        //jumpActionListener
        jumpActionListener = new ActionListener() {
            double deltaY = 0.1;
            double t = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (player.isDuringJump()){
                    t = ( System.currentTimeMillis() - jumpStartTime) / 1000;
                    player.setVY ((-(Gravity.MARIO_GAME) * (t)) + JumpV0.MARIO.returnV0());
                    deltaY = -(((Gravity.MARIO_GAME/2)) * Math.pow(t, 2)) + (JumpV0.MARIO.returnV0() * t);
//                    int deltaT = (int) (System.currentTimeMillis()/1000 - t);
//                    System.out.println(player.getvY() * 60 / 1000+"----=vY");
//                    System.out.println("delta y :" + deltaY + "vy : " + player.getVY() * 60/1000);
//                    player.setWorldY((int) (player.getWorldY() - (player.getVY() * 1 / 60)));
//                    player.setCameraY((int) (player.getCameraY() - (player.getVY() * 1 / 60)));
//                    player.setWorldY((int) (jumpStartY - deltaY));
//                    player.setCameraY((int) (jumpStartY -deltaY));
                }
                else {
                    player.setVY(0);
                    deltaY = 0;
                    t = 0;
                    // here means jump completed
                    player.setImageAddress("Right1");
                    jumpTimer.stop();
                    player.setDuringJump(false);
                    System.out.println("in timer loop");
                }

            }};

    }



    @Override
    public Response returnResponse(String s){
//        Class c = playerController.getClass();
//        try {
//            Method m = c.getMethod(s.toLowerCase());
//            m.invoke(c.newInstance());
//        } catch (NoSuchMethodException | InvocationTargetException
//                 | IllegalAccessException | InstantiationException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }

    public Timer getJumpTimer() {
        return jumpTimer;
    }
}