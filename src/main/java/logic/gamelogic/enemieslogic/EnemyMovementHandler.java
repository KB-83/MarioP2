package logic.gamelogic.enemieslogic;

import logic.gamelogic.collisionlogic.EnemyCollisionHandler;
import logic.gamestrucure.GameState;
import logic.gamestrucure.gameworldoption.Gravity;
import logic.modelstructure.entity.enemy.Enemy;
import util.Constant;

public class EnemyMovementHandler {
    private GameState gameState;

    public EnemyMovementHandler(GameState gameState) {
        this.gameState = gameState;
    }
    public void updateEnemiesPosition() {
        for (Enemy enemy: gameState.getCurrentSection().getEnemies()) {
            enemy.setEnemyCollisionHandler(new EnemyCollisionHandler(gameState.getCurrentSection(),enemy));
            enemy.getEnemyCollisionHandler().applyCollisionEffects();
            enemy.setWorldX((int) (enemy.getWorldX()+(1.0/ Constant.FPS * enemy.getVX())));
            enemy.setWorldY((int) (enemy.getWorldY()+(1.0/Constant.FPS * enemy.getVY())));
            if (enemy.getOnTopOfBlock() == false) {
                enemy.setVY(enemy.getVY()+(1.0/Constant.FPS* Gravity.MARIO_GAME));
            }
            else {
                enemy.setVY(0);
            }

        }
    }
}
