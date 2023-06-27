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
        imageHashMap.put("0Right1",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioRight2.png"));
        imageHashMap.put("0Right2",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioLeft1.png"));
        imageHashMap.put("0Left1",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioLeft2.png"));
        imageHashMap.put("0Left2",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioJumpRight.png"));
        imageHashMap.put("0JumpRight",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioJumpLeft.png"));
        imageHashMap.put("0JumpLeft",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MarioLose.png"));
        imageHashMap.put("0Lose",image);

        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MegaMarioRight1.png"));
        imageHashMap.put("1Right1",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MegaMarioRight2.png"));
        imageHashMap.put("1Right2",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MegaMarioLeft1.png"));
        imageHashMap.put("1Left1",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MegaMarioLeft2.png"));
        imageHashMap.put("1Left2",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MegaMarioJumpRight.png"));
        imageHashMap.put("1JumpRight",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/MegaMarioRight1.png"));
        imageHashMap.put("1JumpLeft",image);

        image = ImageIO.read(getClass().getResourceAsStream("/image/player/FireMarioRight1.png"));
        imageHashMap.put("2Right1",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/FireMarioRight2.png"));
        imageHashMap.put("2Right2",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/FireMarioLeft1.png"));
        imageHashMap.put("2Left1",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/FireMarioLeft2.png"));
        imageHashMap.put("2Left2",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/FireMarioJumpRight.png"));
        imageHashMap.put("2JumpRight",image);
        image = ImageIO.read(getClass().getResourceAsStream("/image/player/FireMarioRight1.png"));
        imageHashMap.put("2JumpLeft",image);

        }
        catch (Exception e){
        e.printStackTrace();
        }
        setImages(imageHashMap);
    }

}
