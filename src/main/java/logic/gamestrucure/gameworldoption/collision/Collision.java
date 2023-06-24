package logic.gamestrucure.gameworldoption.collision;

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