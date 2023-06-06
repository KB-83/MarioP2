package logic.gamestrucure.gameworldoption.collision;

import javafx.scene.shape.Polygon;

public interface CollisionChecker {
    public boolean didCollide(Rect rect1, Rect rect2);
}
