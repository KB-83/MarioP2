package logic.gamelogic.playerlogic;

import logic.gamestrucure.GameState;
import logic.modelstructure.entity.item.Item;

public class PlayerItemEater {
    private GameState gameState;

    public PlayerItemEater(GameState gameState) {
        this.gameState = gameState;
    }

    public void eatItem(Item[] items, Item item, int index) {
        items[index] = null;
        String s = item.getClass().getSimpleName();
        switch (s) {
            case "Star":
                gameState.setScore(gameState.getScore() + 40);
                //
                break;
            case "Mushroom":
                gameState.setScore(gameState.getScore() + 30);
                int i = gameState.getMarioState();
                switch (i) {
                    case 0:
                        gameState.setMarioState(1);
                        gameState.getMario().setMega(true);
                        break;
                    case 1:
                        gameState.setMarioState(2);
                        gameState.getMario().setMega(false);
                        gameState.getMario().setFire(true);
                }
                break;
            case "Flower":
                gameState.setScore(gameState.getScore() + 20);
                i = gameState.getMarioState();
                switch (i) {
                    case 0:
                        gameState.setMarioState(1);
                        gameState.getMario().setMega(true);
                        break;
                    case 1:
                        gameState.setMarioState(2);
                        gameState.getMario().setMega(false);
                        gameState.getMario().setFire(true);
                        break;
                }
        }
        Item[] newItems = new Item[items.length-1];
        int i = 0;
        for (int j = 0 ; j < items.length ; j++){
            if(items[j] != null) {
                newItems[i] = items[j];
                i++;
            }
        }
        gameState.getCurrentSection().setItems(newItems);

    }
}
