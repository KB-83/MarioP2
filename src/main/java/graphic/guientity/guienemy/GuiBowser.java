package graphic.guientity.guienemy;

import logic.modelstructure.entity.enemy.Bowser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.HashMap;

public class GuiBowser extends GuiEnemy{
//    @Override
//    public void draw(Graphics2D g2) {
//
//    }


    public GuiBowser() {
        loadImages();
    }

    @Override
    public void loadImages() {
        HashMap<String,Image> imageHashMap = new HashMap<>();
        Image image;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/image/enemy/broth.png"));
            imageHashMap.put("Right",image);
        }catch (Exception e){
            e.printStackTrace();
        }
        setImages(imageHashMap);
    }
}
