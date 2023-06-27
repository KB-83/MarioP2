package logic.gamelogic.backgroundmaplogic;

import logic.levelstructure.Section;
import logic.modelstructure.worldtiles.BackGroundTile;
import logic.modelstructure.worldtiles.BackgroundMap;
import logic.modelstructure.worldtiles.TileNum;

public class BackGroundMapGenerator {
    private BackGroundMapGenerator() {
    }

    public static BackgroundMap retrunBackgroundMap(int cols, int rows){
        // my gameRows
        rows = 15;
        BackgroundMap backgroundMap = new BackgroundMap();
        BackGroundTile[][] backGroundTiles = new BackGroundTile[rows][cols];
        int col = 0;
        int row = 0;

        while (col < cols && row < rows){

            if (row < rows - 3 || (col <= 26 && col>22)) {
                BackGroundTile backGroundTile = new BackGroundTile(col,row,TileNum.Sky,false);
                backGroundTiles[row][col] = backGroundTile;
            }
            else  {
                BackGroundTile backGroundTile = new BackGroundTile(col,row,TileNum.Tile1,true);
                backGroundTiles[row][col] = backGroundTile;
            }
            col++;
            if(col >= cols) {
                col = 0;
                row++;

            }

        }
        backgroundMap.setBackGroundTiles(backGroundTiles);
        return backgroundMap;
    }
}
