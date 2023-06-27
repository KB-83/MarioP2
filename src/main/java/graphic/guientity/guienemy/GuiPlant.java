package graphic.guientity.guienemy;

import graphic.guientity.GuiEntity;
import logic.modelstructure.entity.enemy.Plant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.HashMap;


public class GuiPlant extends GuiEnemy {

    public GuiPlant() {
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
            image = ImageIO.read(getClass().getResourceAsStream("/image/enemy/Plant.png"));
            //name because of gui game creator create enemies function
            // you can change it then
            imageHashMap.put("Right",image);
        }catch (Exception e){
            e.printStackTrace();
        }
        setImages(imageHashMap);
    }
}
