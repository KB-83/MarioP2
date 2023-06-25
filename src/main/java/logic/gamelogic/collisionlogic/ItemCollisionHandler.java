package logic.gamelogic.collisionlogic;

import logic.gamelogic.itemlogic.ItemUnlocker;
import logic.gamestrucure.gameworldoption.collision.CollisionChecker;
import logic.gamestrucure.gameworldoption.collision.Rect;
import logic.levelstructure.Section;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.entity.item.Item;
import logic.modelstructure.entity.player.Player;
import logic.modelstructure.worldtiles.BackGroundTile;
import util.Constant;

public class ItemCollisionHandler implements CollisionHandler{
    private CollisionChecker collisionChecker;
    private Item item;
    private Enemy[] enemies;
    private Pipe[] pipes;
    private Block[] blocks;
    private BackGroundTile[][] backGroundTiles;
    private Rect blockRect = new Rect(0,48, 0,48);
    private Rect itemRect = new Rect(0,48, 0,48);
    private Rect pipeRect = new Rect(0,96,0,48*3);
    private Rect enemyRect = new Rect(0,48,0,48);
    private Rect backgrounTileRect = new Rect(0,48,0,48);
    public ItemCollisionHandler(Section section, Item item) {
        collisionChecker = new CollisionDetector(item);
        enemies = section.getEnemies();
        pipes = section.getPipes();
        blocks = section.getBlocks();
        backGroundTiles = section.getBackgroundMap().getBackGroundTiles();
        this.item = item;
    }
    public void applyCollisionEffects(){
        //todo : improve it
        item.setOnTopOfBlock(false);
        //
        // blocks effects
        checkBlocksCollision();

        //pipes
        checkPipesCollision();

//        enemies
        checkEnemiesCollision();

        //background tiles todo: give a bound to background tiles
        checkBackgroundTilesCollision();

    }
    @Override
    public void checkBlocksCollision() {
        itemRect.updatePosition(item.getWorldX(), item.getWorldY());
        for (int i = 0; i < blocks.length ; i++) {
            Block block = blocks[i];
            blockRect.updatePosition(block.getCol() * 48, block.getRow() * 48);
            if (collisionChecker.didCollide(itemRect, blockRect)) {
                handelCollision(block.getCol() * Constant.BACKGROUND_TILE_SIZE, block.getRow() *
                        Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE);
            }
        }
    }

    @Override
    public void checkPipesCollision() {
        itemRect.updatePosition(item.getWorldX(),item.getWorldY());
        if (pipes != null) {
            for (Pipe pipe : pipes) {
                pipeRect.updatePosition(pipe.getCol() * 48, pipe.getRow() * 48);
                //todo give thebiigger rect first
                if (collisionChecker.didCollide(itemRect, pipeRect)) {
                    handelCollision(pipe.getCol() * Constant.BACKGROUND_TILE_SIZE, pipe.getRow() *
                            Constant.BACKGROUND_TILE_SIZE, 2 * Constant.BACKGROUND_TILE_SIZE, 3 * Constant.BACKGROUND_TILE_SIZE);
                }
            }
        }
    }

    @Override
    public void checkEnemiesCollision() {
        if (enemies != null) {
            itemRect.updatePosition(item.getWorldX(), item.getWorldY());
            for (Enemy enemy : enemies) {
                enemyRect.updatePosition(enemy.getWorldX(), enemy.getWorldY());
                if (collisionChecker.didCollide(itemRect, enemyRect)) {
                    handelCollision(enemy.getWorldX(), enemy.getWorldY(), Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE);
                    return;
                }
            }
        }

    }

    @Override
    public void checkBackgroundTilesCollision() {
        itemRect.updatePosition(item.getWorldX(),item.getWorldY());
        for (int i = 0; i < backGroundTiles.length; i++){
            for (int j = 0;j < backGroundTiles[i].length;j++) {
                if (backGroundTiles[i][j].isSolid()){
                    backgrounTileRect.updatePosition(j*48,i*48);
                    if(collisionChecker.didCollide(itemRect,backgrounTileRect)){
                        handelCollision(j*48,i*48,48,48);
                    }
                }
            }
        }
    }

    @Override
    public void checkPlayerCollision() {

    }
    public void handelCollision(int itemLeftWorldX, int itemTopWorldY,int itemWidth,int itemHeight) {
        if (item.getVX() > 0 && itemLeftWorldX < item.getWorldX()+ Constant.BACKGROUND_TILE_SIZE
                && itemLeftWorldX+itemWidth  > item.getWorldX()+Constant.BACKGROUND_TILE_SIZE) {
            item.setVX(0);
        }
        if (item.getVX() < 0 && itemLeftWorldX < item.getWorldX()
                && (itemLeftWorldX+itemWidth > item.getWorldX())) {
            item.setVX(0);
        }
        if (item.getVY() > 0 && itemTopWorldY+itemHeight > item.getWorldY() &&
                itemTopWorldY < item.getWorldY()) {
            item.setVY(-item.getVY());
        }
        if (item.getVY() < 0 && itemTopWorldY < item.getWorldY()+Constant.BACKGROUND_TILE_SIZE &&
                itemTopWorldY+itemHeight > item.getWorldY()+Constant.BACKGROUND_TILE_SIZE) {
            item.setVY(0);
            item.setWorldY(itemTopWorldY - Constant.BACKGROUND_TILE_SIZE);
        }
    }
}
