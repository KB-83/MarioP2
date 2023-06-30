package logic.gamelogic.playerlogic;

import logic.gamestrucure.GameState;
import logic.levelstructure.Section;
import logic.modelstructure.backgroundobject.CheckPoint;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.entity.player.Player;
import logic.sound.Sound;
import util.Constant;

public class PlayerLifeChecker {
    private GameState gameState;
    private long lastKickTimeByEnemy;
    private Sound sound;
    public PlayerLifeChecker(GameState gameState) {
        this.gameState = gameState;
        sound = new Sound("HEART-LOOSE");
    }
    public void checkIfHurt() {

        if (gameState.getMario().getWorldY() > Constant.PANEL_ROWS * Constant.BACKGROUND_TILE_SIZE) {
            handleFalling();
        }
        if (gameState.getRemainingTime() < 0){
            handleOutOfTime();
        }

    }
    private void handleFalling(){
        decreaseHeart();
    }
    private void handleOutOfTime(){}
    public void handleEnemyCollide(Enemy enemy,String position){
        if (position.equals("DOWN")) {
            return;
//            pass to EnemyLifeChecker
        }
        else {
            //cool down
            if (System.currentTimeMillis() - lastKickTimeByEnemy >= 3000) {
                lastKickTimeByEnemy = System.currentTimeMillis();
                kickPlayer();
            }
        }
    }
    private void kickPlayer(){
        if (!gameState.getMario().isFire() && !gameState.getMario().isMega()) {
            decreaseHeart();
            return;
        }
        sound.setSound("KICK");
        if (gameState.getMario().isFire()){
            gameState.getMario().setFire(false);
            gameState.getMario().setMega(true);
            gameState.setMarioState(1);
        }

        else if (gameState.getMario().isMega()){
            gameState.getMario().setMega(false);
            gameState.setMarioState(0);
        }
        sound.play();
    }
    private void decreaseHeart(){
//        if (gameState.getRemainingHeart() <=1) {
//            killPlayer();
//            return;
//        }
        sound.setSound("HEART-LOOSE");
        sound.play();
        gameState.setRemainingHeart(gameState.getRemainingHeart() - 1);
        gameState.getMario().setMega(false);
        gameState.getMario().setFire(false);
        gameState.setMarioState(0);
        CheckPoint checkPoint = null;
        Section checkPointSection = null;
        int sectionNum = 0;
        int i = 0;
        for (Section section : gameState.getCurrentLevel().getSections()) {
            i++;
            if (section.getCheckPoint() != null && section.getCheckPoint().getSaved()) {
                checkPoint = section.getCheckPoint();
                checkPointSection = section;
                sectionNum = i;
            }
        }
        Player player = gameState.getMario();
        if (checkPoint != null) {
            gameState.getGameStateController().changeSection(checkPointSection,sectionNum);
            player.setWorldX(checkPoint.getCol() * Constant.BACKGROUND_TILE_SIZE);
            player.setWorldY(checkPoint.getRow() * Constant.BACKGROUND_TILE_SIZE);
            if(gameState.getCurrentSection().getLength() - checkPoint.getCol() - 3 >= Constant.PANEL_WIDTH/Constant.BACKGROUND_TILE_SIZE) {
                player.setCameraX(2 * Constant.BACKGROUND_TILE_SIZE);
//                    player.setCameraY();
            }
            else {
                player.setCameraX(player.getWorldX());
            }
        }
        else {
            player.setWorldX(0);
            player.setWorldY(7 * Constant.BACKGROUND_TILE_SIZE);
            player.setCameraX(0);
            gameState.getGameStateController().changeSection(gameState.getCurrentLevel().getSections()[0],1);
        }
    }
    private void killPlayer(){}
}
