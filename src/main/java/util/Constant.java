package util;


public class Constant {
    public static final int BACKGROUND_TILE_SIZE = Config.getConfig("GamePanel").getPropertyAsInt("TileSize");
    public static final int PANEL_WIDTH = Config.getConfig("PanelsManagerCard").getPropertyAsInt("Width");
    public static final int PANEL_HEIGHT= Config.getConfig("PanelsManagerCard").getPropertyAsInt("Height");
    public static final int GAME_ROWS = 20;
    public static final int GROUND_BLOCKS= 3;
    public static final int PANEL_ROWS = 15;
    public static final int FPS = 60;
    private Constant(){}

}
