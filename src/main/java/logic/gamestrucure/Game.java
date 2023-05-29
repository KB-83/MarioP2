package logic.gamestrucure;

import logic.levelstructure.Level;
import logic.modelstructure.entity.player.Player;

public class Game {
    private Player player;
    private Level[] levels;
    private int hearts;
    private int marioState;

    public Game() {
    }

    public Level[] getLevels() {
        return levels;
    }

    public void setLevels(Level[] levels) {
        this.levels = levels;
    }

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public int getMarioState() {
        return marioState;
    }

    public void setMarioState(int marioState) {
        this.marioState = marioState;
    }
}
