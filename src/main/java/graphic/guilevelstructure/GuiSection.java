package graphic.guilevelstructure;


import graphic.guibackgroundobject.guiblock.GuiBlock;
import graphic.guibackgroundobject.guipipe.GuiPipe;
import graphic.guibackgroundobject.guiworldtiles.GuiBackgroundMap;
import graphic.guientity.guienemy.GuiEnemy;
import graphic.guientity.guiitem.GuiItem;

public class GuiSection {
    private int length;
    private int time;
    private GuiBackgroundMap guibackgroundMap;
    private GuiBlock[] guiBlocks;
    private GuiEnemy[] guiEnemies;
    private GuiPipe[] guiPipes;
    private GuiItem[] guiItems;

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

    public GuiBackgroundMap getGuibackgroundMap() {
        return guibackgroundMap;
    }

    public void setGuiBackgroundMap(GuiBackgroundMap guibackgroundMap) {
        this.guibackgroundMap = guibackgroundMap;
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

    public GuiItem[] getGuiItems() {
        return guiItems;
    }

    public void setGuiItems(GuiItem[] guiItems) {
        this.guiItems = guiItems;
    }
}
