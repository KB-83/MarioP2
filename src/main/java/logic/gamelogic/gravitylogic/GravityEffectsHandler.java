package logic.gamelogic.gravitylogic;

import logic.gamestrucure.GameState;
import logic.gamestrucure.gameworldoption.Gravity;
import util.Constant;

public class GravityEffectsHandler {
    private GameState gameState;

    public GravityEffectsHandler(GameState gameState) {
        this.gameState = gameState;
    }
    public void applyEffects() {
        if (gameState.getPlayer().isDuringJump() == false && gameState.getPlayer().getOnTopOfBlock() == false) {
            gameState.getPlayer().setVY(gameState.getPlayer().getVY()+ (-Gravity.MARIO_GAME*1/ Constant.FPS));
//
        }
    }
}
