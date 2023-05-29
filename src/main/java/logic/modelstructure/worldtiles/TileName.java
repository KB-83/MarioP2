package logic.modelstructure.worldtiles;

public enum TileName {
    Sky(1),
    Tile1(0),
    Tile2(2),
    Tile3(3),
    Tile4(4),
    NightSky(5);
    int index;
    TileName(int index) {
        this.index = index;
    }
}
