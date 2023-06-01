package logic.levelstructure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.worldtiles.BackgroundMap;
import util.Constant;
import util.Loop;

public class Section {
    private int length;
    private int time;
    private Block[] blocks;
    private Enemy[] enemies;
    private Pipe[] pipes;
    @JsonIgnore
    //todo : test if it is nessesary
    private BackgroundMap backgroundMap;
    public Section(){
        backgroundMap = new BackgroundMap(1,1,26*4, 15);    }

    public Section(int levelNum) {
        // todo: this is just a test
        backgroundMap = new BackgroundMap(levelNum,1,26*4, 15);
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

    public Block[] getBlocks() {
        return blocks;
    }

    public void setBlocks(Block[] blocks) {
        this.blocks = blocks;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemy[] enemies) {
        this.enemies = enemies;
    }

    public Pipe[] getPipes() {
        return pipes;
    }

    public void setPipes(Pipe[] pipes) {
        this.pipes = pipes;
    }

    public BackgroundMap getBackgroundMap() {
        return backgroundMap;
    }

    public void setBackgroundMap(BackgroundMap backgroundMap) {
        this.backgroundMap = backgroundMap;
    }
}
