package logic.requsethandler;

import graphic.guigamestructure.GuiGameCreator;
import logic.LogicManager;
import logic.datahandler.Loader;
import logic.datahandler.Saver;
import logic.gamestrucure.Game;
import logic.gamestrucure.GameState;
import logic.levelstructure.Level;
import logic.levelstructure.Section;
import logic.modelstructure.entity.player.Mario;
import logic.modelstructure.entity.player.Player;
import logic.userstructure.User;
import util.Loop;


public class UserRequestHandler {
    private LogicManager logicManager;
    public UserRequestHandler(LogicManager logicManager){
        this.logicManager = logicManager;
    }
    public boolean loginRequest(String username, String password,UserRequestHandler userRequestHandler){
        User user = Loader.getLoader().loadUser(username);
        if (user != null){
            if (user.getPassword().equals(password)) {
                user.setUserRequestHandler(userRequestHandler);
                logicManager.setUser(user);
                logicManager.getGraphicManager().setUser(user);
                return true;
            }
            System.out.println("password is incorrect.");
        }
        return false;
    }
    public boolean signInRequest(String username, String password,UserRequestHandler userRequestHandler){
        User user = new User(username,password);
        boolean b = Saver.getSaver().saveUser(user);
        if (!b){
            return false;
        }
        user.setUserRequestHandler(userRequestHandler);
        // todo: load default gameAs a Config
        Game game = new Game();
        game.setName("default");
        Level level = new Level();
        level.setSections(new Section[]{new Section(1)});
        game.setLevels(new Level[]{level});

        Game[] games = {game};
        user.setGames(games);
        // todo : dont add game here
        logicManager.setUser(user);
//      todo: do the things

        return true;
    }
    public GameState newGameRequest(String gameName) {
        Game game = null;
        for (Game game1 :logicManager.getUser().getGames()){
            if (gameName.equals(game1.getName())){
                game = game1;
                break;
            }
        }
        // todo set game default
        if (game != null) {
            GameState gameState = new GameState();
            Player player = new Mario();
            player.setImageAddress("Left1");
            gameState.setPlayer(player);
            // todo: (lines start whit blue)next line is really dirty you can send it as a request to graphic
            logicManager.getGraphicManager().getFrame().getPanelsManagerCard().getGamePanel().setKeyListener(gameState);
            gameState.setCurrentLevel(game.getLevels()[0]);
            gameState.setCurrentSection(game.getLevels()[0].getSections()[0]);
            gameState.setCoins(0);
            gameState.setLevelNumber(1);
            gameState.setSectionNumber(1);
            gameState.setPaused(false);
            gameState.setRemainingHeart(game.getHearts());
            gameState.setRemainingTime(gameState.getCurrentSection().getTime());
            gameState.setScore(0);
            //todo ; this also
            logicManager.getGraphicManager().getFrame().getPanelsManagerCard().getGamePanel().setGuiGameState(GuiGameCreator.createGameState(gameState,null));
            Loop gameLoop = new Loop(gameState,logicManager.getGraphicManager().getFrame()
                    .getPanelsManagerCard().getGamePanel(),60);
            gameLoop.start();
            return gameState;
        }
        return null;
    }
}
