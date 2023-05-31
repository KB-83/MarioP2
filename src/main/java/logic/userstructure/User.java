package logic.userstructure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import logic.LogicManager;
import logic.gamestrucure.Game;
import logic.modelstructure.entity.player.Player;

public class User {
    @JsonIgnore
    private LogicManager logicManager;
    private String username;
    private String password;
    private Game[] games;
    private Player[] players;
    private int coins;
    private int highScore;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Game[] getGames() {
        return games;
    }

    public void setGames(Game[] games) {
        this.games = games;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public LogicManager getLogicManager() {
        return logicManager;
    }

    public void setLogicManager(LogicManager logicManager) {
        this.logicManager = logicManager;
    }
}
