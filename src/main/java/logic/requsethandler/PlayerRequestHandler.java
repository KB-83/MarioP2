package logic.requsethandler;

import graphic.guigamestructure.Camera;
import graphic.panel.GamePanel;
import logic.gamestrucure.GameState;
import logic.modelcontroller.PlayerController;
import logic.modelstructure.entity.player.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class PlayerRequestHandler extends Request{
    private Player player;
    private GameState gameState;
    private int counter;

    public PlayerRequestHandler(GameState gameState) {
        this.player = gameState.getPlayer();
        this.gameState = gameState;
    }

    public void JumpRequest(){
        if(gameState.isPaused()){
            return;
        }
        int time;
        int xV;
        int yV;
        int g;
        int m;
//        returnResponse("JUMP");
        System.out.println("jump request");
        System.out.println(player.getWorldX()+"----line 26 player request handler");

        player.setWorldY(player.getWorldY()-4);
        player.setCameraY(player.getCameraY()-4);
    }
    public void RightRequest(){
        if(gameState.isPaused()){
            return;
        }
        if(counter<=12){
            player.setImageAddress("Right1");
            counter++;
        }
        else if(counter < 26) {
            player.setImageAddress("Right2");
            counter++;
        }
        else {
            counter = 0;
        }
        System.out.println("rightrequest");
//        player.setCameraX(player.getCameraX()+4);
        player.setWorldX(player.getWorldX()+16);
        System.out.println(player.getCameraX()+"----line 32 player request handler");
//        player.setX(player.getX()+4);
//        returnResponse("RIGHT");
        // todo : handle it in logic




    }
    public void LeftRequest(){
        if(gameState.isPaused()){
            return;
        }
        player.setWorldX(player.getWorldX()-20);
    }
    public void DownRequest(){
        if(gameState.isPaused()){
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

}