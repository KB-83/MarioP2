package graphic.guibackgroundobject.guiblock;

import graphic.GuiModel;
import graphic.GuiPart;

public abstract class GuiBlock extends GuiModel {
    private int worldX,worldY;

    public GuiBlock() {
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

}
