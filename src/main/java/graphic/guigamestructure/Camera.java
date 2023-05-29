package graphic.guigamestructure;

import graphic.guilevelstructure.GuiSection;
import graphic.panel.GamePanel;
import logic.gamestrucure.GameState;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.worldtiles.BackgroundMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Camera {
    // world button column which it have to start painting from
    private GuiGameState guiGameState;
    private int startPaintingX ,endPaintingX;
    private static Camera camera;
    private int minasXLength;
    GamePanel gamePanel;

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    private Camera() {
        startPaintingX = 0;
        // need to be change
        endPaintingX = 900;
        minasXLength = 0;
    }
    public void paintCamera(Graphics2D g2) {
        System.out.println("line 34,Camera");
        updateCameraLocation();
        //paint Background
        for (int i = startPaintingX/48;i< endPaintingX/48;i++){
            for (int j = 0; j< guiGameState.getCurrentGuiSection().getBackgroundMap().getBackGroundTiles()[i].length;j++){
                Image image;
                try {
                    image = ImageIO.read(getClass().getResourceAsStream("/image/backgroundtiles/Tile"+
                            guiGameState.getCurrentGuiSection().getBackgroundMap().getBackGroundTiles()[i][j]+".png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
//                System.out.println("camera line 38");
                System.out.println(minasXLength);
                g2.drawImage(image,(i*48)-minasXLength,j * 48,48,48,null);
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
    }
    private boolean checkBound (int x , int y) {
        if(x < endPaintingX && x > startPaintingX) {
            return true;
        }
        return false;
    }
    public static Camera getCamera() {
        if (camera == null){
            camera = new Camera();
        }
        return camera;
    }
    public void updateCameraLocation(){
        if (guiGameState != null) {
//            startPaintingX = guiGameState.getGuiplayer().getWorldX();//- game panel size;
            // todo: player camera x doesnt need to be initialize in logic player im goinig to creat it in graphic

            endPaintingX = startPaintingX + 1600;//+ 2 gamePanel Size
//            minasXLength = gameState.getPlayer().getWorldX() - gameState.getPlayer().getCameraX();
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