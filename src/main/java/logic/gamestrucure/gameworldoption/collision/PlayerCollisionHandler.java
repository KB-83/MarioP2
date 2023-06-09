package logic.gamestrucure.gameworldoption.collision;
import logic.levelstructure.Section;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.entity.player.Player;
import logic.modelstructure.worldtiles.BackGroundTile;
import util.Constant;

public class PlayerCollisionHandler {
    //todo : improve this
    private CollisionChecker collisionChecker;
    private Player player;
    private Enemy[] enemies;
    private Pipe[] pipes;
    private Block[] blocks;
    private BackGroundTile[][] backGroundTiles;
    private Rect blockRect = new Rect(0,48, 0,48);
    private Rect playerRect = new Rect(0,48, 0,48);
    private Rect pipeRect = new Rect(0,96,0,48*3);
    private Rect enemyRect = new Rect(0,48,0,48);
    private Rect backgrounTileRect = new Rect(0,48,0,48);
    public PlayerCollisionHandler(Section section, Player player) {
        collisionChecker = new CollisionDetector(player);
        enemies = section.getEnemies();
        pipes = section.getPipes();
        blocks = section.getBlocks();
        backGroundTiles = section.getBackgroundMap().getBackGroundTiles();
        this.player = player;
    }
    public void updateSection(Section section) {
        enemies = section.getEnemies();
        pipes = section.getPipes();
        blocks = section.getBlocks();
    }
    public void applyCollisionEffects(){
        // blocks effects
        //todo : improve it
        player.setOnTopOfBlock(false);
        if (blocks != null) {
            playerRect.updatePosition(player.getWorldX(), player.getWorldY());
            for (Block block : blocks) {
                blockRect.updatePosition(block.getCol() * 48, block.getRow() * 48);
                if (collisionChecker.didCollide(playerRect, blockRect)) {
                    handelCollision(block.getCol() * Constant.BACKGROUND_TILE_SIZE, block.getRow() *
                            Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE);
                }
            }
        }
        //pipes
        playerRect.updatePosition(player.getWorldX(),player.getWorldY());
        if (pipes != null) {
            for (Pipe pipe : pipes) {
                pipeRect.updatePosition(pipe.getCol() * 48, pipe.getRow() * 48);
                //todo give thebiigger rect first
                if (collisionChecker.didCollide(playerRect, pipeRect)) {
                    handelCollision(pipe.getCol() * Constant.BACKGROUND_TILE_SIZE, pipe.getRow() *
                            Constant.BACKGROUND_TILE_SIZE, 2 * Constant.BACKGROUND_TILE_SIZE, 3 * Constant.BACKGROUND_TILE_SIZE);
                }
            }
        }
//        enemies
        if (enemies != null) {
            playerRect.updatePosition(player.getWorldX(), player.getWorldY());
            for (Enemy enemy : enemies) {
                enemyRect.updatePosition(enemy.getWorldX(), enemy.getWorldY());
                if (collisionChecker.didCollide(playerRect, enemyRect)) {
                    handelCollision(enemy.getWorldX(), enemy.getWorldY(), Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE);
                    return;
                }
            }
        }
        //background tiles todo: give a bound to background tiles
        playerRect.updatePosition(player.getWorldX(),player.getWorldY());
        for (int i = 0; i < backGroundTiles.length; i++){
            for (int j = 0;j < backGroundTiles[i].length;j++) {
                if (backGroundTiles[i][j].isSolid()){
                    backgrounTileRect.updatePosition(j*48,i*48);
                    if(collisionChecker.didCollide(playerRect,backgrounTileRect)){
                        handelCollision(j*48,i*48,48,48);
                    }
                }
            }
        }
    }
    public void handelCollision(int itemLeftWorldX, int itemTopWorldY,int itemWidth,int itemHeight) {
        if (player.getVX() > 0 && itemLeftWorldX < player.getWorldX()+Constant.BACKGROUND_TILE_SIZE
                && itemLeftWorldX+itemWidth  > player.getWorldX()+Constant.BACKGROUND_TILE_SIZE) {
            player.setVX(0);
        }
        if (player.getVX() < 0 && itemLeftWorldX < player.getWorldX()
                && (itemLeftWorldX+itemWidth > player.getWorldX())) {
            player.setVX(0);
        }
        if (player.getVY() > 0 && itemTopWorldY+itemHeight > player.getWorldY() &&
                itemTopWorldY < player.getWorldY()) {
            player.setVY(-player.getVY());
            if (player.isDuringJump()){
                player.setDuringJump(false);
            }
        }
        if (player.getVY() < 0 && itemTopWorldY < player.getWorldY()+Constant.BACKGROUND_TILE_SIZE &&
                itemTopWorldY+itemHeight > player.getWorldY()+Constant.BACKGROUND_TILE_SIZE) {
            player.setVY(0);
            player.setWorldY(itemTopWorldY - Constant.BACKGROUND_TILE_SIZE);
            player.setCameraY(itemTopWorldY-Constant.BACKGROUND_TILE_SIZE);
            if (player.isDuringJump()){
                player.setDuringJump(false);
            }
        }
    }

}
