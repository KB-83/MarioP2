package logic.requsethandler;

import logic.gamestrucure.GameState;
import logic.gamestrucure.gameworldoption.Gravity;
import logic.levelstructure.Section;
import logic.modelstructure.backgroundobject.pipe.*;
import logic.modelstructure.entity.player.JumpV0;
import logic.modelstructure.entity.player.Player;
import util.Constant;

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
    //todo: behtareh inaro be logic game pass bede

    public PlayerRequestHandler(GameState gameState) {
        this.player = gameState.getPlayer();
        player.setPlayerRequestHandler(this);
        this.gameState = gameState;
        setActonListeners();

    }

    public void JumpRequest(){
        if(gameState.isPaused() || player.isDuringJump()){
            return;
        }
        player.setDuringJump(true);
        jumpTimer = new Timer(1000/Constant.FPS,jumpActionListener);
        setPlayerImageByState("JumpRight");
        setJumpDependencies();
        jumpTimer.start();
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
            gameState.getGameStateController().nextSection();
            return;
        }
        // todo : check next line
        player.setCameraY(player.getWorldY());
        if(counter < 2){
            setPlayerImageByState("Right1");
            counter++;
        }
        else if(counter < 4) {
            setPlayerImageByState("Right2");
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
            setPlayerImageByState("Left1");
            counter++;
        }
        else if(counter < 4) {
            setPlayerImageByState("Left2");
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

    public void SeatRequest(){
        if(gameState.isPaused() || player.isDuringJump()){
            return;
        }
        //todo ; just a test
        if (player.getPlayerCollisionHandler().isOnTopOfTelePipe() != null) {
            System.out.println("106 player request handler");
            Pipe pipe = player.getPlayerCollisionHandler().isOnTopOfTelePipe();
            String s = pipe.getClass().getSimpleName();
            if (s.equals("TelePlantPipe")) {
                gameState.getGameStateController().changeSection(((TelePlantPipe) pipe).getTeleSection());
            }
            else if(s.equals("SimpleTelePipe")) {
                gameState.getGameStateController().changeSection(((SimpleTelePipe) pipe).getTeleSection());
            }
            else if(s.equals("SimpleSpawnPipe")) {
                gameState.getGameStateController().changeSection(((SimpleSpawnPipe) pipe).getSection());
            }
            else if(s.equals("SpawnPlantPipe")) {
                gameState.getGameStateController().changeSection(((SpawnPlantPipe) pipe).getSection());
            }
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
                }
                else {
                    player.setVY(0);
                    deltaY = 0;
                    t = 0;
                    // here means jump completed
                    setPlayerImageByState("Right1");
                    jumpTimer.stop();
                    player.setDuringJump(false);
                }

            }};

    }
    private void setPlayerImageByState(String s) {
        if (player.isFire()){
            player.setImageAddress("2"+s);
        }
        else if (player.isMega()){
            player.setImageAddress("1"+s);
        }
        else {
            player.setImageAddress("0"+s);
        }
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