package graphic.guientity;

import graphic.GuiPart;

import java.awt.*;
import java.util.HashMap;

public abstract class GuiEntity implements GuiPart {
    private HashMap<String,Image> images;
    private Image currentImage;
    public GuiEntity(){}
    public abstract void loadImages();

    public HashMap<String, Image> getImages() {
        return images;
    }

    public void setImages(HashMap<String , Image> images) {
        this.images = images;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }
}
