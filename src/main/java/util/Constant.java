package util;


public class Constant {
    public static final int BACKGROUND_TILE_SIZE = Config.getConfig("GamePanel").getPropertyAsInt("TileSize");
    public static final int PANEL_WIDTH = Config.getConfig("PanelsManagerCard").getPropertyAsInt("Width");
    public static final int PANEL_HEIGHT= Config.getConfig("PanelsManagerCard").getPropertyAsInt("Height");
    private Constant(){}

}
