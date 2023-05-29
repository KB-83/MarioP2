package logic.modelstructure.entity;

public abstract class Entity {
    private String imageAddress;

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
}
