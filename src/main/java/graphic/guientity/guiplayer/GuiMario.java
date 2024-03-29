package graphic.guientity.guiplayer;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class GuiMario extends GuiPlayer{
    public GuiMario(){
        super();
        loadImages();
    }
//    public GuiMario(GraphicManager gM, GuiGameState guiGameState) {
//        super(gM,guiGameState);
//        images = new Image[10];
//        loadImages();
//        image = images[0];
//    }

    @Override
    public void setImage(String imageAddress) {
        setCurrentImage(getImages().get(imageAddress));
//        this.image = images[imageNum];
    }


    public void loadImages() {
        HashMap<String,Image> imageHashMap = new HashMap<>();
        Image image;
        try{
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioRight1.png"));
        imageHashMap.put("Right1",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioRight2.png"));
        imageHashMap.put("Right2",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioLeft1.png"));
        imageHashMap.put("Left1",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioLeft2.png"));
        imageHashMap.put("Left2",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioJumpRight.png"));
        imageHashMap.put("JumpRight",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioJumpLeft.png"));
        imageHashMap.put("JumpLeft",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioLose.png"));
        imageHashMap.put("Lose",image);
        }catch (Exception e){
        e.printStackTrace();
        }
        setImages(imageHashMap);
    }
    public Image getImageByItsAddress(String imageAddress) {
        return getImages().get(imageAddress);
    }

}
