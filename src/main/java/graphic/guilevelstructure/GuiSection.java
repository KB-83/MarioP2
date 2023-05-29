package graphic.guilevelstructure;


import graphic.guibackgroundobject.guiblock.GuiBlock;
import graphic.guibackgroundobject.guipipe.GuiPipe;
import graphic.guientity.guienemy.GuiEnemy;
import logic.modelstructure.worldtiles.BackgroundMap;

public class GuiSection {
    private int length;
    private int time;
    private BackgroundMap backgroundMap;
    private GuiBlock[] guiBlocks;
    private GuiEnemy[] guiEnemies;
    private GuiPipe[] guiPipes;

    public GuiSection() {
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public BackgroundMap getBackgroundMap() {
        return backgroundMap;
    }

    public void setBackgroundMap(BackgroundMap backgroundMap) {
        this.backgroundMap = backgroundMap;
    }

    public GuiBlock[] getGuiBlocks() {
        return guiBlocks;
    }

    public void setGuiBlocks(GuiBlock[] guiBlocks) {
        this.guiBlocks = guiBlocks;
    }

    public GuiEnemy[] getGuiEnemies() {
        return guiEnemies;
    }

    public void setGuiEnemies(GuiEnemy[] guiEnemies) {
        this.guiEnemies = guiEnemies;
    }

    public GuiPipe[] getGuiPipes() {
        return guiPipes;
    }

    public void setGuiPipes(GuiPipe[] guiPipes) {
        this.guiPipes = guiPipes;
    }
}
