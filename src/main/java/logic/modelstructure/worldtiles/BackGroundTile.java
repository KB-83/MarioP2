package logic.modelstructure.worldtiles;

import java.util.HashMap;
import java.util.List;

public class BackGroundTile {
    private int col,row;
    private TileName name;
    private boolean isCollisionOn;
    public BackGroundTile(){
    }

    public BackGroundTile(int col, int row, TileName name) {
        this.col = col;
        this.row = row;
        this.name = name;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public TileName getName() {
        return name;
    }

    public void setName(TileName name) {
        this.name = name;
    }
}
