package logic.requsethandler;

import graphic.guigamestructure.Camera;
import logic.modelcontroller.PlayerController;
import logic.modelstructure.entity.player.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PlayerRequestHandler extends Request{
    private PlayerController playerController = new PlayerController();
    private Player player;
    public void JumpRequest(){
        int time;
        int xV;
        int yV;
        int g;
        int m;
        returnResponse("jump");
        System.out.println("jump request");
    }
    public void RightRequest(){
//        player.setX(player.getX()+4);
//        returnResponse("JUMP");
//        Camera.getCamera().getGameState().getPlayer().setCameraX(Camera.getCamera().getGameState().getPlayer().getCameraX()+4);
//        Camera.getCamera().getGameState().getPlayer().setWorldX(Camera.getCamera().getGameState().getPlayer().getWorldX()+14);
        Camera.getCamera().updateCameraLocation();
        Camera.getCamera().getGamePanel().repaint();



    }
    public void LeftRequest(){}
    public void DownRequest(){}
    public void SwardRequest(){}
    public void BulletRequest(){}
    public void PauseRequest(){}



    @Override
    public Response returnResponse(String s){
        Class c = playerController.getClass();
        try {
            Method m = c.getMethod(s);
            m.invoke(c.newInstance());
        } catch (NoSuchMethodException | InvocationTargetException
                 | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}