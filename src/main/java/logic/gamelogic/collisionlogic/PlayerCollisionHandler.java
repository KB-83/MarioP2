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

public class PlayerCollisionHandler implements CollisionHandler{
    //todo: improve collision checker boundery
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
    //todo: improve this too
    private ItemUnlocker itemUnlocker;
    public PlayerCollisionHandler(Section section, Player player) {
        collisionChecker = new CollisionDetector(player);
        enemies = section.getEnemies();
        pipes = section.getPipes();
        blocks = section.getBlocks();
        backGroundTiles = section.getBackgroundMap().getBackGroundTiles();
        this.player = player;
        itemUnlocker = new ItemUnlocker();
    }
    public void updateSection(Section section) {
        enemies = section.getEnemies();
        pipes = section.getPipes();
        blocks = section.getBlocks();
    }
    public void applyCollisionEffects(){
        //todo : improve it
        if (player.getOnTopOfBlock() && player.getVY() < 0){
            player.setDuringJump(false);
        }
        player.setOnTopOfBlock(false);
        //
        // blocks effects
        checkBlocksCollision();

        //pipes
        checkPipesCollision();

//        enemies
        checkEnemiesCollision();
//
//        //background tiles todo: give a bound to background tiles
        checkBackgroundTilesCollision();

    }
    public void checkBlocksCollision(){
        playerRect.updatePositionAndSize(player.getWidth(), player.getHeight(),player.getWorldX(), player.getWorldY());
        for (int i = 0; i < blocks.length ; i++) {
            Block block = blocks[i];
            blockRect.updatePosition(block.getCol() * 48, block.getRow() * 48);
            if (collisionChecker.didCollide(playerRect, blockRect)) {
                handelCollision(block.getCol() * Constant.BACKGROUND_TILE_SIZE, block.getRow() *
                        Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE);
                if (block.getItem() != null) {
                    itemUnlocker.unlock(block,blocks,i);
                }
            }
        }
    }
    public void checkPipesCollision(){
        playerRect.updatePositionAndSize(player.getWidth(), player.getHeight(),player.getWorldX(), player.getWorldY());
        if (pipes != null) {
            for (Pipe pipe : pipes) {
                pipeRect.updatePosition(pipe.getCol() * 48, pipe.getRow() * 48);
                //todo give thebiigger rect first
                if (collisionChecker.didCollide(playerRect, pipeRect)) {
                    handelCollision(pipe.getCol() * Constant.BACKGROUND_TILE_SIZE, pipe.getRow() *
                            Constant.BACKGROUND_TILE_SIZE, 2 * Constant.BACKGROUND_TILE_SIZE, 3 * Constant.BACKGROUND_TILE_SIZE);
                }
            }
        }}
    public void checkEnemiesCollision(){
        if (enemies != null) {
            playerRect.updatePositionAndSize(player.getWidth(), player.getHeight(),player.getWorldX(), player.getWorldY());
            for (Enemy enemy : enemies) {
                enemyRect.updatePosition(enemy.getWorldX(), enemy.getWorldY());
                if (collisionChecker.didCollide(playerRect, enemyRect)) {
                    handelCollision(enemy.getWorldX(), enemy.getWorldY(), Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE);
                    return;
                }
            }
        }
    }
    public void checkBackgroundTilesCollision(){
        playerRect.updatePositionAndSize(player.getWidth(), player.getHeight(),player.getWorldX(), player.getWorldY());
        for (int i = 0; i < backGroundTiles.length; i++){
            for (int j = 0;j < backGroundTiles[i].length;j++) {
                if (backGroundTiles[i][j].isSolid()){
                    backgrounTileRect.updatePosition(j*48,i*48);
                    if(collisionChecker.didCollide(playerRect,backgrounTileRect)){
                        handelCollision(j*48,i*48,48,48);
                    }
                }
            }
        }}

    @Override
    public void checkPlayerCollision() {

    }

    public void handelCollision(int itemLeftWorldX, int itemTopWorldY,int itemWidth,int itemHeight) {
        if (player.getVX() > 0 && itemLeftWorldX < player.getWorldX()+ player.getWidth()
                && itemLeftWorldX+itemWidth  > player.getWorldX()+ player.getHeight()) {
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
        if (player.getVY() < 0 && itemTopWorldY < player.getWorldY()+ player.getHeight() &&
                itemTopWorldY+itemHeight > player.getWorldY()+ player.getHeight()) {
            player.setVY(0);
            player.setWorldY(itemTopWorldY - player.getHeight());
            player.setCameraY(itemTopWorldY- player.getHeight());
            if (player.isDuringJump()){
                player.setDuringJump(false);
            }
        }
    }

}
