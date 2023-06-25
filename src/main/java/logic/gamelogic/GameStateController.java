package logic.gamelogic;

import logic.LogicManager;
import logic.gamelogic.enemieslogic.EnemyMovementHandler;
import logic.gamelogic.gravitylogic.GravityEffectsHandler;
import logic.gamelogic.itemlogic.ItemMovementHandler;
import logic.gamelogic.playerlogic.PlayerMovementHandler;
import logic.gamestrucure.Game;
import logic.gamestrucure.GameState;
import logic.gamelogic.collisionlogic.PlayerCollisionHandler;
import logic.modelstructure.entity.player.Mario;
import logic.modelstructure.entity.player.Player;
import logic.sound.Sound;
import util.Constant;
import util.Loop;

public class GameStateController {
    private GameState gameState;
    private Game game;
    private EnemyMovementHandler enemyMovementHandler;
    private PlayerMovementHandler playerMovementHandler;
    private GravityEffectsHandler gravityEffectsHandler;
    private ItemMovementHandler itemMovementHandler;

    public GameStateController() {

    }

    public void update(){
        //player updates
        if (gameState.isPaused()) {
            System.out.println("33 game state controller");
            gameState.getSound().stop();
            return;
        }
        // this is gravity
        // todo : improve it
        // todo : gamr logic can be handel here if you part it
        gravityEffectsHandler.applyEffects();
        //check collision
        gameState.getPlayerCollisionHandler().applyCollisionEffects();
        //playerUpdates
        playerMovementHandler.updatePlayerPosition();

        // enemies update
        enemyMovementHandler.updateEnemiesPosition();
        // item
        itemMovementHandler.updateItemsPosition();


    }
    public void changeSection() {
        if(gameState.getSectionNumber() < game.getLevels()[gameState.getLevelNumber()-1].getSections()[gameState.getSectionNumber()-1].getLength()) {
            gameState.setCurrentSection(game.getLevels()[gameState.getLevelNumber() - 1].getSections()[gameState.getSectionNumber() - 1 + 1]);
            gameState.setPlayerCollisionHandler(new PlayerCollisionHandler(game.getLevels()[gameState.getLevelNumber() - 1].
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
        setGameStateDependencies(game, gameState);
        setGameStateControllerDependencies(gameState);

        Loop gameLoop = new Loop(gameState,logicManager.getGraphicManager().getFrame()
                .getPanelsManagerCard().getGamePanel(), Constant.FPS);
        gameLoop.start();
        this.gameState = gameState;
        return gameState;
    }
    private void setGameStateDependencies(Game game, GameState gameState) {
        Player player = new Mario();
        player.setWorldY(11 * 48);
        player.setCameraY(11 * 48);
        player.setImageAddress("Right1");
        //todo : sound test
//        gameState.setSound(new Sound());
//        gameState.getSound().setFile(0);
//        gameState.getSound().play();
        //
        gameState.setPlayer(player);
        gameState.setCurrentLevel(game.getLevels()[0]);
        gameState.setCurrentSection(game.getLevels()[0].getSections()[0]);
        gameState.setPlayerCollisionHandler(new PlayerCollisionHandler(game.getLevels()[0].getSections()[0],player));
        gameState.setCoins(0);
        gameState.setLevelNumber(1);
        gameState.setSectionNumber(1);
        gameState.setPaused(false);
        gameState.setRemainingHeart(game.getHearts());
        gameState.setRemainingTime(gameState.getCurrentSection().getTime());
        gameState.setScore(0);
    }
    private void setGameStateControllerDependencies(GameState gameState) {

        enemyMovementHandler = new EnemyMovementHandler(gameState);
        playerMovementHandler = new PlayerMovementHandler(gameState);
        gravityEffectsHandler = new GravityEffectsHandler(gameState);
        itemMovementHandler = new ItemMovementHandler(gameState);
    }
}
