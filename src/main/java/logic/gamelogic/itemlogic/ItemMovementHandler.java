package logic.gamelogic.itemlogic;

import logic.gamelogic.collisionlogic.EnemyCollisionHandler;
import logic.gamelogic.collisionlogic.ItemCollisionHandler;
import logic.gamestrucure.GameState;
import logic.gamestrucure.gameworldoption.Gravity;
import logic.modelstructure.entity.enemy.Enemy;
import logic.modelstructure.entity.item.Item;
import util.Constant;

public class ItemMovementHandler {
    private GameState gameState;

    public ItemMovementHandler(GameState gameState) {
        this.gameState = gameState;
    }
    public void updateItemsPosition() {
        for (Item item: gameState.getCurrentSection().getItems()) {
            item.getItemCollisionHandler().setSection(gameState.getCurrentSection());
            item.getItemCollisionHandler().applyCollisionEffects();
            item.setWorldX((int) (item.getWorldX()+(1.0/ Constant.FPS * item.getVX())));
            item.setWorldY((int) (item.getWorldY()+(1.0/Constant.FPS * item.getVY())));
            if (item.getOnTopOfBlock() == false) {
                item.setVY(item.getVY()+(1.0/Constant.FPS* Gravity.MARIO_GAME));
            }
            else {
                item.setVY(0);
            }

        }
    }
}
