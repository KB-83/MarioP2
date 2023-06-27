package logic.gamelogic.collisionlogic;

import logic.gamestrucure.gameworldoption.collision.CollisionChecker;
import logic.gamestrucure.gameworldoption.collision.Rect;
import logic.levelstructure.Section;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.entity.item.Item;
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
    public ItemCollisionHandler(Item item) {
        collisionChecker = new CollisionDetector(item);
        this.item = item;
    }
    public void setSection(Section section) {
        enemies = section.getEnemies();
        pipes = section.getPipes();
        blocks = section.getBlocks();
        backGroundTiles = section.getBackgroundMap().getBackGroundTiles();
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
        for (Block block : blocks) {
            blockRect.updatePosition(block.getCol() * 48, block.getRow() * 48);
            if (collisionChecker.didCollide(itemRect, blockRect)) {
                item.setVX(-item.getVX());
            }
            if (collisionChecker.returnSamePoints(itemRect,blockRect).equals("DOWN")) {
                item.setOnTopOfBlock(true);
//                    // todo: improve it too
                item.setWorldY(blockRect.getTopY()-itemRect.getHeight());
                if (item.getVY() < 0) {
                    item.setVY(0);
                }
            }
//                        handelCollision(block.getCol() * Constant.BACKGROUND_TILE_SIZE, block.getRow() *
//                                Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE);
        }
    }

    @Override
    public void checkPipesCollision() {
        itemRect.updatePosition(item.getWorldX(), item.getWorldY());
        if (pipes != null) {
            for (Pipe pipe : pipes) {
                pipeRect.updatePosition(pipe.getCol() * 48, pipe.getRow() * 48);
//                    //todo give thebiigger rect first
                if (collisionChecker.didCollide(itemRect, pipeRect)) {
                    if (item.getVX() > 0){
                        item.setWorldX(pipe.getCol()*  48  - 50);
                    }
                    if (item.getVX() < 0){
                        item.setWorldX(pipe.getCol()*48  + 98 );
                    }
                    item.setVX(-item.getVX());
//                        handelCollision(pipe.getCol() * Constant.BACKGROUND_TILE_SIZE, pipe.getRow() *
//                                Constant.BACKGROUND_TILE_SIZE, 2 * Constant.BACKGROUND_TILE_SIZE, 3 * Constant.BACKGROUND_TILE_SIZE);
                }
                if (collisionChecker.returnSamePoints(itemRect,pipeRect).equals("DOWN")) {
                    item.setOnTopOfBlock(true);
//                    // todo: improve it too
                    item.setWorldY(pipeRect.getTopY()-itemRect.getHeight());
                    if (item.getVY() < 0) {
                        item.setVY(0);
                    }
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
                    enemy.setVX(-enemy.getVX());
//                        handelCollision(enemy.getWorldX(), enemy.getWorldY(), Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE);
//                        return;
                }
                if (collisionChecker.returnSamePoints(itemRect,enemyRect).equals("DOWN")) {
                    item.setOnTopOfBlock(true);
//                    // todo: improve it too
                    item.setWorldY(enemyRect.getTopY()-itemRect.getHeight());
                    if (item.getVY() < 0) {
                        item.setVY(0);
                    }
                }
            }
        }

    }

    @Override
    public void checkBackgroundTilesCollision() {
        itemRect.updatePosition(item.getWorldX(), item.getWorldY());
        for (int i = 0; i < backGroundTiles.length; i++){
            for (int j = 0;j < backGroundTiles[i].length;j++) {
                if (backGroundTiles[i][j].isSolid()){
                    backgrounTileRect.updatePosition(j*48,i*48);
                    if(collisionChecker.didCollide(itemRect, backgrounTileRect)){
                        item.setVX(-item.getVX());
//                            handelCollision(j*48,i*48,48,48);
                    }
                }
                if (collisionChecker.returnSamePoints(itemRect,backgrounTileRect).equals("DOWN")) {
                    item.setOnTopOfBlock(true);
//                    // todo: improve it too
                    item.setWorldY(backgrounTileRect.getTopY()-itemRect.getHeight());
                    if (item.getVY() < 0) {
                        item.setVY(0);
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
