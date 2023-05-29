package logic.datahandler.load;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import logic.gamestrucure.Game;
import logic.levelstructure.Level;

import java.io.File;
import java.io.IOException;

public class Load {
    Level level;
    public ObjectMapper objectMapper = new ObjectMapper();
    public Load(){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("config-ap.json");
        try {
            level = objectMapper.readValue(file, Level.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(level.getHearts());
    }
}
