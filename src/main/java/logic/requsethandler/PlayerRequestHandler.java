package logic.requsethandler;

import graphic.guigamestructure.Camera;
import logic.modelcontroller.PlayerController;
import logic.modelstructure.entity.player.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class PlayerRequestHandler extends Request{
    private Player player;

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
    }
    public void RightRequest(){
        System.out.println("rightrequest");
        player.setCameraX(player.getCameraX()+4);
        player.setWorldX(player.getWorldX()+4);
//        player.setX(player.getX()+4);
//        returnResponse("RIGHT");
        // todo : handle it in logic




    }
    public void LeftRequest(){}
    public void DownRequest(){}
    public void SwardRequest(){}
    public void BulletRequest(){}
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