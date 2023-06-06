package logic.gamestrucure.gameworldoption.collision;

import javafx.scene.shape.Polygon;

public class Collision {
    private CollisionChecker collisionChecker;
    public Collision () {
        collisionChecker = new CollisionChecker() {
            @Override
            public boolean didCollide(Rect rect1, Rect rect2) {
                return false;
            }
        };
    }

}