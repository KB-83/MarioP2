package graphic.guibackgroundobject.guiworldtiles;

import logic.modelstructure.worldtiles.TileNum;

public class GuiBackgroundTile {
    private int col,row;
    private TileNum num;

    public GuiBackgroundTile(int col, int row, TileNum num) {
        this.col = col;
        this.row = row;
        this.num = num;
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

    public TileNum getNum() {
        return num;
    }

    public void setNum(TileNum num) {
        this.num = num;
    }
}
