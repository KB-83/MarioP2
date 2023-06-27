package logic.modelstructure.entity.enemy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import logic.gamelogic.collisionlogic.EnemyCollisionHandler;
import logic.modelstructure.entity.Entity;


public abstract class Enemy extends Entity {
    @JsonIgnore
    private EnemyCollisionHandler enemyCollisionHandler;
    private boolean isAlive;
    public Enemy() {
        setOnTopOfBlock(true);
        enemyCollisionHandler = new EnemyCollisionHandler(this);
    }

    public EnemyCollisionHandler getEnemyCollisionHandler() {
        return enemyCollisionHandler;
    }

    public void setEnemyCollisionHandler(EnemyCollisionHandler enemyCollisionHandler) {
        this.enemyCollisionHandler = enemyCollisionHandler;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
