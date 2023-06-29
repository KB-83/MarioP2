package graphic.guientity.guiplayer;


import graphic.GraphicManager;
import graphic.guientity.GuiEntity;
import graphic.guientity.guiitem.GuiBullet;

import java.awt.*;
import java.util.HashMap;

public abstract class GuiPlayer extends GuiEntity {

//            GuiGameState guiGameState;
    private GuiBullet guiBullet;
    public GuiPlayer() {
        super();
        guiBullet = new GuiBullet();
    }

    //    GuiPlayer(GuiGameState guiGameState) {
//
//        this.guiGameState = guiGameState;
//    }
    public abstract void setImage(String imageAddress);

//    @Override
//    public void draw(Graphics2D g2) {
//    }


    public GuiBullet getGuiBullet() {
        return guiBullet;
    }

    public void setGuiBullet(GuiBullet guiBullet) {
        this.guiBullet = guiBullet;
    }
}