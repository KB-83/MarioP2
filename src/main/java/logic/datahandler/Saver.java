package logic.datahandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import logic.userstructure.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Saver {
    private static Saver saver;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Saver(){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public static Saver getSaver() {
        if (saver == null) {
            saver = new Saver();
        }return saver;
    }
    public boolean saveUser(User user,boolean isSignInRequest) {
        File file = new File("src/main/resources/database/user/"+user.getUsername()+".json");
        if (file.exists() && isSignInRequest) {
            System.out.println("user already exist.");
            return false;
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            objectMapper.writeValue(fileWriter,user);
        } catch (IOException e) {
            System.out.println("json mapping for this user is not right.\nsource: Saver class saveUser method.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
