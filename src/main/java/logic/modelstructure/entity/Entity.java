package logic.modelstructure.entity;

public abstract class Entity {
    private String imageAddress;
    private int worldX,worldY;
    private double vX;
    private double vY;
    private int width,height;
    private Boolean isOnTopOfBlock;

    public Entity() {
    }

    public Entity(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public double getVX() {
        return vX;
    }

    public synchronized void setVX(double vX) {
        this.vX = vX;
    }

    public double getVY() {
        return vY;
    }

    public synchronized void setVY(double vY) {
        this.vY = vY;
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

    public Boolean getOnTopOfBlock() {
        return isOnTopOfBlock;
    }

    public void setOnTopOfBlock(Boolean onTopOfBlock) {
        isOnTopOfBlock = onTopOfBlock;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
