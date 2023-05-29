package logic.modelstructure.worldtiles;

import java.util.HashMap;
import java.util.List;

public class BackGroundTile {
    private int x,y;
    private TileName name;
    public BackGroundTile(){
    }

    public BackGroundTile(int x, int y, TileName name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TileName getName() {
        return name;
    }

    public void setName(TileName name) {
        this.name = name;
    }
}
