package graphic.guigamestructure;


import graphic.guientity.guiplayer.GuiPlayer;
import graphic.guilevelstructure.GuiLevel;
import graphic.guilevelstructure.GuiSection;

public class GuiGameState{
    private GuiLevel currentGuiLevel;
    private GuiSection currentGuiSection;
    private GuiPlayer guiplayer;
    private int levelNumber;
    private int sectionNumber;
    private int coins;
    private int score;
    private int remainingHeart;
    private int remainingTime;
    private boolean isPaused;

    public GuiLevel getCurrentGuiLevel() {
        return currentGuiLevel;
    }

    public void setCurrentGuiLevel(GuiLevel currentGuiLevel) {
        this.currentGuiLevel = currentGuiLevel;
    }

    public GuiSection getCurrentGuiSection() {
        return currentGuiSection;
    }

    public void setCurrentGuiSection(GuiSection currentGuiSection) {
        this.currentGuiSection = currentGuiSection;
    }

    public GuiPlayer getGuiplayer() {
        return guiplayer;
    }

    public void setGuiplayer(GuiPlayer guiplayer) {
        this.guiplayer = guiplayer;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRemainingHeart() {
        return remainingHeart;
    }

    public void setRemainingHeart(int remainingHeart) {
        this.remainingHeart = remainingHeart;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }
}
