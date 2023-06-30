package graphic.guientity;


import javax.imageio.ImageIO;
import java.awt.*;
import java.util.HashMap;

public class GuiSward extends GuiEntity {
    private boolean isLock;
    public GuiSward() {
        super();
        loadImages();
        setCurrentImage(getImageByItsAddress("Right"));
    }

    @Override
    public void loadImages() {
        HashMap<String, Image> imageHashMap = new HashMap<>();
        Image image;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/image/item/swardright.png"));
            imageHashMap.put("Right",image);

            image = ImageIO.read(getClass().getResourceAsStream("/image/item/swardleft.png"));
            imageHashMap.put("Left",image);
        }catch (Exception e){
            e.printStackTrace();
        }
        setImages(imageHashMap);
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }
}
