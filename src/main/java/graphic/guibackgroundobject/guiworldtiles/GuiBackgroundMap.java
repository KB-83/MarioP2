package graphic.guibackgroundobject.guiworldtiles;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GuiBackgroundMap {
    private static Image[] images ;
    private GuiBackgroundTile[][] guiBackGroundTiles;
    private static void setImages() {
        images = new Image[4];
        for (int i = 0; i < images.length;i++) {
            try {
                images[i] = ImageIO.read(GuiBackgroundMap.class.getResourceAsStream("/image/backgroundtiles/Tile"+i+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Image[] getImages() {
        if(images == null) {
            setImages();
        }
        return images;
    }

    public void setGuiBackGroundTiles(GuiBackgroundTile[][] guiBackGroundTiles) {
        this.guiBackGroundTiles = guiBackGroundTiles;
    }

    public GuiBackgroundTile[][] getGuiBackGroundTiles() {
        return guiBackGroundTiles;
    }
}
