package graphic.guientity.guiitem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.HashMap;

public class GuiFlower extends GuiItem{
    public GuiFlower() {
        super();
        loadImages();
    }

    @Override
    public void loadImages() {
        HashMap<String, Image> imageHashMap = new HashMap<>();
        Image image;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/image/item/flower.png"));
            imageHashMap.put("1",image);
        }catch (Exception e){
            e.printStackTrace();
        }
        setImages(imageHashMap);
    }
}
