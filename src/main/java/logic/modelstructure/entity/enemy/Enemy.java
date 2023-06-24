package logic.modelstructure.entity.enemy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import logic.gamelogic.collisionlogic.EnemyCollisionHandler;
import logic.modelstructure.entity.Entity;


public abstract class Enemy extends Entity {
    @JsonIgnore
    EnemyCollisionHandler enemyCollisionHandler;
    public Enemy() {
        setOnTopOfBlock(true);
    }

    public EnemyCollisionHandler getEnemyCollisionHandler() {
        return enemyCollisionHandler;
    }

    public void setEnemyCollisionHandler(EnemyCollisionHandler enemyCollisionHandler) {
        this.enemyCollisionHandler = enemyCollisionHandler;
    }
}
