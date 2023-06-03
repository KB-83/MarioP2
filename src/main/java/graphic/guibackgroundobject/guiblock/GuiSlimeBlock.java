package graphic.guibackgroundobject.guiblock;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.HashMap;

public class GuiSlimeBlock extends GuiBlock{
    @Override
    public void loadImages() {
        HashMap<String, Image> imageHashMap = new HashMap<>();
        Image image;
        try{
//            image = ImageIO.read(getClass().getResourceAsStream("/image/enemy/SpinyR.png"));
//            imageHashMap.put("Right",image);
        }catch (Exception e){
            e.printStackTrace();
        }
        setImages(imageHashMap);
    }
}
