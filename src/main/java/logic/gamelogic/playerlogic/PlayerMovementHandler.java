package logic.gamelogic.playerlogic;

import logic.gamestrucure.GameState;
import util.Constant;

public class PlayerMovementHandler {
    private GameState gameState;

    public PlayerMovementHandler(GameState gameState) {
        this.gameState = gameState;
    }
    public void updatePlayerPosition() {
        if(gameState.getPlayer().getVX() < 0 && gameState.getPlayer().getCameraX() < 10){
            gameState.getPlayer().setVX(0);
        }
        gameState.getPlayer().setWorldX((int) (gameState.getPlayer().getWorldX()+(1.0/ Constant.FPS * gameState.getPlayer().getVX())));
        if(gameState.getPlayer().getCameraX() < Constant.PANEL_WIDTH/2 || gameState.getPlayer().getVX() < 0) {
            gameState.getPlayer().setCameraX((int) (gameState.getPlayer().getCameraX()+(1.0/Constant.FPS * gameState.getPlayer().getVX())));
        }
        gameState.getPlayer().setWorldY((int) (gameState.getPlayer().getWorldY() - (1.0/Constant.FPS * gameState.getPlayer().getVY())));
        gameState.getPlayer().setCameraY((int) (gameState.getPlayer().getCameraY() - (1.0/Constant.FPS * gameState.getPlayer().getVY())));
    }
}
