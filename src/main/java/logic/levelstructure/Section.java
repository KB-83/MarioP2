package logic.levelstructure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import logic.gamelogic.backgroundmaplogic.BackGroundMapGenerator;
import logic.modelstructure.backgroundobject.CheckPoint;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.entity.item.Item;
import logic.modelstructure.worldtiles.BackgroundMap;

public class Section {
    private int length;
    private int time;
    private Block[] blocks;
    private Enemy[] enemies;
    private Pipe[] pipes;
    private Pipe spawnPipe;
    @JsonIgnore
    private BackgroundMap backgroundMap;
    private CheckPoint checkPoint;
    private Item[] items;
    public Section(){
//        backgroundMap = new BackgroundMap();
//        backgroundMap.loadMap(1,1,26*4, 15);
//        backgroundMap = BackGroundMapGenerator.retrunBackgroundMap(26 * 4,15);
    }

    public Section(int levelNum,int sectionNum) {
        // todo: this is just a test
//        backgroundMap = new BackgroundMap();
//        backgroundMap.loadMap(1,1,26*4, 15);
//        backgroundMap = BackGroundMapGenerator.retrunBackgroundMap(26 * 4,15);
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

    public Pipe getSpawnPipe() {
        return spawnPipe;
    }

    public void setSpawnPipe(Pipe spawnPipe) {
        this.spawnPipe = spawnPipe;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public CheckPoint getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(CheckPoint checkPoint) {
        this.checkPoint = checkPoint;
    }
}
