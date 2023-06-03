package graphic.guibackgroundobject.guipipe;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.HashMap;

public class GuiTelePlantPipe extends GuiPipe{
    public GuiTelePlantPipe() {
        loadImages();
    }

    @Override
    public void loadImages() {
        HashMap<String, Image> imageHashMap = new HashMap<>();
        Image image;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/image/pipe/PipeB.png"));
            imageHashMap.put("PipeB",image);
        }catch (Exception e){
            e.printStackTrace();
        }
        setImages(imageHashMap);
    }
}
