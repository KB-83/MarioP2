package logic.modelcontroller;

import logic.LogicManager;
import logic.gamestrucure.Game;
import logic.gamestrucure.GameState;
import logic.gamestrucure.gameworldoption.Gravity;
import logic.gamestrucure.gameworldoption.collision.PlayerCollisionChecker;
import logic.modelstructure.entity.player.Mario;
import logic.modelstructure.entity.player.Player;
import util.Constant;
import util.Loop;

public class GameStateController {
    private GameState gameState;
    private Game game;
    public void update(){
        if (gameState.isPaused()) {
            return;
        }
        // this is gravity
        // todo : improve it
        if (gameState.getPlayer().isDuringJump() == false) {
            gameState.getPlayer().setVY(gameState.getPlayer().getVY()+ (-Gravity.MARIO_GAME*1/Constant.FPS));
        }
        //check collision
        gameState.getPlayerCollisionChecker().applyCollisionEffects();
        //playerUpdates
        if(gameState.getPlayer().getVX() < 0 && gameState.getPlayer().getCameraX() < 10){
            gameState.getPlayer().setVX(0);
        }
        gameState.getPlayer().setWorldX((int) (gameState.getPlayer().getWorldX()+(1.0/Constant.FPS * gameState.getPlayer().getVX())));
        if(gameState.getPlayer().getCameraX() < Constant.PANEL_WIDTH/2 || gameState.getPlayer().getVX() < 0) {
            gameState.getPlayer().setCameraX((int) (gameState.getPlayer().getCameraX()+(1.0/Constant.FPS * gameState.getPlayer().getVX())));
        }
        gameState.getPlayer().setWorldY((int) (gameState.getPlayer().getWorldY() - (1.0/Constant.FPS * gameState.getPlayer().getVY())));
        gameState.getPlayer().setCameraY((int) (gameState.getPlayer().getCameraY() - (1.0/Constant.FPS * gameState.getPlayer().getVY())));
    }
    public void changeSection() {
        if(gameState.getSectionNumber() < game.getLevels()[gameState.getLevelNumber()-1].getSections()[gameState.getSectionNumber()-1].getLength()) {
            gameState.setCurrentSection(game.getLevels()[gameState.getLevelNumber() - 1].getSections()[gameState.getSectionNumber() - 1 + 1]);
            gameState.setPlayerCollisionChecker(new PlayerCollisionChecker(game.getLevels()[gameState.getLevelNumber() - 1].
                    getSections()[gameState.getSectionNumber() - 1 + 1], gameState.getPlayer()));
            gameState.setSectionNumber(gameState.getSectionNumber() + 1);
            gameState.setRemainingTime(gameState.getCurrentSection().getTime());
            gameState.getPlayer().setCameraX(0);
            gameState.getPlayer().setWorldX(0);

        }
        else {
            //todo : add level changing method here
        }
    }
    private void changeLevel() {}
    public GameState createGameState(Game game, LogicManager logicManager) {
        this.game = game;
        GameState gameState = new GameState(this);
        //todo : let player use its own selected player :)
        Player player = new Mario();
        player.setWorldY(11 * 48);
        player.setCameraY(11 * 48);
        player.setImageAddress("Right1");
        gameState.setPlayer(player);
        gameState.setCurrentLevel(game.getLevels()[0]);
        gameState.setCurrentSection(game.getLevels()[0].getSections()[0]);
        gameState.setPlayerCollisionChecker(new PlayerCollisionChecker(game.getLevels()[0].getSections()[0],player));
        gameState.setCoins(0);
        gameState.setLevelNumber(1);
        gameState.setSectionNumber(1);
        gameState.setPaused(false);
        gameState.setRemainingHeart(game.getHearts());
        gameState.setRemainingTime(gameState.getCurrentSection().getTime());
        gameState.setScore(0);
        Loop gameLoop = new Loop(gameState,logicManager.getGraphicManager().getFrame()
                .getPanelsManagerCard().getGamePanel(), Constant.FPS);
        gameLoop.start();
        this.gameState = gameState;
        return gameState;
    }
}
