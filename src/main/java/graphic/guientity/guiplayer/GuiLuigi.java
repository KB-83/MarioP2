package graphic.guientity.guiplayer;

import java.awt.*;

//import Graphic.GraphicManager;
//import Graphic.Models.GuiGameState;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.io.IOException;
//
public class GuiLuigi extends GuiPlayer{
//    public GuiLuigi(){
//        super();
//    }
//    public GuiLuigi(GraphicManager gM, GuiGameState guiGameState) {
//        super(gM,guiGameState);
//        images = new Image[10];
//        loadImages();
//        image = images[0];
//    }
//
//    @Override
//    public void setImage(int imageNum) {
//
//        this.image = images[imageNum];
//    }
//
//
//    void loadImages() {
//        try{
//
//            images[0] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/LuigiRight1.png"));
//            images[1] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/LuigiRight2.png"));
//            images[2] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/LuigiLeft1.png"));
//            images[3] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/LuigiLeft2.png"));
//            images[4] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/LuigiJumpRight.png"));
//            images[5] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/LuigiJumpLeft.png"));
//            images[6] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/LuigiLose.png"));
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }

    @Override
    public void setImage(int imageNum) {

    }

    @Override
    public void draw(Graphics2D g2) {
//        g2.drawImage(image, gM.lM.userManager.logicGameState.currentPlayer.screenX , gM.lM.userManager.logicGameState.currentPlayer.screenY,
//                playerSize, playerSize, null);
    }

    @Override
    public void loadImages() {

    }
}
