package graphic.guientity.guiplayer;


import graphic.guientity.GuiEntity;
import graphic.guientity.GuiBullet;
import graphic.guientity.GuiSward;

public abstract class GuiPlayer extends GuiEntity {

//            GuiGameState guiGameState;
    private GuiBullet guiBullet;
    private GuiSward guiSward;
    public GuiPlayer() {
        super();
        guiBullet = new GuiBullet();
        guiSward  = new GuiSward();
    }

    //    GuiPlayer(GuiGameState guiGameState) {
//
//        this.guiGameState = guiGameState;
//    }
    public abstract void setImage(String imageAddress);

//    @Override
//    public void draw(Graphics2D g2) {
//    }


    public GuiBullet getGuiBullet() {
        return guiBullet;
    }

    public void setGuiBullet(GuiBullet guiBullet) {
        this.guiBullet = guiBullet;
    }

    public GuiSward getGuiSward() {
        return guiSward;
    }

    public void setGuiSward(GuiSward guiSward) {
        this.guiSward = guiSward;
    }
}
