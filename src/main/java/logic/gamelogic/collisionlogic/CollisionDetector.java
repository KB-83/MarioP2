package logic.gamelogic.collisionlogic;


import logic.gamestrucure.gameworldoption.collision.CollisionChecker;
import logic.gamestrucure.gameworldoption.collision.Rect;
import logic.modelstructure.entity.Entity;
import logic.modelstructure.entity.player.Player;
import util.Constant;

public class CollisionDetector implements CollisionChecker {
    private Entity entity;

    public CollisionDetector(Entity entity) {
        this.entity = entity;
    }

    @Override
        public boolean didCollide(Rect entityRect, Rect biggerRect) {
            // todo <= or <
            if (entityRect.getTopY()/ Constant.BACKGROUND_TILE_SIZE == (biggerRect.getTopY()/Constant.BACKGROUND_TILE_SIZE) - (entityRect.getHeight()/Constant.BACKGROUND_TILE_SIZE)
            && biggerRect.getLeftX() - entityRect.getWidth() <= entityRect.getLeftX() && biggerRect.getRightX() + entityRect.getWidth() >= entityRect.getRightX()){
                entity.setOnTopOfBlock(true);
                // todo: improve it too
                entity.setWorldY(biggerRect.getTopY()-entityRect.getHeight());
                if (entity.getVY() < 0) {
                    entity.setVY(0);
                }

                if(entity.getClass().getSuperclass().getSimpleName().equals("Player")){
                    ((Player) entity).setCameraY(biggerRect.getTopY()-entityRect.getHeight());
                    if (entity.getVY() < 0) {
                        ((Player) entity).setDuringJump(false);
                    }

                }
            }

            if(entityRect.getLeftX() < biggerRect.getLeftX() && entityRect.getRightX() > biggerRect.getLeftX()
                    && entityRect.getTopY() < biggerRect.getTopY() && entityRect.getBottomY() > biggerRect.getTopY()){
                return true;
            }
            if(entityRect.getLeftX() < biggerRect.getLeftX() && entityRect.getRightX() > biggerRect.getLeftX()
                    && entityRect.getTopY() < biggerRect.getBottomY() && entityRect.getBottomY() > biggerRect.getBottomY()){
                return true;
            }
            if(entityRect.getLeftX() < biggerRect.getRightX() && entityRect.getRightX() > biggerRect.getRightX()
                    && entityRect.getTopY() < biggerRect.getTopY() && entityRect.getBottomY() > biggerRect.getTopY()){
                return true;
            }
            if(entityRect.getLeftX() < biggerRect.getRightX() && entityRect.getRightX() > biggerRect.getRightX()
                    && entityRect.getTopY() < biggerRect.getBottomY() && entityRect.getBottomY() > biggerRect.getBottomY()){
                return true;
            }
            if(biggerRect.getLeftX() < entityRect.getLeftX() && biggerRect.getRightX() > entityRect.getLeftX()
                && biggerRect.getTopY() < entityRect.getTopY() && biggerRect.getBottomY() > entityRect.getTopY()){
            return true;
            }
            if(biggerRect.getLeftX() < entityRect.getLeftX() && biggerRect.getRightX() > entityRect.getLeftX()
                    && biggerRect.getTopY() < entityRect.getBottomY() && biggerRect.getBottomY() > entityRect.getBottomY()){
                return true;
            }
            if(biggerRect.getLeftX() < entityRect.getRightX() && biggerRect.getRightX() > entityRect.getRightX()
                    && biggerRect.getTopY() < entityRect.getTopY() && biggerRect.getBottomY() > entityRect.getTopY()){
                return true;
            }
            if(biggerRect.getLeftX() < entityRect.getRightX() && biggerRect.getRightX() > entityRect.getRightX()
                    && biggerRect.getTopY() < entityRect.getBottomY() && biggerRect.getBottomY() > entityRect.getBottomY()){
                return true;
            }
                return false;
            }
}
