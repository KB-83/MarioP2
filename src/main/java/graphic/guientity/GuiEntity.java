package graphic.guientity;

import graphic.GuiPart;

import java.awt.*;

public abstract class GuiEntity implements GuiPart {
    Image[] images;
    public GuiEntity(){}
    public abstract void loadImages();

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }
}
