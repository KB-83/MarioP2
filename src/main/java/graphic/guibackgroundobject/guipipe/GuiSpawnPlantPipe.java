package graphic.guibackgroundobject.guipipe;

import graphic.guientity.guienemy.GuiPlant;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.entity.enemy.Plant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.HashMap;

public class GuiSpawnPlantPipe extends GuiPipe {
    private GuiPlant guiPlant;
    public GuiSpawnPlantPipe() {
        loadImages();
    }

    @Override
    public void loadImages() {
        HashMap<String, Image> imageHashMap = new HashMap<>();
        Image image;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/image/pipe/PipeB.png"));
            imageHashMap.put("PipeB",image);
        }catch (Exception e){
            e.printStackTrace();
        }
        setImages(imageHashMap);
    }
    public GuiPlant getGuiPlant() {
        return guiPlant;
    }

    public void setGuiPlant(GuiPlant guiPlant) {
        this.guiPlant = guiPlant;
    }

}
