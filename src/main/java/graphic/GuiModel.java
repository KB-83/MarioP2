package graphic;

import java.awt.*;
import java.util.HashMap;

public abstract class GuiModel {
    private HashMap<String, Image> images;
    private Image currentImage;
    private int worldX,worldY;
    private int cameraX,cameraY;
    private int Width,Height;
    public Image getImageByItsAddress(String imageAddress) {
        return images.get(imageAddress);
    }
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
    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public int getCameraX() {
        return cameraX;
    }

    public void setCameraX(int cameraX) {
        this.cameraX = cameraX;
    }

    public int getCameraY() {
        return cameraY;
    }

    public void setCameraY(int cameraY) {
        this.cameraY = cameraY;
    }
    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }
}
