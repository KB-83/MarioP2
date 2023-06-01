package logic.requsethandler;

import graphic.guigamestructure.Camera;
import logic.modelcontroller.PlayerController;
import logic.modelstructure.entity.player.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class PlayerRequestHandler extends Request{
    private Player player;
    private int counter;

    public PlayerRequestHandler(Player player) {
        this.player = player;
    }

    public void JumpRequest(){
        int time;
        int xV;
        int yV;
        int g;
        int m;
//        returnResponse("JUMP");
        System.out.println("jump request");
        System.out.println(player.getWorldX()+"----line 26 player request handler");
    }
    public void RightRequest(){
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
        player.setWorldX(player.getWorldX()+6);
        System.out.println(player.getCameraX()+"----line 32 player request handler");
//        player.setX(player.getX()+4);
//        returnResponse("RIGHT");
        // todo : handle it in logic




    }
    public void LeftRequest(){
        player.setWorldX(player.getWorldX()-20);
    }
    public void DownRequest(){}
    public void SwardRequest(){}
    public void BulletRequest(){}
    //todo : maybe pause request is for a user not a player
    public void PauseRequest(){}



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