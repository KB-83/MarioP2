package logic.gamestrucure.gameworldoption.collision;
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
    private Rect blockRect = new Rect(0,48, 0,48);
    private Rect playerRect = new Rect(0,48, 0,48);
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
        playerRect.updatePosition(player.getWorldX(),player.getWorldY());
//        System.out.println(playerRect.getTopY()+"----"+playerRect.getLeftX());
//        System.out.println(player.getWorldY()+"---"+player.getWorldX());
        for (Block block : blocks) {
            blockRect.updatePosition(block.getCol()*48,block.getRow()*48);
            if(didCollide(playerRect,blockRect)) {
                System.out.println("34 player collision checker colision happend ...");
                if (player.getVX() > 0 && block.getCol()*Constant.BACKGROUND_TILE_SIZE < player.getWorldX()+Constant.BACKGROUND_TILE_SIZE
                        && (block.getCol()+1) * Constant.BACKGROUND_TILE_SIZE  > player.getWorldX()+Constant.BACKGROUND_TILE_SIZE) {
                    player.setVX(0);
                }
                if (player.getVX() < 0 && block.getCol()*Constant.BACKGROUND_TILE_SIZE < player.getWorldX()
                        && (block.getCol()+1) * Constant.BACKGROUND_TILE_SIZE  > player.getWorldX()) {
                    player.setVX(0);
                }
                if (player.getVY() > 0 && (block.getRow()+1)*Constant.BACKGROUND_TILE_SIZE > player.getWorldY() &&
                        block.getRow()*Constant.BACKGROUND_TILE_SIZE < player.getWorldY()) {
                    player.setVY(-player.getVY());
                    if (player.isDuringJump()){
                        player.setDuringJump(false);
                    }
                }
                System.out.println(player.getVY()+"-----");
//                System.out.println(block.getY()*Constant.BACKGROUND_TILE_SIZE+"---");
//                System.out.println(player.getWorldY()+Constant.BACKGROUND_TILE_SIZE);
//                System.out.println((block.getY()+1)*Constant.BACKGROUND_TILE_SIZE);
//                System.out.println(player.getWorldY()+Constant.BACKGROUND_TILE_SIZE);
                if (player.getVY() < 0 && block.getRow()*Constant.BACKGROUND_TILE_SIZE < player.getWorldY()+Constant.BACKGROUND_TILE_SIZE &&
                        (block.getRow()+1)*Constant.BACKGROUND_TILE_SIZE > player.getWorldY()+Constant.BACKGROUND_TILE_SIZE) {
                    System.out.println("line 54 trying to seat on block");
                    player.setVY(0);
                    player.setWorldY((block.getRow()-1)*Constant.BACKGROUND_TILE_SIZE);
                    player.setCameraY((block.getRow()-1)*Constant.BACKGROUND_TILE_SIZE);
                    if (player.isDuringJump()){
                        player.setDuringJump(false);
                    }
                }
            }
        }
    }
    @Override
    public boolean didCollide(Rect rect1, Rect rect2) {
        // todo <= or <
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
