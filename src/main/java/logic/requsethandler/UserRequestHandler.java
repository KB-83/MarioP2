package logic.requsethandler;

import logic.LogicManager;
import logic.datahandler.Loader;
import logic.datahandler.Saver;
import logic.userstructure.User;


public class UserRequestHandler {
    private LogicManager logicManager;
    public boolean loginRequest(String username, String password){
        User user = Loader.getLoader().loadUser(username);
        if (user != null){
            if (user.getPassword().equals(password)) {
                //todo : initialize game user
                return true;
            }
            System.out.println("password is incorrect.");
        }
        return false;
    }
    public boolean signInRequest(String username, String password){
        User user = new User(username,password);
        boolean b = Saver.getSaver().saveUser(user);
        if (b){
//             todo: do the things
              }
        return b;
    }
}
