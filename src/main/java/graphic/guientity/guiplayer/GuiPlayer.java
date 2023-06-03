package graphic.guientity.guiplayer;


import graphic.GraphicManager;
import graphic.guientity.GuiEntity;

import java.awt.*;
import java.util.HashMap;

public abstract class GuiPlayer extends GuiEntity {

//            GuiGameState guiGameState;

    public GuiPlayer() {
        super();
    }

    //    GuiPlayer(GuiGameState guiGameState) {
//
//        this.guiGameState = guiGameState;
//    }
    public abstract void setImage(String imageAddress);

//    @Override
//    public void draw(Graphics2D g2) {
//    }

}