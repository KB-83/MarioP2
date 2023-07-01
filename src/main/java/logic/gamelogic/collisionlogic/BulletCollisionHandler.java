package logic.gamelogic.collisionlogic;


import logic.gamestrucure.GameState;
import logic.gamestrucure.gameworldoption.collision.CollisionChecker;
import logic.gamestrucure.gameworldoption.collision.Rect;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.entity.Bullet;
import logic.modelstructure.entity.enemy.Enemy;
import logic.tools.ObjectRemover;

public class BulletCollisionHandler implements CollisionHandler {

    //todo: improve collision checker boundery
    //todo : improve this
    private GameState gameState;
    private CollisionChecker collisionChecker;
    private Bullet bullet;
    private Enemy[] enemies;
    private Pipe[] pipes;
    private Block[] blocks;
    private Rect blockRect = new Rect(0,48, 0,48);
    private Rect pipeRect = new Rect(0,96,0,48*3);
    private Rect enemyRect = new Rect(0,48,0,48);
    private Rect bulletRect = new Rect(0,35,0,35);
    //todo: improve this too

    public BulletCollisionHandler(GameState gameState) {
        this.gameState = gameState;
//        enemies = gameState.getCurrentSection().getEnemies();
//        pipes = gameState.getCurrentSection().getPipes();
//        blocks = gameState.getCurrentSection().getBlocks();
    }
    public void applyCollisionEffects(){
        //todo : improve it
        if (bullet != null && bullet.isLock()){
            return;
        }
        if (collisionChecker == null){
            collisionChecker = new CollisionDetector(gameState.getMario().getSward());
            this.bullet = gameState.getMario().getBullet();
        }
        // block
        checkBlocksCollision();

        //pipes
        checkPipesCollision();

//        enemies
        checkEnemiesCollision();


    }

    @Override
    public void checkBlocksCollision() {
        bulletRect.updatePositionAndSize(bullet.getWidth(), bullet.getHeight(), bullet.getWorldX(), bullet.getWorldY());
        blocks = gameState.getCurrentSection().getBlocks();
        for (int i = 0; i < blocks.length ; i++) {
            Block block = blocks[i];
            blockRect.updatePosition(block.getCol() * 48, block.getRow() * 48);
            if (collisionChecker.didCollide(bulletRect, blockRect)) {
                bullet.setDidHeatBlock(true);
                return;
            }
        }
    }

    @Override
    public void checkPipesCollision() {
        bulletRect.updatePositionAndSize(bullet.getWidth(), bullet.getHeight(), bullet.getWorldX(), bullet.getWorldY());
        pipes = gameState.getCurrentSection().getPipes();
        if (pipes == null){
            return;
        }
        for (int i = 0; i < pipes.length ; i++) {
            Pipe pipe = pipes[i];
            pipeRect.updatePosition(pipe.getCol() * 48, pipe.getRow() * 48);
            if (collisionChecker.didCollide(bulletRect, pipeRect) && !collisionChecker.returnSamePoints(bulletRect,pipeRect).equals("DOWN")) {
                bullet.setDidHeatBlock(true);
                return;
            }
        }
    }

    @Override
    public void checkEnemiesCollision() {

        bulletRect.updatePositionAndSize(bullet.getWidth(), bullet.getHeight(), bullet.getWorldX(), bullet.getWorldY());
        enemies = gameState.getCurrentSection().getEnemies();
        if (enemies == null){
            return;
        }
        for (int i = 0; i < enemies.length ; i++) {
            Enemy enemy = enemies[i];
            enemyRect.updatePosition(enemy.getWorldX(), enemy.getWorldY());
            if (collisionChecker.returnSamePoints(bulletRect,enemyRect).equals("RIGHT") || collisionChecker.returnSamePoints(bulletRect,enemyRect).equals("LEFT") ||
                    (collisionChecker.didCollide(bulletRect, enemyRect) && !collisionChecker.returnSamePoints(bulletRect,enemyRect).equals("DOWN"))) {
                bullet.setDidHeatBlock(true);
                gameState.getCurrentSection().setEnemies(ObjectRemover.removeObjectFromArray(gameState.getCurrentSection().getEnemies(),enemy));
                return;
            }
        }
    }

    @Override
    public void checkBackgroundTilesCollision() {

    }

    @Override
    public void checkPlayerCollision() {

    }
}
