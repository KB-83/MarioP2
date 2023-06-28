package graphic.guibackgroundobject;

import graphic.GuiModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.HashMap;

public class GuiCheckPoint extends GuiModel {
    public GuiCheckPoint() {
        loadImages();
    }

    @Override
    public void loadImages() {
        HashMap<String, Image> imageHashMap = new HashMap<>();
        Image image;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/image/item/checkpoint.png"));
            imageHashMap.put("checkPoint",image);
        }catch (Exception e){
            e.printStackTrace();
        }
        setImages(imageHashMap);
    }
}
