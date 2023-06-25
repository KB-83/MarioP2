package graphic.guientity.guiitem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.HashMap;

public class GuiCoin extends GuiItem{
    public GuiCoin() {
        super();
        loadImages();
    }

    @Override
    public void loadImages() {
        HashMap<String, Image> imageHashMap = new HashMap<>();
        Image image;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/image/item/coin.png"));
            imageHashMap.put("1",image);
        }catch (Exception e){
            e.printStackTrace();
        }
        setImages(imageHashMap);
    }
}
