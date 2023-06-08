package logic.modelstructure.entity.player;

import logic.modelcontroller.PlayerController;
import logic.requsethandler.PlayerRequestHandler;

public class Mario extends Player {
    public Mario(){}
    public Mario(int x, int y) {
        setWorldX(x);
        setWorldY(y);
        setCameraX(0);
        setCameraY(0);
    }
}
