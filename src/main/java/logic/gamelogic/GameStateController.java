package logic.gamelogic;

import logic.LogicManager;
import logic.datahandler.GameCloner;
import logic.datahandler.Saver;
import logic.gamelogic.enemieslogic.EnemyMovementHandler;
import logic.gamelogic.gravitylogic.GravityEffectsHandler;
import logic.gamelogic.itemlogic.ItemMovementHandler;
import logic.gamelogic.playerlogic.PlayerMovementHandler;
import logic.gamestrucure.Game;
import logic.gamestrucure.GameState;
import logic.gamelogic.collisionlogic.PlayerCollisionHandler;
import logic.levelstructure.Section;
import logic.modelstructure.entity.player.Mario;
import logic.modelstructure.entity.player.Player;
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
//            gameState.getSound().stop();
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
    public void nextSection() {
        if(gameState.getSectionNumber() < game.getLevels()[gameState.getLevelNumber()-1].getSections()[gameState.getSectionNumber()-1].getLength()) {
            gameState.setCurrentSection(game.getLevels()[gameState.getLevelNumber() - 1].getSections()[gameState.getSectionNumber() - 1 + 1]);
            gameState.setPlayerCollisionHandler(new PlayerCollisionHandler(gameState));
            gameState.setSectionNumber(gameState.getSectionNumber() + 1);
            gameState.setRemainingTime(gameState.getCurrentSection().getTime());
            gameState.getMario().setCameraX(0);
            gameState.getMario().setWorldX(0);

        }
        else {
            //todo : add level changing method here
        }
    }
    public void changeSection(Section section) {
        gameState.setCurrentSection(section);
        gameState.setPlayerCollisionHandler(new PlayerCollisionHandler(gameState));
//        gameState.setSectionNumber(gameState.getSectionNumber() + 1);
        gameState.setRemainingTime(gameState.getCurrentSection().getTime());
        gameState.getMario().setCameraX(0);
        gameState.getMario().setWorldX(0);
    }
    private void changeLevel() {}
    public GameState createGameState(Game game, LogicManager logicManager) {
        this.game = GameCloner.cloneGame(game);
        GameState gameState = new GameState(this);
        //todo : let player use its own selected player :)
        setGameStateDependencies(this.game, gameState,logicManager);
        setGameStateControllerDependencies(gameState);
        //todo : check if its good()
        startGameState(gameState,logicManager);
        this.gameState = gameState;
        return gameState;
    }
    public void startGameState(GameState gameState,LogicManager logicManager){
        //todo : doing gamestATE Timers run
        Loop gameLoop = new Loop(gameState,logicManager.getGraphicManager().getFrame()
                .getPanelsManagerCard().getGamePanel(), Constant.FPS);
        gameLoop.start();
    }
    private void setGameStateDependencies(Game game, GameState gameState,LogicManager logicManager) {
        gameState.setCurrentUser(logicManager.getUser());
        gameState.setLevels(game.getLevels());
        Mario mario = new Mario();
        mario.setWorldY(7 * 48);
        mario.setCameraY(7 * 48);
        mario.setImageAddress(game.getMarioState()+"Right1");
        mario.setWidth(Constant.BACKGROUND_TILE_SIZE);
        mario.setHeight(Constant.BACKGROUND_TILE_SIZE);
        if (game.getMarioState() > 0) {
            mario.setHeight(2 * mario.getHeight());
            mario.setWorldY(mario.getWorldY() - 48);
            mario.setCameraY(mario.getCameraY() - 48);
            if (game.getMarioState() == 1) {
                mario.setMega(true);
            }
            else {
                mario.setFire(true);
            }
        }
        //todo : sound test
//        gameState.setSound(new Sound());
//        gameState.getSound().setFile(0);
//        gameState.getSound().play();
        //
        gameState.setMarioState(gameState.getMarioState());
        gameState.setMario(mario);
        gameState.setCurrentLevel(game.getLevels()[0]);
        gameState.setCurrentSection(game.getLevels()[0].getSections()[0]);
        gameState.setPlayerCollisionHandler(new PlayerCollisionHandler(gameState));
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
    public void checkPointRequest(String s) {
        gameState.getMario().setVX(0);
        switch (s){
            case "Save CheckPoint":
                gameState.getWaitingCheckpoint().setSaved(true);
                //bla bla
                gameState.setPaused(false);
                GameState[] gameStates = {gameState};
                gameState.getCurrentUser().setSavedGames(gameStates);
                Saver.getSaver().saveUser(gameState.getCurrentUser(),false);
                break;
            case "Get Coins":
                System.out.println("gameState Controller 141");
                gameState.setWaitingCheckpoint(null);
                gameState.getCurrentSection().setCheckPoint(null);
//                bla bla
                gameState.setPaused(false);
                break;
        }
    }
}
