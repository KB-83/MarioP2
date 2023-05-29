package logic.gamestrucure.gameworldoption;

import javafx.scene.shape.Polygon;

public interface CollisionChecker {
    public boolean didCollide(Polygon polygon1 , Polygon polygon2);
}
