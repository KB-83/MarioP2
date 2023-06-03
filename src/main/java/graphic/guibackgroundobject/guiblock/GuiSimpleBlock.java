package graphic.guibackgroundobject.guiblock;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.HashMap;

public class GuiSimpleBlock extends GuiBlock{
    public GuiSimpleBlock() {
        loadImages();
    }

    @Override
    public void loadImages() {
        HashMap<String, Image> imageHashMap = new HashMap<>();
        Image image;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/image/block/SimpleBlock.png"));
            imageHashMap.put("Block",image);
        }catch (Exception e){
            e.printStackTrace();
        }
        setImages(imageHashMap);
    }
}