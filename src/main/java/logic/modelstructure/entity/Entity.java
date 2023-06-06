package logic.modelstructure.entity;

public abstract class Entity {
    private String imageAddress;
    private double vX;
    private double vY;

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

    public void setVX(double vX) {
        this.vX = vX;
    }

    public double getVY() {
        return vY;
    }

    public void setVY(double vY) {
        this.vY = vY;
    }
}
