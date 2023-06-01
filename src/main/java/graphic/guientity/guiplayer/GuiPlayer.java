package graphic.guientity.guiplayer;


import graphic.GraphicManager;
import graphic.guientity.GuiEntity;

import java.awt.*;
import java.util.HashMap;

public abstract class GuiPlayer extends GuiEntity {

//            GuiGameState guiGameState;
    private int worldX,worldY;
    private int cameraX,cameraY;

    public GuiPlayer(){
        super();
    }
//    GuiPlayer(GuiGameState guiGameState) {
//
//        this.guiGameState = guiGameState;
//    }
    public abstract void setImage(String imageAddress);

    @Override
    public void draw(Graphics2D g2) {
    }

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public int getCameraX() {
        return cameraX;
    }

    public void setCameraX(int cameraX) {
        this.cameraX = cameraX;
    }

    public int getCameraY() {
        return cameraY;
    }

    public void setCameraY(int cameraY) {
        this.cameraY = cameraY;
    }
}
