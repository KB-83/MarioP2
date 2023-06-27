package graphic.guigamestructure;

import graphic.guibackgroundobject.guiblock.GuiBlock;
import graphic.guibackgroundobject.guipipe.GuiPipe;
import graphic.guibackgroundobject.guipipe.GuiSimplePlantPipe;
import graphic.guibackgroundobject.guipipe.GuiTelePlantPipe;
import graphic.guibackgroundobject.guiworldtiles.GuiBackgroundMap;
import graphic.guibackgroundobject.guiworldtiles.GuiBackgroundTile;
import graphic.guientity.guienemy.GuiEnemy;
import graphic.guientity.guiitem.GuiItem;
import graphic.panel.GamePanel;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.worldtiles.BackGroundTile;
import util.Constant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Camera {
    // world button column which it have to start painting from
    private GuiGameState guiGameState;
    private int startPaintingX ,endPaintingX;
    private int minasXLength;

    public Camera() {
        startPaintingX = 0;
        // need to be change
        endPaintingX = Constant.PANEL_WIDTH;
        minasXLength = 0;
    }
    public void paintCamera(Graphics2D g2) {
        updateCameraLocation();
        //paint Background
        //todo : make it behine
            for (int i = 0; i< guiGameState.getCurrentGuiSection().getGuibackgroundMap().getGuiBackGroundTiles().length;i++){
                for (int j = startPaintingX/Constant.BACKGROUND_TILE_SIZE;j< endPaintingX/Constant.BACKGROUND_TILE_SIZE;j++){
                g2.drawImage(GuiBackgroundMap.getImages()[guiGameState.getCurrentGuiSection().getGuibackgroundMap().
                        getGuiBackGroundTiles()[i][j].getNum().getIndex()], (j* Constant.BACKGROUND_TILE_SIZE)-minasXLength,
                        i * Constant.BACKGROUND_TILE_SIZE,Constant.BACKGROUND_TILE_SIZE,
                        Constant.BACKGROUND_TILE_SIZE,null);
            }
        }
//        for (GuiBackgroundTile guiBackGroundTile: guiGameState.getCurrentGuiSection().getGuibackgroundMap().getGuiBackGroundTiles()) {
//            g2.drawImage(GuiBackgroundMap.getImages()[guiBackGroundTile.getNum().getIndex()], (guiBackGroundTile.getCol() * Constant.BACKGROUND_TILE_SIZE)-minasXLength,
//                        guiBackGroundTile.getRow() * Constant.BACKGROUND_TILE_SIZE,Constant.BACKGROUND_TILE_SIZE,
//                        Constant.BACKGROUND_TILE_SIZE,null);
//        }
//        drawing enemies
        for (GuiEnemy guiEnemy : guiGameState.getCurrentGuiSection().getGuiEnemies()){
//            if(checkBound(enemy.getX(), enemy.getY())){
                //draw enemy
                g2.drawImage(guiEnemy.getCurrentImage(),guiEnemy.getWorldX()-minasXLength,guiEnemy.getWorldY(),Constant.BACKGROUND_TILE_SIZE,Constant.BACKGROUND_TILE_SIZE,null);
            }
//        }
//        //paint blocks
//        //todo: add all of this things to an array of background objects then you can add flag and bla bla ...
        for (GuiBlock guiBlock : guiGameState.getCurrentGuiSection().getGuiBlocks()) {
//            if(checkBound(block.getX(), block.getY())) {
//                // draw blocks
//            }
            g2.drawImage(guiBlock.getCurrentImage(),(guiBlock.getWorldX()*Constant.BACKGROUND_TILE_SIZE )- minasXLength,
                    guiBlock.getWorldY()*Constant.BACKGROUND_TILE_SIZE,
                    Constant.BACKGROUND_TILE_SIZE,Constant.BACKGROUND_TILE_SIZE,null);
        }
////         drawing pipes
//        todo check i something is null
//        todo : clean camera class and functionize it
        if(guiGameState.getCurrentGuiSection().getGuiPipes() != null) {
            for (GuiPipe guiPipe : guiGameState.getCurrentGuiSection().getGuiPipes()) {
//            if(checkBound(pipe.getX(), pipe.getY())) {
//                // draw pipes
//            }
                g2.drawImage(guiPipe.getCurrentImage(), (guiPipe.getWorldX() * Constant.BACKGROUND_TILE_SIZE) - minasXLength,
                        guiPipe.getWorldY() * Constant.BACKGROUND_TILE_SIZE,
                        Constant.BACKGROUND_TILE_SIZE * 2, Constant.BACKGROUND_TILE_SIZE * 3, null);
            }
        }
        //item
        if (guiGameState.getCurrentGuiSection().getGuiItems() != null) {
            for (GuiItem guiItem : guiGameState.getCurrentGuiSection().getGuiItems()) {
                g2.drawImage(guiItem.getCurrentImage(),guiItem.getWorldX() - minasXLength ,guiItem.getWorldY(),
                        Constant.BACKGROUND_TILE_SIZE,Constant.BACKGROUND_TILE_SIZE,null);
            }
        }

        // drying player
        g2.drawImage(guiGameState.getGuiPlayer().getCurrentImage(),getGuiGameState().getGuiPlayer().getCameraX(),
                getGuiGameState().getGuiPlayer().getCameraY()
                ,getGuiGameState().getGuiPlayer().getWidth(), getGuiGameState().getGuiPlayer().getHeight(),
                null );
    }
    private boolean checkBound (int x , int y) {
        if(x < endPaintingX && x > startPaintingX) {
            return true;
        }
        return false;
    }
    public void updateCameraLocation(){
        if (guiGameState != null) {
            startPaintingX = guiGameState.getGuiPlayer().getWorldX() - Constant.PANEL_WIDTH;
            if (startPaintingX < 0 ) {
                startPaintingX = 0;
            }//- game panel size;
            // todo: player camera x doesnt need to be initialize in logic player im goinig to creat it in graphic
            endPaintingX = startPaintingX + 2 * Constant.PANEL_WIDTH;//+ 2 gamePanel Size
            minasXLength = guiGameState.getGuiPlayer().getWorldX() - guiGameState.getGuiPlayer().getCameraX();
        }
    }

    public GuiGameState getGuiGameState() {
        return guiGameState;
    }

    public void setGuiGameState(GuiGameState guiGameState) {
        this.guiGameState = guiGameState;
    }

    public int getStartPaintingX() {
        return startPaintingX;
    }

    public void setStartPaintingX(int startPaintingX) {
        this.startPaintingX = startPaintingX;
    }

    public int getEndPaintingX() {
        return endPaintingX;
    }

    public void setEndPaintingX(int endPaintingX) {
        this.endPaintingX = endPaintingX;
    }
    // world button row which it have to start painting from

//    private int endY;
}