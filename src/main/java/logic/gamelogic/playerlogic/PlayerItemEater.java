package logic.gamelogic.playerlogic;

import logic.gamestrucure.GameState;
import logic.modelstructure.entity.item.Item;
import util.Sound;

public class PlayerItemEater {
    private GameState gameState;
    private Sound sound;

    public PlayerItemEater(GameState gameState) {
        this.gameState = gameState;
        sound = new Sound("POWER_UP");
    }

    public void eatItem(Item[] items, Item item, int index) {
        items[index] = null;
        String s = item.getClass().getSimpleName();
        switch (s) {
            case "Star":
                sound.setSound("POWER_UP");
                gameState.setScore(gameState.getScore() + 40);
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
            case "Mushroom":
                sound.setSound("POWER_UP");
                gameState.setScore(gameState.getScore() + 30);
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
                }
                break;
            case "Flower":
                sound.setSound("POWER_UP");
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
                break;
            case "Coin":
                sound.setSound("COIN");
                gameState.setScore(gameState.getScore() + 10);
                gameState.setCoins(gameState.getCoins()+1);
                break;
        }
        sound.play();
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

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }
}
