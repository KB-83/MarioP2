package logic.gamelogic.collisionlogic;

import logic.gamestrucure.gameworldoption.collision.CollisionChecker;
import logic.gamestrucure.gameworldoption.collision.Rect;
import logic.levelstructure.Section;
import logic.modelstructure.backgroundobject.block.Block;
import logic.modelstructure.backgroundobject.pipe.Pipe;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.worldtiles.BackGroundTile;
import util.Constant;

public class EnemyCollisionHandler{

        //todo : improve this
        public boolean isHeat;
        private CollisionChecker collisionChecker;
        private Enemy enemy;
        private Enemy[] enemies;
        private Pipe[] pipes;
        private Block[] blocks;
        private BackGroundTile[][] backGroundTiles;
        private Rect blockRect = new Rect(0,48, 0,48);
        private Rect mainEnemyRect = new Rect(0,48, 0,48);
        private Rect enemyRect = new Rect(0,48, 0,48);
        private Rect pipeRect = new Rect(0,96,0,48*3);
        private Rect backgrounTileRect = new Rect(0,48,0,48);
        public EnemyCollisionHandler( Enemy enemy) {
            collisionChecker = new CollisionDetector(enemy);
            this.enemy = enemy;
        }
        public void setSection(Section section) {
            enemies = section.getEnemies();
            pipes = section.getPipes();
            blocks = section.getBlocks();
            backGroundTiles = section.getBackgroundMap().getBackGroundTiles();
        }
        public void updateSection(Section section) {
            enemies = section.getEnemies();
            pipes = section.getPipes();
            blocks = section.getBlocks();
        }
        public void applyCollisionEffects(){
            // blocks effects
//            if (blocks != null) {
            //todo : improve it
            enemy.setOnTopOfBlock(false);
                mainEnemyRect.updatePosition(enemy.getWorldX(), enemy.getWorldY());
                for (Block block : blocks) {
                    blockRect.updatePosition(block.getCol() * 48, block.getRow() * 48);
                    if (collisionChecker.didCollide(mainEnemyRect, blockRect)) {
                        enemy.setVX(-enemy.getVX());
                    }
//                        handelCollision(block.getCol() * Constant.BACKGROUND_TILE_SIZE, block.getRow() *
//                                Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE);
                    }
//                }
//            }
            //pipes
            mainEnemyRect.updatePosition(enemy.getWorldX(), enemy.getWorldY());
            if (pipes != null) {
                for (Pipe pipe : pipes) {
                    pipeRect.updatePosition(pipe.getCol() * 48, pipe.getRow() * 48);
//                    //todo give thebiigger rect first
                    if (collisionChecker.didCollide(mainEnemyRect, pipeRect)) {
                        if (enemy.getVX() > 0){
                            enemy.setWorldX(pipe.getCol()*  48  - 50);
                        }
                        if (enemy.getVX() < 0){
                            enemy.setWorldX(pipe.getCol()*48  + 98 );
                        }
                        enemy.setVX(-enemy.getVX());
//                        handelCollision(pipe.getCol() * Constant.BACKGROUND_TILE_SIZE, pipe.getRow() *
//                                Constant.BACKGROUND_TILE_SIZE, 2 * Constant.BACKGROUND_TILE_SIZE, 3 * Constant.BACKGROUND_TILE_SIZE);
                    }
                }
            }
//        enemies
            if (enemies != null) {
                mainEnemyRect.updatePosition(enemy.getWorldX(), enemy.getWorldY());
                for (Enemy enemy : enemies) {
                    enemyRect.updatePosition(enemy.getWorldX(), enemy.getWorldY());
                    if (collisionChecker.didCollide(mainEnemyRect, enemyRect)) {
                        enemy.setVX(-enemy.getVX());
//                        handelCollision(enemy.getWorldX(), enemy.getWorldY(), Constant.BACKGROUND_TILE_SIZE, Constant.BACKGROUND_TILE_SIZE);
//                        return;
                    }
                }
            }
            //background tiles todo: give a bound to background tiles
            mainEnemyRect.updatePosition(enemy.getWorldX(), enemy.getWorldY());
            for (int i = 0; i < backGroundTiles.length; i++){
                for (int j = 0;j < backGroundTiles[i].length;j++) {
                    if (backGroundTiles[i][j].isSolid()){
                        backgrounTileRect.updatePosition(j*48,i*48);
                        if(collisionChecker.didCollide(mainEnemyRect, backgrounTileRect)){
                            enemy.setVX(-enemy.getVX());
//                            handelCollision(j*48,i*48,48,48);
                        }
                    }
                }
            }
        }
        public void handelCollision(int itemLeftWorldX, int itemTopWorldY,int itemWidth,int itemHeight) {
            if (enemy.getVX() > 0 && itemLeftWorldX < enemy.getWorldX()+Constant.BACKGROUND_TILE_SIZE
                    && itemLeftWorldX+itemWidth  > enemy.getWorldX()+Constant.BACKGROUND_TILE_SIZE) {
                enemy.setVX(0);
            }
            if (enemy.getVX() < 0 && itemLeftWorldX < enemy.getWorldX()
                    && (itemLeftWorldX+itemWidth > enemy.getWorldX())) {
                enemy.setVX(0);
            }
            if (enemy.getVY() > 0 && itemTopWorldY+itemHeight > enemy.getWorldY() &&
                    itemTopWorldY < enemy.getWorldY()) {
                enemy.setVY(-enemy.getVY());
//                if (entity.isDuringJump()){
//                    entity.setDuringJump(false);
//                }
            }
            if (enemy.getVY() < 0 && itemTopWorldY < enemy.getWorldY()+Constant.BACKGROUND_TILE_SIZE &&
                    itemTopWorldY+itemHeight > enemy.getWorldY()+Constant.BACKGROUND_TILE_SIZE) {
                enemy.setVY(0);
                enemy.setWorldY(itemTopWorldY - Constant.BACKGROUND_TILE_SIZE);
//                entity.setCameraY(itemTopWorldY-Constant.BACKGROUND_TILE_SIZE);
//                if (entity.isDuringJump()){
//                    player.setDuringJump(false);
//                }
            }
        }


}
