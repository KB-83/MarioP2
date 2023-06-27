package logic.modelstructure.entity.player;

import logic.modelstructure.entity.Entity;
import logic.requsethandler.PlayerRequestHandler;
import util.Constant;

public abstract class Player extends Entity {
    private int cameraX, cameraY;
    private int Width, Height;
    private String imageAddress;
    // todo : test if you load a game which player is during jump what happens
    private boolean isDuringJump;
    private boolean isFire, isMega;
    //todo: is it nessesart?
    private PlayerRequestHandler playerRequestHandler;

    public Player() {
        setOnTopOfBlock(true);
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

    public PlayerRequestHandler getPlayerRequestHandler() {
        return playerRequestHandler;
    }

    public void setPlayerRequestHandler(PlayerRequestHandler playerRequestHandler) {
        this.playerRequestHandler = playerRequestHandler;
    }

    public boolean isFire() {
        return isFire;
    }

    public void setFire(boolean fire) {
        isFire = fire;
        if (fire){
            setHeight(Constant.BACKGROUND_TILE_SIZE*2);
        }
    }

    public boolean isMega() {
        return isMega;
    }

    public void setMega(boolean mega) {
        isMega = mega;
        if (mega){
            setHeight(Constant.BACKGROUND_TILE_SIZE*2);
        }
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
