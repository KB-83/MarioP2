package graphic.guientity;


import javax.imageio.ImageIO;
import java.awt.*;
import java.util.HashMap;

public class GuiBullet extends GuiEntity {
    private boolean isLock;
    public GuiBullet() {
        super();
        loadImages();
        setCurrentImage(getImageByItsAddress("1"));
    }

    @Override
    public void loadImages() {
        HashMap<String, Image> imageHashMap = new HashMap<>();
        Image image;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/image/item/bullet.png"));
            imageHashMap.put("1",image);
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
