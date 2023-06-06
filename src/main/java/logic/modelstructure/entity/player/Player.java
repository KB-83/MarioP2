package logic.modelstructure.entity.player;

import logic.modelstructure.entity.Entity;

public abstract class Player extends Entity {
    private int worldX,worldY;
    private int cameraX,cameraY;
    private String imageAddress;
    // todo : test if you load a game which player is during jump what happens
    private boolean isDuringJump;

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

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public boolean isDuringJump() {
        return isDuringJump;
    }

    public void setDuringJump(boolean duringJump) {
        isDuringJump = duringJump;
    }
}
