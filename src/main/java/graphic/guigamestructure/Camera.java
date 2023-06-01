package graphic.guigamestructure;

import graphic.guibackgroundobject.guiworldtiles.GuiBackgroundMap;
import graphic.panel.GamePanel;
import util.Constant;

import java.awt.*;

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
        for (int i = startPaintingX/Constant.BACKGROUND_TILE_SIZE;i< endPaintingX/Constant.BACKGROUND_TILE_SIZE;i++){
            for (int j = 0; j< guiGameState.getCurrentGuiSection().getGuibackgroundMap().getBackGroundTiles()[i].length;j++){
                g2.drawImage(GuiBackgroundMap.getImages()[guiGameState.getCurrentGuiSection().getGuibackgroundMap().
                        getBackGroundTiles()[i][j]], (i* Constant.BACKGROUND_TILE_SIZE)-minasXLength,
                        j * Constant.BACKGROUND_TILE_SIZE,Constant.BACKGROUND_TILE_SIZE,
                        Constant.BACKGROUND_TILE_SIZE,null);
            }
        }
//        drawing enemies
//        for (Enemy enemy : gameState.getCurrentSection().getEnemies()){
//            if(checkBound(enemy.getX(), enemy.getY())){
//                Image image;
//                //draw enemy
//                try {
//                    image = ImageIO.read(getClass().getResourceAsStream(enemy.getImageAddress()));
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                g2.drawImage(image,50,50,50,50,null);
//                g2.drawString("test from camera",100,200);
//            }
//        }
//        //paintBackgroundObjects
//        //todo: add all of this things to an array of background objects then you can add flag and bla bla ...
//        for (Block block : gameState.getCurrentSection().getBlocks()) {
//            if(checkBound(block.getX(), block.getY())) {
//                // draw blocks
//            }
//        }
////         drawing pipes
//        for (Pipe pipe: gameState.getCurrentSection().getPipes()) {
//            if(checkBound(pipe.getX(), pipe.getY())) {
//                // draw pipes
//            }
//        }
        //todo : drying player
        System.out.println(guiGameState.getGuiPlayer());
        g2.drawImage(guiGameState.getGuiPlayer().getCurrentImage(),getGuiGameState().getGuiPlayer().getCameraX()
                ,getGuiGameState().getGuiPlayer().getCameraY()
                ,Constant.BACKGROUND_TILE_SIZE,Constant.BACKGROUND_TILE_SIZE,null );
    }
    private boolean checkBound (int x , int y) {
        if(x < endPaintingX && x > startPaintingX) {
            return true;
        }
        return false;
    }
    public void updateCameraLocation(){
        if (guiGameState != null) {
            startPaintingX = guiGameState.getGuiPlayer().getWorldX();//- game panel size;
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