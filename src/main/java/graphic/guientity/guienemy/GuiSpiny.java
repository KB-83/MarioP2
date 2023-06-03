package graphic.guientity.guienemy;

import graphic.guientity.GuiEntity;
import logic.modelstructure.entity.enemy.Spiny;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.HashMap;

public class GuiSpiny extends GuiEnemy {
    public GuiSpiny() {
        loadImages();
    }

//    @Override
//    public void draw(Graphics2D g2) {
//
//    }

    @Override
    public void loadImages() {

        HashMap<String,Image> imageHashMap = new HashMap<>();
        Image image;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/image/enemy/SpinyR.png"));
            imageHashMap.put("Right",image);
            image = ImageIO.read(getClass().getResourceAsStream("/image/enemy/SpinyL.png"));
            imageHashMap.put("Left",image);
        }catch (Exception e){
            e.printStackTrace();
        }
        setImages(imageHashMap);
    }
}
