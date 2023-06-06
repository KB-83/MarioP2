package logic.gamestrucure.gameworldoption.collision;
import logic.gamestrucure.GameState;
import logic.levelstructure.Section;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.entity.player.Player;
import logic.modelstructure.worldtiles.BackgroundMap;
import util.Constant;

public class PlayerCollisionChecker implements CollisionChecker {
    //todo : improve this
    BackgroundMap backgroundMap;
    private Player player;
    private Enemy[] enemies;
    private Pipe[] pipes;
    private Block[] blocks;
    private Rect blockRect = new Rect(0,0, 0,0,Constant.BACKGROUND_TILE_SIZE);
    private Rect playerRect = new Rect(0,0, 0,0,Constant.BACKGROUND_TILE_SIZE);
    public PlayerCollisionChecker(Section section,Player player) {
        enemies = section.getEnemies();
        pipes = section.getPipes();
        blocks = section.getBlocks();
        this.player = player;
    }
    public void updateSection(Section section) {
        enemies = section.getEnemies();
        pipes = section.getPipes();
        blocks = section.getBlocks();
    }
    public void applyCollisionEffects(){
        System.out.println("32 playercollision checker");
        playerRect.updatePosition(player.getWorldX(),player.getWorldY());
        for (Block block : blocks) {
            blockRect.updatePosition(block.getX()*Constant.BACKGROUND_TILE_SIZE,block.getY()*Constant.BACKGROUND_TILE_SIZE);
            if(didCollide(playerRect,blockRect)) {
                player.setVX(0);
                player.setVY(0);
                if (player.isDuringJump()){
                    player.setDuringJump(false);
                    player.getPlayerRequestHandler().getJumpTimer().stop();
                }
            }
        }
    }
    @Override
    public boolean didCollide(Rect rect1, Rect rect2) {
        System.out.println(rect1.getLeftX()+"----"+rect1.getRightX());
        System.out.println(rect1.getTopY()+"----"+rect1.getBottomY());
        if(rect1.getLeftX() < rect2.getLeftX() && rect1.getRightX() > rect2.getLeftX()
        && rect1.getTopY() < rect2.getTopY() && rect1.getBottomY() > rect2.getTopY()){
            return true;
        }
        if(rect1.getLeftX() < rect2.getLeftX() && rect1.getRightX() > rect2.getLeftX()
                && rect1.getTopY() < rect2.getBottomY() && rect1.getBottomY() > rect2.getBottomY()){
            return true;
        }
        if(rect1.getLeftX() < rect2.getRightX() && rect1.getRightX() > rect2.getRightX()
                && rect1.getTopY() < rect2.getTopY() && rect1.getBottomY() > rect2.getTopY()){
            return true;
        }
        if(rect1.getLeftX() < rect2.getRightX() && rect1.getRightX() > rect2.getRightX()
                && rect1.getTopY() < rect2.getBottomY() && rect1.getBottomY() > rect2.getBottomY()){
            return true;
        }
        return false;
    }

}
