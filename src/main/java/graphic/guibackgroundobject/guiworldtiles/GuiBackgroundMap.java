package graphic.guibackgroundobject.guiworldtiles;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GuiBackgroundMap {
    private static Image[] images ;
    private int[][] backGroundTiles;
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

    public int[][] getBackGroundTiles() {
        return backGroundTiles;
    }

    public void setBackGroundTiles(int[][] backGroundTiles) {
        this.backGroundTiles = backGroundTiles;
    }
}
