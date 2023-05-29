package logic.modelstructure.entity.player;
public class Mario extends Player {
    public Mario(){}
    public Mario(int x, int y) {
        setWorldX(x);
        setWorldY(y);
        setCameraX(0);
        setCameraY(0);
    }
}
