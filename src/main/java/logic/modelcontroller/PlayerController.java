package logic.modelcontroller;

import graphic.guigamestructure.Camera;

public class PlayerController {
    public void jump(){
        System.out.println("jump method called from player controller");
    }
    public void right(){
        Camera.getCamera().getGuiGameState().getGuiPlayer().setCameraX(Camera.getCamera().getGuiGameState().getGuiPlayer().getCameraX()+4);
        Camera.getCamera().getGuiGameState().getGuiPlayer().setWorldX(Camera.getCamera().getGuiGameState().getGuiPlayer().getWorldX()+14);
        Camera.getCamera().updateCameraLocation();
        Camera.getCamera().getGamePanel().repaint();
    }
}
