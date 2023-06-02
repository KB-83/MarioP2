package logic.datahandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import logic.gamestrucure.Game;
import logic.levelstructure.Level;
import logic.userstructure.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Loader {
    private static Loader loader;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Loader(){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public static Loader getLoader() {
        if (loader == null) {
            loader = new Loader();
        }return loader;
    }
    public User loadUser(String userName) {
        File file = new File("src/main/resources/database/user/"+userName+".json");
        User user = null;
        if (!file.exists()) {
            System.out.println("user dos not exist.");
            return null;
        }
        try {
                user = objectMapper.readValue(file, User.class);
            } catch (IOException e) {
            System.out.println("json mapping for this user is not right.\nsource: Loader class loadUser method.");
            e.printStackTrace();
        }
        return user;
    }
    public Game LoadGame() {
        return null;
    }
}
