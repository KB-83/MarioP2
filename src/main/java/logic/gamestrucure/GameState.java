package logic.gamestrucure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import logic.gamelogic.collisionlogic.PlayerCollisionHandler;
import logic.gamelogic.playerlogic.PlayerItemEater;
import logic.gamelogic.playerlogic.PlayerLifeChecker;
import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.gamelogic.GameStateController;
import logic.modelstructure.backgroundobject.CheckPoint;
import logic.modelstructure.entity.player.Mario;
import logic.modelstructure.entity.player.Player;
import logic.sound.Sound;
import logic.userstructure.User;
import util.Loop;

public class GameState {
    @JsonIgnore
    private String name;
    @JsonIgnore
    private GameStateController gameStateController;
    @JsonIgnore
    private User currentUser;
    private Level[] levels;
    @JsonIgnore
    private Level currentLevel;
    @JsonIgnore
    private Section currentSection;
    private Mario mario;
    // 0 : mini //  1 : mega // 2 : fire
    private int marioState;
    @JsonIgnore
    private Loop gameloop;
    @JsonIgnore
    private PlayerCollisionHandler playerCollisionHandler;
    @JsonIgnore
    private PlayerLifeChecker playerLifeChecker;
    @JsonIgnore
    private PlayerItemEater playerItemEater;
    @JsonIgnore
    private Sound sound;
    private int levelNumber;
    private int sectionNumber;
    private int coins;
    private int score;
    private int remainingHeart;
    private int remainingTime;
    @JsonIgnore
    private boolean isPaused;
    @JsonIgnore
    private CheckPoint waitingCheckpoint;
    // todo : test

    public GameState() {
    }
    public GameState(GameStateController gameStateController) {
        this.gameStateController = gameStateController;
        playerItemEater = new PlayerItemEater(this);
        playerLifeChecker = new PlayerLifeChecker(this);
        sound = new Sound("MAIN");
    }
    public void setDefaultDependencies(){
        playerItemEater = new PlayerItemEater(this);
        playerLifeChecker = new PlayerLifeChecker(this);
        sound = new Sound("MAIN");
    }
//    public GameState(User user , Game game , Player player,GameStateController gameStateController) {
//        currentUser = user;
//        currentLevel = game.getLevels()[0];
//        currentSection = currentLevel.getSections()[0];
//        levels = game.getLevels();
//        this.player = player;
//        levelNumber = 1;
//        sectionNumber = 1;
//        coins = 0;
//        score = 0;
//        remainingHeart = game.getHearts();
//        remainingTime = currentSection.getTime();
//        isPaused = false;
//        playerItemEater = new PlayerItemEater(this);
//    }

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

    public Level[] getLevels() {
        return levels;
    }

    public void setLevels(Level[] levels) {
        this.levels = levels;
    }

    public Mario getMario() {
        return mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    public PlayerLifeChecker getPlayerLifeChecker() {
        return playerLifeChecker;
    }

    public void setPlayerLifeChecker(PlayerLifeChecker playerLifeChecker) {
        this.playerLifeChecker = playerLifeChecker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
