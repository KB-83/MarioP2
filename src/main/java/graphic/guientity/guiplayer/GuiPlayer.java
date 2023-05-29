package graphic.guientity.guiplayer;


import graphic.GraphicManager;
import graphic.guientity.GuiEntity;

import java.awt.*;

public abstract class GuiPlayer extends GuiEntity {

//            GuiGameState guiGameState;
            Image image;

    public GuiPlayer(){}
//    GuiPlayer(GuiGameState guiGameState) {
//
//        this.guiGameState = guiGameState;
//    }
    public abstract void setImage(int imageNum);

    @Override
    public void draw(Graphics2D g2) {
    }


}
