package logic.userstructure;

import logic.gamestrucure.Game;
import logic.modelstructure.entity.player.Player;

public class User {
    private String username;
    private String password;
    private Game[] games;
    private Player[] players;
    private int coins;
    private int highScore;
}
