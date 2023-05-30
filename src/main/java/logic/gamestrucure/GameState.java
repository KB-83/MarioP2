package logic.gamestrucure;

import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.modelstructure.entity.player.Player;
import logic.userstructure.User;

public class GameState {
    private User currentUser;
    private Level currentLevel;
    private Section currentSection;
    private Player player;
    private int levelNumber;
    private int sectionNumber;
    private int coins;
    private int score;
    private int remainingHeart;
    private int remainingTime;
    private boolean isPaused;
    // todo : test
    private static GameState gameState;

    private GameState() {
    }
    private GameState(User user , Game game , Player player) {
        currentUser = user;
        currentLevel = game.getLevels()[0];
        currentSection = currentLevel.getSections()[0];
        this.player = player;
        levelNumber = 1;
        sectionNumber = 1;
        coins = 0;
        score = 0;
        remainingHeart = game.getHearts();
        remainingTime = currentSection.getTime();
        isPaused = false;
    }
    public static GameState getGameState(){
        if (gameState == null) {
            gameState = new GameState();

        }
        return gameState;
    }
    public static GameState getGameState(User user , Game game , Player player){
        if (gameState == null) {
            gameState = new GameState(user ,game ,player);
        }
        return gameState;
    }
    public void removeLastGameState() {
        gameState = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Section getCurrentSection() {
        return currentSection;
    }

    public void setCurrentSection(Section currentSection) {
        this.currentSection = currentSection;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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
