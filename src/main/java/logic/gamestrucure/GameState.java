package logic.gamestrucure;

import logic.gamelogic.collisionlogic.PlayerCollisionHandler;
import logic.gamelogic.playerlogic.PlayerItemEater;
import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.gamelogic.GameStateController;
import logic.modelstructure.backgroundobject.CheckPoint;
import logic.modelstructure.entity.player.Player;
import logic.sound.Sound;
import logic.userstructure.User;
import util.Loop;

public class GameState {
    private GameStateController gameStateController;
    private User currentUser;
    private Level currentLevel;
    private Section currentSection;
    private Player player;
    // 0 : mini //  1 : mega // 2 : fire
    private int marioState;
    private Loop gameloop;
    private PlayerCollisionHandler playerCollisionHandler;
    private PlayerItemEater playerItemEater;
    private Sound sound;
    private int levelNumber;
    private int sectionNumber;
    private int coins;
    private int score;
    private int remainingHeart;
    private int remainingTime;
    private boolean isPaused;
    private CheckPoint waitingCheckpoint;
    // todo : test

//    public GameState() {
//    }
    public GameState(GameStateController gameStateController) {
        this.gameStateController = gameStateController;
        playerItemEater = new PlayerItemEater(this);
    }
    public GameState(User user , Game game , Player player) {
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
        playerItemEater = new PlayerItemEater(this);
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

    public Loop getGameloop() {
        return gameloop;
    }

    public void setGameLoop(Loop gameloop) {
        this.gameloop = gameloop;
    }

    public GameStateController getGameStateController() {
        return gameStateController;
    }

    public void setGameStateController(GameStateController gameStateController) {
        this.gameStateController = gameStateController;
    }

    public PlayerCollisionHandler getPlayerCollisionHandler() {
        return playerCollisionHandler;
    }

    public void setPlayerCollisionHandler(PlayerCollisionHandler playerCollisionHandler) {
        this.playerCollisionHandler = playerCollisionHandler;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public int getMarioState() {
        return marioState;
    }

    public void setMarioState(int marioState) {
        this.marioState = marioState;
    }

    public PlayerItemEater getPlayerItemEater() {
        return playerItemEater;
    }

    public void setPlayerItemEater(PlayerItemEater playerItemEater) {
        this.playerItemEater = playerItemEater;
    }

    public CheckPoint getWaitingCheckpoint() {
        return waitingCheckpoint;
    }

    public void setWaitingCheckpoint(CheckPoint waitingCheckpoint) {
        this.waitingCheckpoint = waitingCheckpoint;
    }
}
