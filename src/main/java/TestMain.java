import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphic.GraphicManager;
import graphic.guientity.guiplayer.GuiMario;
import graphic.guigamestructure.Camera;
import graphic.guigamestructure.GuiGameCreator;
import graphic.panel.Frame;
import graphic.requestlistener.PlayerListener;
import logic.LogicManager;
import logic.datahandler.Loader;
import logic.gamestrucure.Game;
import logic.gamestrucure.GameState;
import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.modelstructure.entity.player.Mario;
import logic.modelstructure.worldtiles.BackgroundMap;
import logic.requsethandler.PlayerRequestHandler;
import logic.requsethandler.UserRequestHandler;
import logic.userstructure.User;

import java.io.DataOutput;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class TestMain {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("config-ap.json");
        Level level;
        try {
            level = objectMapper.readValue(file, Level.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(level.getSections()[0].getEnemies()[1].getClass());
        File file1 = new File("test.json");
        try {
            FileWriter fileWriter = new FileWriter(file1);
            objectMapper.writeValue(fileWriter,level);
//            objectMapper.writeValue((DataOutput) level,Level.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
